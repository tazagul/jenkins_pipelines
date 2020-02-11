pipeline {
  agent any
  stages {
    stage('stage1') {
      parallel {
        stage('stage1') {
          steps {
            echo 'hello'
          }
        }

        stage('test') {
          steps {
            sh 'echo "Hello"'
          }
        }

      }
    }

    stage('stage2') {
      steps {
        echo 'stage2'
      }
    }

    stage('stage3') {
      steps {
        echo 'stage3'
      }
    }

  }
}