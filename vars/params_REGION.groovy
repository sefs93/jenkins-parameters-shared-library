def call() {
    def param_script = """def data = '''${groovy.json.JsonOutput.prettyPrint(groovy.json.JsonOutput.toJson(_envProperties()))}
    def param_values = new ArrayList<>(new groovy.json.JsonSlurper().parseText(data)[COUNTRY][ENVIRONMENT].keySet())
    return param_values
    """
    return [$class: 'CascadeChoiceParameter',
        choiceType: 'PT_SINGLE_SELECT',
        description: '',
        filterLength: 3,
        filterable: true,
        name: 'REGION',
        randomName: 'choice-parameter-1044468999661600',
        referencedParameters: 'COUNTRY,ENVIRONMENT',
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
