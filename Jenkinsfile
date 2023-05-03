pipeline {
  agent {
    node {
      label 'master'
    }

  }
  stages {
    stage('maven') {
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