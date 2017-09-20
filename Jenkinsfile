UPSTREAM_TRIGGERS = getUpstreamTriggers([
    "common-dependencies",
    "common-messaging-parent"
])

properties([[
    $class: 'BuildBlockerProperty',
    blockLevel: 'GLOBAL',
    blockingJobs: UPSTREAM_TRIGGERS.replace(',', '\n'),
    scanQueueFor: 'ALL',
    useBuildBlocker: true
]])

pipeline {    
    triggers {
        upstream(upstreamProjects: UPSTREAM_TRIGGERS, threshold: hudson.model.Result.SUCCESS)
    }
    agent {
        node {
            label 'maven-builder'
            customWorkspace "workspace/${env.JOB_NAME}"
        }
    }
    environment {
        GITHUB_TOKEN = credentials('github-02')
    }
    options { 
        skipDefaultCheckout()
        buildDiscarder(logRotator(artifactDaysToKeepStr: '30', artifactNumToKeepStr: '5', daysToKeepStr: '30', numToKeepStr: '5'))
        timestamps()
        disableConcurrentBuilds()
    }
    tools {
        maven 'linux-maven-3.3.9'
        jdk 'linux-jdk1.8.0_102'
    }
    stages {
        stage('Checkout') {
            steps {
                doCheckout()
            }
        }
        stage('Build') {
            steps {
                script {
                    if (env.BRANCH_NAME ==~ /master|stable\/.*/) {
                        sh "mvn clean deploy -Dmaven.repo.local=.repo"
                    } else {
                        sh "mvn clean install -Dmaven.repo.local=.repo"
                    }
                }
            }
        }
        stage('Record Test Results') {
            steps {
                junit '**/target/*-reports/*.xml'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                doSonarAnalysis()    
            }
        }
        stage('Third Party Audit') {
            steps {
                doThirdPartyAudit()
            }
        }
        stage('PasswordScan') {
            steps {
                doPwScan()
            }
        }
        stage('Github Release') {
            steps {
                githubRelease()
            }
        }
        stage('NexB Scan') {
            steps {
                doNexbScanning()
            }
        }
    }
    post {
        always {
            cleanWorkspace()   
        }
        success {
            successEmail()
        }
        failure {
            failureEmail()
        }
    }
}
