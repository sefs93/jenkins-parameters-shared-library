def call () {
    def get = new URL("https://raw.githubusercontent.com/sefs93/jenkins-parameters-env-properties/master/env_props.json").openConnection()
    def data = get.getInputStream().getText()
    def environment_properties = new groovy.json.JsonSlurper().parseText(data)

    return environment_properties
}
