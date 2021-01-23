def call() {
    def param_script = """def data = '''${groovy.json.JsonOutput.prettyPrint(groovy.json.JsonOutput.toJson(_envProperties()))}'''
    def param_values = new ArrayList<>(new groovy.json.JsonSlurper().parseText(data).keySet())
    return param_values
    """
    return [$class: 'CascadeChoiceParameter',
        choiceType: 'PT_SINGLE_SELECT',
        description: '',
        filterLength: 3,
        filterable: true,
        name: 'COUNTRY',
        randomName: 'choice-parameter-1044468143661600',
        referencedParameters: '',
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
