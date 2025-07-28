job('run-greed-assignment') {
    description('Runs Greed Assignment tests on GitHub push')

    scm {
        git('https://github.com/Shreys-ai/Greed_Assignment.git', 'main')
    }

    triggers {
        githubPush()
    }

    wrappers {
        credentialsBinding {
            usernamePassword('BROWSERSTACK_USERNAME', 'BROWSERSTACK_ACCESS_KEY', 'BROWSERSTACK_CREDENTIALS')
        }
    }

    steps {
        shell("""
            echo 'Node version:'
            node -v

            echo 'NPM version:'
            npm -v

            echo '🌐 Using BrowserStack credentials from Jenkins...'
            echo "Username: \$BROWSERSTACK_USERNAME"
            echo "Access Key: \$BROWSERSTACK_ACCESS_KEY"

            echo '🚀 Running tests on BrowserStack Chrome Windows...'
            npx nightwatch --env browserstack.chrome
        """.stripIndent())
    }
}
