def buildApp() {
    echo 'building the application...'
}

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    echo 'deploying the application...'
    echo "deploying ${VERSION} of the application"
} 

return this