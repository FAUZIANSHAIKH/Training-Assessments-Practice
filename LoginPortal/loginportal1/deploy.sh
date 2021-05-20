 sudo npm install -g http-server
 cd /var/lib/jenkins/workspace/loginPortal/MicroFrontEnd && sudo http-server -p 8006 &
 cd /var/lib/jenkins/workspace/loginPortal/DataService/target && java -jar DataService.jar &
 cd /var/lib/jenkins/workspace/loginPortal/UserConfirmation_Backend/target && java -jar UserConfirmation_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/Register_Backend/target && java -jar Register_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/Forgotpassword_Backend/target && java -jar Forgotpassword_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/Edit_Profile_Backend/target && java -jar Edit_Profile_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/DeRegister_Backend/target && java -jar DeRegister_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/DeleteUser_Backend/target && java -jar DeleteUser_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/Admin_Backend/target && java -jar Admin_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/LoginService_Backend/target && java -jar LoginService_Backend.jar &
 cd /var/lib/jenkins/workspace/loginPortal/ChangePasswordService_Backend/target && java -jar ChangePasswordService_Backend.jar &

