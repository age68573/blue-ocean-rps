pipeline {
  agent any
  stages {
    stage('maven') {
      agent {
        docker {
          args '-v /root/.m2:/root/.m2'
          image 'maven:3-alpine'
        }

      }
      steps {
        echo 'start clean'
        sh 'mvn clean install'
      }
    }

    stage('Run Coverity') {
      agent {
        node {
          label 'master'
        }

      }
      steps {
        withCoverityEnvironment(coverityInstanceUrl: 'http://10.107.85.94', createMissingProjectsAndStreams: true, projectName: 'blue-ocean-rps', streamName: 'blue-ocean-rps')
      }
    }

  }
}