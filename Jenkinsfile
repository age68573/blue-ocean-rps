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
        sh 'mvn --version'
      }
    }

  }
}