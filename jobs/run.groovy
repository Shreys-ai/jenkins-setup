job('run-greed-assignment') {
    description('Runs Greed Assignment tests on GitHub push')

    scm {
        git('https://github.com/Shreys-ai/Greed_Assignment.git', 'main')
    }

    triggers {
        githubPush() // requires GitHub webhook to be set up
    }

    steps {
        shell '''
        echo "✅ Node version:"
        /Users/shreyasdhoke/.nvm/versions/node/v22.17.1/bin/node -v

        echo "✅ NPM version:"
        /Users/shreyasdhoke/.nvm/versions/node/v22.17.1/bin/npm -v

        echo "📦 Installing dependencies"
        /Users/shreyasdhoke/.nvm/versions/node/v22.17.1/bin/npm install

        echo "🚀 Running the app"
        /Users/shreyasdhoke/.nvm/versions/node/v22.17.1/bin/npm run start
        '''
    }
}