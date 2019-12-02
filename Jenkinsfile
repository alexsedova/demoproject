pipeline {
    agent any
    stages {
        stage ('Clone') {
            steps {
                checkout scm
            }
        }
        stage ('Build') {
            steps {
                sh 'gradle build'
             }
        }
        stage ('Test') {
             steps {
                sh 'gradle test'
             }
        }
    }
    post {
        always {
            script {
                if(env.BRANCH_NAME == 'master') {
                    echo 'I built on master'
                } else {
                    echo "I built on ${env.BRANCH_NAME}"
                }
            }
        }
    }
}
