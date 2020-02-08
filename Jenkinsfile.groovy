node {
    properties([parameters([choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'Please select a region ', name: 'AMI_REGION')])])
    
    stage("Pull Repo"){
        git 'https://github.com/farrukh90/packer.git'
    }
     stage("Build Image"){
        sh "packer version"
        //sh "packer build -var region=${AMI_REGION} tools/jenkins_example.json"
        
    }
     stage("Send Notificatons to Slack"){
        slackSend channel: 'nagios_alerts', message: 'Golden AMI has been build'
    }
     stage("Send Email"){
        mail bcc: '', body: '''Hello 
Your AMI is ready in us-east-1
Thanks''', cc: '', from: '', replyTo: '', subject: 'Golden AMI has been build', to: 'kumarova.t@gmail.com'
    }
}