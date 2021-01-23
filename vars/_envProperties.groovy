def call () {
    def environment_properties = [
        'USA': [
            'dev': [
                'us-east-1': [
                    'project_id': 'some-dev-us-east-1-project',
                    'creds': 'some-dev-us-east-1-creds'
                ]
            ],
            'qa': [
                'us-east-1': [
                    'project_id': 'some-qa-us-east-1-project',
                    'creds': 'some-qa-us-east-1-creds'
                ]
            ],
            'uat': [
                'us-east-1': [
                    'project_id': 'some-uat-us-east-1-project',
                    'creds': 'some-uat-us-east-1-creds'
                ],
                'us-west-1': [
                    'project_id': 'some-uat-us-west-1-project',
                    'creds': 'some-uat-us-west-1-creds'
                ]
            ]
        ],
        'AUS': [
            'dev': [
                'au-north-1': [
                    'project_id': 'some-dev-au-north-1-project',
                    'creds': 'some-dev-au-north-1-creds'
                ]
            ],
            'qa': [
                'au-north-1': [
                    'project_id': 'some-qa-au-north-1-project',
                    'creds': 'some-qa-au-north-1-creds'
                ]
            ],
        ],
        'MEX': [
            'uat': [
                'sa-west-1': [
                    'project_id': 'some-uat-sa-west-1-project',
                    'creds': 'some-uat-sa-west-1-creds'
                ],
                'sa-north-1': [
                    'project_id': 'some-uat-sa-north-1-project',
                    'creds': 'some-uat-sa-north-1-creds'
                ]
            ],
        ]
    ]

    return environment_properties
}
