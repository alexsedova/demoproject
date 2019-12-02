@Library('common-library') _
pipeline {
    agent any
    stages {
        stage('one') {
            steps {
                script {
                    echo printMessage([message : 'Blaa'])
                }
            }
        }
        stage('two') {
            steps {
                script{
                    testMethod()
                }
            }
        }
        stage('three') {
            steps {
                script{
                    runTask()
                }
            }
        }
    }
}