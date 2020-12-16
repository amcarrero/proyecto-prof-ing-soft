pipeline {
  agent any
  stages {
    stage('Install') {
      steps {
        sh 'mvn -f ./Proyecto/pom.xml install'
        sh 'mvn -f ./Proyecto/pom.xml clean'
      }
    }

  }
}