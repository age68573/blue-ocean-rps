pipeline {
  agent {
    node {
      label 'master'
    }

  }
  tools {
        maven 'apache-maven-3.0.1' 
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
        sh 'mvn --version'
        withCoverityEnvironment(coverityInstanceUrl: 'http://10.107.85.94:8080', createMissingProjectsAndStreams: true, projectName: 'blue-ocean-rps', streamName: 'blue-ocean-rps', credentialsId: 'Coverity94', viewName: 'Outstanding Issues') {
          sh '''
echo ${cov-idir}
ls
echo "start Cpature ....."
cov-build --dir ${cov-idir} mvn clean package
echo "list capture ....."
coverity list
echo "start analyze ....."
cov-analyze --dir ${cov-idir}
echo ${COV_URL}
cov-commit-defects --dir ${cov-idir} --url ${COV_URL} --stream ${COV_STREAM} --auth-key-file ${COV_AUTH_KEY_PATH}'''
        }

      }
    }

    stage('Coverity results') {
      steps {
        coverityIssueCheck(coverityInstanceUrl: 'http://10.107.85.94:8080', credentialsId: 'Coverity94', projectName: 'blue-ocean-rps', viewName: 'Outstanding Issues', returnIssueCount: true, markUnstable: true)
      }
    }

    stage('BlackDuck') {
      steps {
        synopsys_detect(returnStatus: true, detectProperties: '--blackduck.trust.cert=true --detect.risk.report.pdf=false --detect.project.version.name=1 --detect.project.name=blue-ocean-rps  --detect.maven.build.command=package  --detect.cleanup=true --detect.maven.path=/opt/maven/bin/mvn --detect.blackduck.signature.scanner.snippet.matching=NONE --detect.excluded.directories=idir')
      }
    }

    stage('CodeDX') {
      agent {
        node {
          label 'master'
        }

      }
      steps {
        step([$class: 'CodeDxPublisher', analysisName: 'Build #${BUILD_NUMBER}', analysisResultConfiguration: [failureOnlyNew: false, failureSeverity: 'None', numBuildsInGraph: 0, policyBreakBuildBehavior: 'NoAction', unstableOnlyNew: false, unstableSeverity: 'None'], baseBranchName: 'main', key: 'api-key:hkZpD1V2WEpsMjC-cGjr5C24B2HDtvbp9FR4HQ5f', projectId: '3', selfSignedCertificateFingerprint: '', sourceAndBinaryFiles: '**', targetBranchName: 'blue-ocean', url: 'http://10.107.85.95:81/codedx'])
      }
    }

  }
}
