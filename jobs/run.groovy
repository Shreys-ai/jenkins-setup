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
            usernamePassword('BROWSERSTACK_USERNAME', 'BROWSERSTACK_ACCESS_KEY', 'browserstack-creds')
        }
    }

    steps {
        shell("""
            echo 'Node version:'
            node -v

            echo 'NPM version:'
            npm -v

            echo '🚀 Running Nightwatch tests on BrowserStack...'
            
            export BROWSERSTACK_USERNAME=$BROWSERSTACK_USERNAME
            export BROWSERSTACK_ACCESS_KEY=$BROWSERSTACK_ACCESS_KEY

            npx nightwatch --env browserstack.chrome
        """.stripIndent())
    }
}
