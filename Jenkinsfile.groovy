node {
    stage("Pull Repo"){
        echo "Hello"
    }
     stage("Build Image"){
        sh "packer version"
    }
     stage("Send Notificatons to Slack"){
        echo "Hello"
    }
     stage("Send Email"){
        echo "Hello"
    }
}