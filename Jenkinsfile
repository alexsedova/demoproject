node {
    stage('Clone and checkout') {
        checkout scm
    }

    stage('Build') {
        printInfo()
        sh 'gradle build'
    }
    
    stage("Test") {
    	println "test"
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

