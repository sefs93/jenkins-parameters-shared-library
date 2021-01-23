//opts.reload_parameters
def call () {
    try {
        if (params.RELOAD_PARAMETERS1) {
            stage('Reload parameters') {
                currentBuild.displayName = 'RELOAD_PARAMETERS'
                currentBuild.result = 'ABORTED'
                error('RELOAD_PARAMETERS')
            }
        }
    } catch (e) {
        println e
        println "[WARN] RELOAD_PARAMETERS parameter is not defined yet. Skipping"
    }
}