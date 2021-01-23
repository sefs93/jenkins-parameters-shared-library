def call() {
    return [$class: 'ChoiceParameter',
        choiceType: 'PT_SINGLE_SELECT',
        description: '',
        filterLength: 3,
        filterable: true,
        name: 'SERVICE_NAME',
        randomName: 'choice-parameter-1083368168661600',
        script: [$class: 'GroovyScript',
            fallbackScript:[
                classpath: [],
                sandbox: false,
                script: ''
            ],
            script: [
                classpath: [],
                sandbox: false,
                script: '''def command = 'ls -1t /var/lib/jenkins/userContent/services/'
                def proc = command.execute()
                proc.waitFor()

                def output = proc.in.text

                return output.tokenize()
                '''
            ]
        ]
    ]
}
