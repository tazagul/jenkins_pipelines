node {
    properties([parameters([choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'Please select a region ', name: 'AMI_REGION')])])
    
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