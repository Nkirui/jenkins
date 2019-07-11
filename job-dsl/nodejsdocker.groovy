job('NodeJS Docker example') {
    scm {
        git('https://github.com/Nkirui/jenkins.git') {  node -> // is hudson.plugins.git.GitSCM
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
        dockerBuildAndPublish {
            repositoryName('nkirui2030/nodejsjenkins')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
