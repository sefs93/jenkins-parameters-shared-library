def call () {
    if (params.RELOAD_PARAMETERS) {
        stage('Reload parameters') {
            currentBuild.displayName = 'RELOAD_PARAMETERS'
            currentBuild.result = 'ABORTED'
            error('RELOAD_PARAMETERS')
        }
    }
}