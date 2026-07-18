pipeline {
    agent any
    tools {
        maven 'maven3'
        jdk 'jdk21'
    }
    environment {
        IMAGE_NAME = "student-api"
        CONTAINER_NAME = "student-api-container"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/nisa03-cloud/soc_practical.git'
            }
        }
        stage('Build with Maven') {
            steps {
                // Compile and package the Spring Boot app
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build the image from the Dockerfile
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }
        stage('Stop Old Container') {
            steps {
                // Ignore failure if no container is currently running
                bat 'docker stop %CONTAINER_NAME% || exit 0'
            }
        }
        stage('Remove Old Container') {
            steps {
                bat 'docker rm %CONTAINER_NAME% || exit 0'
            }
        }
        stage('Run New Container') {
            steps {
                bat 'docker run -d -p 8500:8500 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }
    }
    post {
        success {
            echo 'Deployment successful.'
        }
        failure {
            echo 'Pipeline failed — check console output.'
        }
    }
}