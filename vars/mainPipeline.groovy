//opts.service
//opts.version
//opts.country
//opts.env
//opts.region
def call (Map opts) {
    node {
        stage ('Deploy') {
            def env_properties = getEnvironmentProperties(country: opts.country, env: opts.env, region: opts.region)
            println '=========================================================================================='
            println "[INFO] Deploying service:\t${opts.service}:${opts.version}"
            println "[INFO] country:\t\t\t${opts.country}"
            println "[INFO] opts.env:\t\t${opts.env}"
            println "[INFO] opts.region:\t\t${opts.region}"
            println "[INFO] Credentials:\t\t${env_properties['creds']}"
            println "[INFO] Project ID:\t\t${env_properties['project_id']}"
            println '=========================================================================================='
        }
    }
}