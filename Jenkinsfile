pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
				bat "docker build -t='terrofan/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
				withCredentials([usernamePassword(credentialsId: 'dockerhub_creds'), passwordVariable: 'pass', usernameVariable: 'user'])
				bat "docker login --username=${user}" --password=${pass}
				bat "docker push terrofan/selenium-docker:latest"
            }
        }
    }
}