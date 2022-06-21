pipeline {
    
    agent any

    environment {
        imagename = "pdisec2122/project-movie-infographic-api"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }


    stages {

        stage('Cloning Git') {
            steps {
                git([url: 'https://github.com/pdisec2122/project-movie-infographic-api.git', 
                    branch: 'main'])

            }
        }

        stage('Build Java Application') {
            agent {
                docker {
                    image 'maven:3.8.1-adoptopenjdk-11'
                    args '-v /root/.m2:/root/.m2'
                }
            }

            environment {
                HOME="."
            }
            
            steps {
                sh 'mvn install -DskipTests'
            }

            post {
                always {
                    dir('target') {
                        archiveArtifacts artifacts: 'movieinfographic*.war', fingerprint: true
                    }
                }
            }
        }

        stage('Docker build image') {

            steps {
     
                copyArtifacts(
                    filter: 'movieinfographic*.war',
                    projectName: env.JOB_NAME,
                    fingerprintArtifacts: true,
                    selector: specific(env.BUILD_NUMBER)
                )

                script {
                    dockerImage = docker.build imagename
                }
            }
        }

        stage('Deploy Image') {
            steps{
                script {
                    docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
                        dockerImage.push("$BUILD_NUMBER")
                        dockerImage.push('latest')
                    }
                }
            }
        }
    
    }

    post {
        always {
            echo "Finished"
        }
    }

}
