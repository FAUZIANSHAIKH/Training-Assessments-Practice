/**
  * 1990-2019 Publicis Sapient Corporation. All rights reserved.   
*/

// List of urls this api is going 
import axios from 'axios';

const register =  axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8005/api/v1/users",
    responseType: "json"
})

const user_confirmation = axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8001/api/v1",
    responseType: "json"
})

const deRegister =  axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8007/api/v1/users",
    responseType: "json"
})

const login =  axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8013/api",
    responseType: "json"
})

const admin_update =  axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8020",
    responseType: "json"
})

const admin_delete =  axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8003",
    responseType: "json"
})

const change_password =  axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8015/api",
    responseType: "String"
})

const forgot_password =  axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8009/forgotpassword",
    responseType: "json"
})

const edit_profile = axios.create({
    baseURL: "http://ec2-18-235-29-68.compute-1.amazonaws.com:8018/api",
    responseType: "json"
})

export default{
    auth: {

        // to get all security questions from the database
        getSecurityQuestions(){
            return register.get("/securityquestions");
        },
        //to post users data into the database
        postusers(data){
            return register.post("/register",data);
        },


        getUserConfirmation(url){
            return user_confirmation.get(url);
        },
        userConfirmation(url, data){
            return user_confirmation.post(url, data);
        },


        postDeregister(url, data){
            return deRegister.post(url, data);
        },
        getDeregister(url){
            return deRegister.get(url);
        },


        postAuthentication(url, data){
            return login.post(url, data);
        },


        getAllUserDetailsAdmin(url){
            return admin_update.get(url);
        },
        getAllActiveUserDetailsAdmin(url){
            return admin_update.get(url);
        },


        deleteUser(url, data){
            return admin_delete.post(url, data);
        },


        changePassword(url, data){
            return change_password.post(url, data);
        },



        forgotPassword(url, data){
            return forgot_password.post(url, data);
        },



        editProfile(url){
            return edit_profile.get(url);
        },
        editProfile(url, data){
            return edit_profile.post(url, data);
        }


    }
}
