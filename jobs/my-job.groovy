pipelineJob('tasks-pipeline') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Shreys-ai/Greed_Assignment.git')
                    }
                    branches('*/main')
                }
            }
        }
    }

    triggers {
        githubPush()  // ✅ THIS is what listens on /github-webhook/
    }
}
