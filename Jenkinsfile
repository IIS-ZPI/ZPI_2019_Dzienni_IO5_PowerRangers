pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean'
        sh 'mvn compile'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
  }
}
