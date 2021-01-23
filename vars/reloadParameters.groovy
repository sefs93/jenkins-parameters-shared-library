//opts.reload_parameters
def call () {
    if (params.RELOAD_PARAMETERS1) {
        stage('Reload parameters') {
            currentBuild.displayName = 'RELOAD_PARAMETERS'
            currentBuild.result = 'ABORTED'
            error('RELOAD_PARAMETERS')
        }
    }
}