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
        export PATH="/Users/shreyasdhoke/.nvm/versions/node/v22.17.1/bin:$PATH"

        echo "✅ Node version:"
        node -v

        echo "✅ NPM version:"
        npm -v

        echo "📦 Installing dependencies"
        npm install

        echo "🚀 Running the app"
        npm run start
        '''
    }
}