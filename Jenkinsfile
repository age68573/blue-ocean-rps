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
        sh '"mvn -B -DskipTests clean package"'
        echo 'start validate'
        sh '"mvn validate"'
        echo 'start package'
        sh '"mvn package"'
      }
    }

  }
}