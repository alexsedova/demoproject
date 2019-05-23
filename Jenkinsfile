node {

    stage('Clone and checkout') {
        checkout scm
    }

    stage('Build') {
        if(env.BRANCH_NAME == 'master') {
            echo "I'm going to build on master"
        } else {
            echo "I'm going to build on ${env.BRANCH_NAME}"
        }
        sh 'gradle build'
    }
}

