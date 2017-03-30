pipeline {
    agent {
        label 'maven-builder'
    }

    tools {
        maven 'linux-maven-3.3.9'
        jdk 'linux-jdk1.8.0_102'
    }
    stages {
        stage('Test') {
            steps {
                mavenBuild(
                    pom: 'pom.xml',
                    goals: 'clean test'
                )
            }
        }
        stage('Deploy') {
            steps {
                mavenBuild(
                    pom: 'pom.xml',
                    goals: 'deploy'
                )
            }
        }
    }
}