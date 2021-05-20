import React from 'react';
import './ForgotPassword.css';
import Axios from 'axios';
import Methods from './Methods';

export default class ForgotPassword extends React.Component{
    constructor(){
        super();
        this.check = this.check.bind(this);
        this.click = this.click.bind(this);
        this.handleChange = this.handleChange.bind(this)
        this.state={
            status:"false",
            alltrue:true,
            value:null,
            msg:null
        }
        
    }
    check(ev){
        var v = this.validateEmail(ev.target.value);
        if(v){
        
            this.setState({msg:""})
        }
        else{
            
            this.setState({
                alltrue:false,
                msg:'please enter correct email'
            });
        }
        this.handleChange(ev);
    }
    validateEmail(email) {
        return email.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
    }
      click(){
          
        let data={
            emailID:this.state.value
        }
        //Axios.post("http://10.150.176.135:8009/forgotpassword/uic",data).then(res => this.setState({status:res.data.status,msg:'please enter an email registered'}));
        Axios.post("http://localhost:8009/forgotpassword/uic",data).then(res => {
              console.log('hai')
        this.setState({status:res.data.status,msg:'please enter registered email'})
        }
        );
        //Axios.post("http://10.150.121.20:8009/forgotpassword/uic",data).then(res => this.setState({status:res.data.status,msg:'please enter registered email'}));
        
      }
      handleChange(e){
        this.setState({value: e.target.value});
      }
    render(){
        return(
            <div>
                <h2>Please enter your email to recover the password</h2>
                    <input type="email" placeholder='Email' name="email" id="email" onChange={this.check}></input><br></br>
                    <span id="msg">{this.state.status==='false'?this.state.msg:''}</span><br/>
                    <input className="btn btn-primary bbb" type="submit" onClick={this.click}></input>
                    {this.state.status==='true'?<Methods emailID={document.getElementById('email').value}/>:''}
            </div>
        );
    }
}