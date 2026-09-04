pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            echo 'Test execution completed'
        }

        success {
            echo 'Automation tests PASSED'
        }

        failure {
            echo 'Automation tests FAILED'
        }
    }
}