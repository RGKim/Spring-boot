pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                    git url: 'https://github.com/ArturMartini/user-micro-service.git'
                    withMaven(
                        maven: 'Maven',
                        jdk: 'JDK8')
                    {
                    	sh "mvn clean install"
                    	sh "docker build -f Dockerfile -t user-microservice ."
                    	sh "docker run -p 8082:8082 user-microservice &"
                    }
                }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}	
