
pipeline {
    agent any
    stages {
        stage('Clone and checkout') {
            steps {
                checkout scm
            }
        }

        stage('build') {
            steps {
                sh "echo 'kalle anka sitter på en planka'"
            }
        }
    }
    post {
        always {
            echo "pipeline run"
        }
        failure{
            echo "Ooops"
        }
    }
}

def printInfo() {
    def message
    if(env.BRANCH_NAME == 'master') {
        message = "I'm going to build on master"
    } else {
        message = "I'm going to build on ${env.BRANCH_NAME}"
    }
    return message
}

