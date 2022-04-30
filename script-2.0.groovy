def buildJar(){
    echo 'building jar file of the application...'
    sh 'mvn package'
}

def buildImage(){
            echo 'building Image of the application'
            withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]){
                    sh 'docker build -t marv254/my-repo:jma-2.6 .'
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
            } 
}
def deployImage(){
    echo 'deploying image to Docker Hub'
    sh 'docker push marv254/my-repo:jma-2.6'
}
return this
