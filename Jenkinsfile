properties([
    pipelineTriggers([
        upstream(threshold: hudson.model.Result.SUCCESS, upstreamProjects: 'endpoint-registration-api-master'),
        upstream(threshold: hudson.model.Result.SUCCESS, upstreamProjects: 'hdp-capability-registry-client-master'),
        upstream(threshold: hudson.model.Result.SUCCESS, upstreamProjects: 'symphony-root-parent-master')
  ])
])
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
                withMaven(){
                    sh "mvn clean test"
                }
            }
        }
        stage('Deploy') {
            steps {
                withMaven(){
                    sh "mvn deploy"
                }
            }
        }
    }
}