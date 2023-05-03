pipeline {
  agent {
    node {
      label 'master'
    }

  }
  stages {
    stage('maven') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /root/.m2:/root/.m2'
        }

      }
      steps {
        echo 'start clean'
        sh 'mvn clean install'
      }
    }

    stage('Run Coverity') {
      agent any
      steps {
        withCoverityEnvironment(coverityInstanceUrl: 'http://10.107.85.94', createMissingProjectsAndStreams: true, projectName: 'blue-ocean-rps', streamName: 'blue-ocean-rps')
      }
    }

  }
}