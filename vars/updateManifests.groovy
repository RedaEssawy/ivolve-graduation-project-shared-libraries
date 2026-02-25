def call(Map params) {
    def manifestsRepo = params.manifestsRepo
    def branch = params.branch
    def imageName = params.imageName
    def newTag = params.newTag
    def deploymentFile = params.deploymentFile
    def credentialsId = params.credentialsId
    
    dir('manifests') {
        // Clone the manifests repository
        git branch: branch, url: manifestsRepo, credentialsId: credentialsId
        
        // Update the image tag in deployment.yaml
        sh """
            sed -i "s|image: ${imageName}:.*|image: ${imageName}:${newTag}|g" ${deploymentFile}
        """
    }
}