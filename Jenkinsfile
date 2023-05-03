pipeline {
  agent any
  stages {
    stage('maven') {
      steps {
        echo 'start validate'
        sh 'mvn validate'
        echo 'start package'
        sh 'mvn package'
      }
    }

  }
}