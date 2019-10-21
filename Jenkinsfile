node('master'){
   stage('git checkout'){
                  git 'https://github.com/himajareddy506/LMSBackend.git'
              }
   stage('java build'){
      sh '/opt/maven/bin/mvn clean deploy sonar:sonar -Dsonar.password=admin -Dsonar.login=admin'​

         }
   stage('Running java backend application'){

             sh 'export JENKINS_NODE_COOKIE=dontKillMe ;nohup java -Dspring.profiles.active=dev -jar $WORKSPACE/target/*.jar &'
         }
}
