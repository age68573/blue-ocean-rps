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
        sh '''mvn --version
'''
      }
    }

    stage('Run Coverity') {
      agent any
      steps {
        withCoverityEnvironment(coverityInstanceUrl: 'http://10.107.85.94:8080', createMissingProjectsAndStreams: true, projectName: 'blue-ocean-rps', streamName: 'blue-ocean-rps', credentialsId: 'Coverity94') {
          sh '''
echo ${cov-idir}
ls
echo "start Cpature ....."
cov-capture --dir ${cov-idir} --source-dir ./
echo "list capture ....."
coverity list
echo "start analyze ....."
cov-analyze --dir ${cov-idir}
echo ${COV_URL}
cov-commit-defects --dir ${cov-idir} --url ${COV_URL} --stream ${COV_STREAM}'''
        }

        sh '''ls
'''
      }
    }

  }
}