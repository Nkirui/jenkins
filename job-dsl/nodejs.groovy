job('NodeJS example') {
    scm {
        git('https://github.com/Nkirui/docker-jenkins.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Nkirui')
            node / gitConfigEmail('nathankirui5@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
