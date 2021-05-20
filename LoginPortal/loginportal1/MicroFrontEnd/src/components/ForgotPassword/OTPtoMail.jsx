import React from 'react';
import Axios from '../../Axios';
import Setpassword from './Setpassword';

import { Link} from 'react-router-dom';
export default class OTPtoMail extends React.Component{
    constructor(props)
    {
        super(props);
        this.state={
            status:"false",
            value:null,
            msg:null
        }
        this.click=this.click.bind(this);
        this.handleChange=this.handleChange.bind(this);
    }
    click(){
        let data={
            otp:this.state.value,   
        }
        console.log(data);
        //Axios.post("http://10.150.176.132:8076/forgotpassword/otp",data).then(res => console.log(res));
        Axios.auth.forgotPassword("/otp",data).then(res => {
            this.setState({status:res.data.status,msg:'please entervalid OTP'})
            if(this.state.status==='true'){
                window.location.replace('http://ec2-18-235-29-68.compute-1.amazonaws.com:8006/#/forgotpassword/Setpassword')
            }
        });
        //Axios.post("http://192.168.43.237:8076/forgotpassword/otp",data).then(res => this.setState({status:res.data.status}));
    
    }
      handleChange(e){
            this.setState({value:e.target.value})
      }
    render(){
        return(
            <div>
               <h2>OTP has been sent to Email: Please enter OTP</h2>
                
                <input type="password" id="otp" name="otp" onChange={this.handleChange}></input><br></br>
                {this.state.status==='true'?'':this.state.msg}<br/>
                <input className="btn btn-primary bbb" type="submit" onClick={this.click}></input><br/>

            </div>
        );
    }
}