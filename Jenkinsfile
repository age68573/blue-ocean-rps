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
          sh '''sh "echo ${COVERITY_TOOL_HOME}"
sh "echo ${cov-idir}"
sh "ls"
sh "echo "start Cpature ....." "
sh " cov-capture --dir ${cov-idir} --source-dir ./"
sh "echo "list capture .....""
sh "coverity list"
sh "echo "start analyze .....""
sh "cov-analyze --dir ${cov-idir}"
'''
        }

        sh '''dir(${cov-idir}) {
        deleteDir()
      }'''
        }
      }

    }
  }