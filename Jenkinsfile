pipeline {
    agent any

    tools {
        // Must match the name of the JDK configured under 'Manage Jenkins' -> 'Global Tool Configuration'
        jdk 'JDK23'
        // Must match the name of the Maven tool configured under 'Global Tool Configuration'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean & Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    // Collect JUnit test reports if you have test cases
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package Jar') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
            // Archive the executable JAR artifact
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
        failure {
            echo 'Build failed.'
        }
    }
}