node {
    stage ("Pull Repo"){
    git 'https://github.com/tazagul/terraform-iaac-eks-burak.git'     
    }
    stage ("stage1"){
        sh "terraform version"

    }
    stage ("stage1"){
        echo "Hello"
    }
    stage ("stage1"){
        echo "Hello"
    }
}