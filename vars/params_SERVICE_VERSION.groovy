def call() {
    return [$class: 'CascadeChoiceParameter',
        choiceType: 'PT_SINGLE_SELECT',
        description: '',
        filterLength: 3,
        filterable: true,
        name: 'SERVICE_VERSION',
        randomName: 'choice-parameter-1083368143661600',
        referencedParameters: 'SERVICE_NAME',
        script: [$class: 'GroovyScript',
            fallbackScript:[
                classpath: [],
                sandbox: false,
                script: ''
            ],
            script: [
                classpath: [],
                sandbox: false,
                script: '''def command = "ls -1t /var/lib/jenkins/userContent/services/\${SERVICE_NAME}/"
                def proc = command.execute()
                proc.waitFor()

                def output = proc.in.text

                return output.tokenize()
                '''
            ]
        ]
    ]
}
