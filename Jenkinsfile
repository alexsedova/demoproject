def execute() {
    node {
        checkout scm
        stage('Build') {
            if(env.BRANCH_NAME == 'master') {
                echo "I'm going to build master"
            } else {
                echo "I'm building ${env.BRANCH_NAME}"
            }
            sh 'gradle build'
        }
    }
}
return this
