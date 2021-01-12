//opts.reload_parameters
def call (Map opts) {
    try {
        if (opts.reload_parameters == 'true') {
            stage('Reload parameters') {
                currentBuild.result = 'ABORTED'
            }
        }
    } catch (e) {
        println "[WARN] RELOAD_PARAMETERS parameter is not defined yet. Skipping"
    }
}