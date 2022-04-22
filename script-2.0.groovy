def buildJar(){
    echo 'building jar file of the application...'
    sh 'mvn package'
}

def buildImage(){
            echo 'building Image of the application'
            withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]){
                    sh 'docker build -t 127.0.0.1:8083/java-maven-app:1.0 .'
                    sh 'echo $PASS | docker login -u $USER --password-stdin 127.0.0.1:8083'
            } 
}
def deployImage(){
    echo 'deploying image in private nexus repository'
    sh 'docker push 127.0.0.1:8083/java-maven-app:1.0'
}
return this