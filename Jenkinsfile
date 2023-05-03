pipeline {
  agent any
  stages {
    stage('maven') {
      steps {
        echo 'start clean'
        sh '"mvn -B -DskipTests clean package"'
        echo 'start validate'
        sh '"mvn validate"'
        echo 'start package'
        sh '"mvn package"'
      }
    }

  }
}