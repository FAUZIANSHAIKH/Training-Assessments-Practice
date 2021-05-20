import React from 'react';
import Axios from 'axios';
import './Setpassword.css';
import ReactNotification from 'react-notifications-component'
import 'react-notifications-component/dist/theme.css'
import {store} from 'react-notifications-component'

export default class Setpassword extends React.Component{

    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this)
        this.click=this.click.bind(this);
        this.checkScore=this.checkScore.bind(this); 
        this.validatePassword = this.validatePassword.bind(this);
        this.state = {
          allow:'false',
          password: "",
          confirmed: false,
          confirmPassword: "",
          isConfirming: false,
          status:null,
          value:null
        };
      }

    
    validatePassword(){
        this.copy();
       // console.log("vpwd");
       let  pwd = document.getElementById("t1").value;
       let  cpwd = document.getElementById("t2").value;
     // console.log(cpwd);
       //var passw=  /^[A-Za-z]\w{7,14}$/;

       if (pwd.length===0) 
         document.getElementById("msg1").innerText="*This field can not be empty";
       else
         document.getElementById("msg1").innerText=" ";
       if (cpwd.length===0)
          document.getElementById("msg2").innerText="*This field can not be empty";
       else
          document.getElementById("msg2").innerText="  ";  
          
          
        // If confirm password not entered 
    if (cpwd !==pwd  && pwd.length!==0 && cpwd.length!==0)   
      document.getElementById("msg2").innerText="Password doesn't match";
    else if (pwd===cpwd && pwd.length>0){

        document.getElementById("msg2").innerText="  ";
        document.getElementById("msg2").innerText=this.checkScore();
    }
       
    }
   
    copy(){
        window.event.preventDefault();
        if (window.event.ctrlKey){
        if (window.event.keyCode === 86) {
            //console.log("copy");
      //  document.getElementById("t1").value = " ";
        document.getElementById("t2").value = "";
      

        }
    }
}
    checkScore(){
        let  cpwd = document.getElementById("t2").value;
       
       // console.log(pwd);
        let pass= cpwd;
       
        var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

        // award every unique letter until 5 repetitions
    
     
     // bonus points for mixing it up
    
 
     
     if ((pass.match(decimal)) ){
       this.setState({allow:'true'})
       return " ";
     }
     else 
       return "Please enter in correct format";
  
    }  
    handleChange(e){
        this.setState({value:e.target.value});
      }
      click(){
        let data={
            pwd:this.state.value,
            email:this.props.email
        }
        let  pwd = document.getElementById("t1").value;
       let  cpwd = document.getElementById("t2").value;
        if(pwd===cpwd && pwd!=='' && this.state.allow==='true'){
         // Axios.post("http://10.150.121.20:8009/forgotpassword/set",data).then(res => this.setState({status:res.data.status}));
          Axios.post("http://localhost:8009/forgotpassword/set",data).then(res => {
            this.setState({status:res.data.status})
            if(this.state.status==='true'){
              store.addNotification({
                title: "Success",
                message: "Your password has been changed successfully",
                type: "success",
                insert: "top",
                container: "top-center",
                dismiss: {
                  duration: 2000
                }
              });
            }
            window.location.replace('http://localhost:8014/#/')
            }
            );
       // Axios.post("http://10.150.121.20:8009/forgotpassword/set",data).then(res => this.setState({status:res.data.status}));
        }
        else{
          this.setState({status:"false"});
        }
        
        
      }
    render (){
        return(
        <div className="password_reset">
        <ReactNotification />
        <form> 
        <pre> 
        <input type="password" placeholder="New Password" name="password" id="t1"   onChange={this.handleChange} onKeyUp={this.validatePassword} ></input><br/>
        <span id="msg1">  </span><br/>
        <input type="password" placeholder="Confirm New Password" name="cpassword" id="t2"   onChange={this.validatePassword} ></input><br/>
        <span id="msg2">  </span>
        <span id="msg3">  </span>
        <br/>
        </pre>
        <input className="btn-primary btn bbb" type="button" value="Submit" onClick={this.click}></input> <input type="reset" className='btn btn-primary' value="Reset"></input>
  
  </form>
        </div>
        )
    }
}
