//opts.reload_parameters
def call () {
    try {
        if (params.RELOAD_PARAMETERS) {
            stage('Reload parameters') {
                currentBuild.displayName = 'RELOAD_PARAMETERS'
                currentBuild.result = 'ABORTED'
            }
        }
    } catch (e) {
        println "[WARN] RELOAD_PARAMETERS parameter is not defined yet. Skipping"
    }
}