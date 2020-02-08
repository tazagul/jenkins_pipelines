node {
   properties([parameters([
       choice(choices: ['golden_ami', 'tower', 'elk', 'nagios', 'gitlab', 'nexus', 'vault'], description: 'please choose ', name: 'TOOL_TO_PROVISION'), 
       choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'choose region', name: 'AMI_REGION')])])
    stage("Pull Repo"){
        git 'https://github.com/farrukh90/packer.git'
    }
     stage("Build Image"){
        sh "packer version"
        //sh "packer build -var region=${AMI_REGION} tools/${TOOL_TO_PRIVISION}.json"
        
    }
     stage("Send Notificatons to Slack"){
        slackSend channel: 'nagios_alerts', message: "${TOOL_TO_PROVISION} has been built"
    }
     stage("Send Email"){
        mail bcc: '', 
        body: "Hello, Your AMI is ready in ${AMI_REGION} Thanks", 
        cc: '', 
        from: '', 
        replyTo: '', 
        subject: "${TOOL_TO_PROVISION} has been built", 
        to: 'kumarova.t@gmail.com'
    }
}