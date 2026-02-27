def call(Map params) {
    def manifestsRepo = params.manifestsRepo
    def branch = params.branch
    def credentialsId = params.credentialsId
    def commitMessage = params.commitMessage ?: 'Update manifests'
    
    dir('manifests') {
        sh """
            git config --global user.email "redaessawy81@gmail.com"
            git config --global user.name "RedaEssawy"
            git add .
            git commit -m "${commitMessage}" || echo "No changes to commit"
            git push origin ${branch}
        """
    }
}