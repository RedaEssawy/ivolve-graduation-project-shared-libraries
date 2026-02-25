def call(Map params) {
    def manifestsRepo = params.manifestsRepo
    def branch = params.branch
    def credentialsId = params.credentialsId
    def commitMessage = params.commitMessage ?: 'Update manifests'
    
    dir('manifests') {
        sh """
            git config user.email "jenkins@example.com"
            git config user.name "Jenkins CI"
            git add .
            git commit -m "${commitMessage}" || echo "No changes to commit"
            git push origin ${branch}
        """
    }
}