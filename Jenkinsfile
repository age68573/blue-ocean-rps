pipeline {
  agent any
  stages {
    stage('maven') {
      steps {
        echo 'start clean'
        sh '"mvn clean"'
        echo 'start validate'
        sh '"mvn validate"'
        echo 'start package'
        sh '"mvn package"'
      }
    }

  }
}