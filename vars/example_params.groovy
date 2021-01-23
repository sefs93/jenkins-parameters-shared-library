def call (String param) {
    def param_script = ''
    def param_name = param
    def param_randomName = 'choice-parameter-' + param
    def param_referencedParameters = ''
    switch(param) { 
        case 'COUNTRY': 
            param_script = """def get = new URL("https://raw.githubusercontent.com/sefs93/jenkins-parameters-env-properties/master/env_props.json").openConnection()
            def data = get.getInputStream().getText()
            def param_values = new ArrayList<>(new groovy.json.JsonSlurper().parseText(data).keySet())
            return param_values
            """
            break
        case 'ENVIRONMENT': 
            param_referencedParameters = 'COUNTRY'
            param_script = """def get = new URL("https://raw.githubusercontent.com/sefs93/jenkins-parameters-env-properties/master/env_props.json").openConnection()
            def data = get.getInputStream().getText()
            def param_values = new ArrayList<>(new groovy.json.JsonSlurper().parseText(data)[COUNTRY].keySet())
            return param_values
            """
            break
        case 'REGION': 
            param_referencedParameters = 'COUNTRY,ENVIRONMENT'
            param_script = """def get = new URL("https://raw.githubusercontent.com/sefs93/jenkins-parameters-env-properties/master/env_props.json").openConnection()
            def data = get.getInputStream().getText()
            def param_values = new ArrayList<>(new groovy.json.JsonSlurper().parseText(data)[COUNTRY][ENVIRONMENT].keySet())
            return param_values
            """
            break
        case 'RELOAD_PARAMETERS': 
            return booleanParam(name: param_name, defaultValue: false)
        case 'SERVICE_NAME': 
            param_script = '''def command = 'ls -1t /var/lib/jenkins/userContent/services/'
            def proc = command.execute()
            proc.waitFor()

            def output = proc.in.text

            return output.tokenize()
            '''
            break
        case 'SERVICE_VERSION': 
            param_referencedParameters = 'SERVICE_NAME'
            param_script = '''def command = "ls -1t /var/lib/jenkins/userContent/services/\${SERVICE_NAME}/"
            def proc = command.execute()
            proc.waitFor()

            def output = proc.in.text

            return output.tokenize()
            '''
            break
        default:
            param_script = "return ['NO_IMPLEMENTATION']"
            break
    }
    return [$class: 'CascadeChoiceParameter',
        choiceType: 'PT_SINGLE_SELECT',
        description: '',
        filterLength: 3,
        filterable: true,
        name: param_name,
        randomName: param_randomName,
        referencedParameters: param_referencedParameters,
        script: [$class: 'GroovyScript',
            fallbackScript:[
                classpath: [],
                sandbox: false,
                script: ''
            ],
            script: [
                classpath: [],
                sandbox: false,
                script: param_script
            ]
        ]
    ]
}