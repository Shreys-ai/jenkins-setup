job('run-greed-assignment') {
    description('Runs Greed Assignment tests on GitHub push')

    scm {
        git('https://github.com/Shreys-ai/Greed_Assignment.git', 'main')
    }

    triggers {
        githubPush() // requires GitHub webhook to be set up
    }

    steps {
        shell('npm install')
        shell('npm test')
    }
}