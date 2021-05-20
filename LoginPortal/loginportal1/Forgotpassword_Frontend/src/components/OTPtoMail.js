import React from 'react';
import Axios from 'axios';
export default class OTPtoMail extends React.Component{
    constructor(props)
    {
        super(props);
        this.state={
            status:"false",
            value:null
        }
        this.click=this.click.bind(this);
        this.handleChange=this.handleChange.bind(this);
    }
    click(){
        let data={
            otp:this.state.value,
            msg:null   
        }
        //console.log(data);
        //Axios.post("http://10.150.176.132:8076/forgotpassword/otp",data).then(res => console.log(res));
        //Axios.post("http://10.150.176.135:8009/forgotpassword/otp",data).then(res => this.setState({status:res.data.status}));
        //Axios.post("http://localhost:8009/forgotpassword/otp",data).then(res => this.setState({status:res.data.status}));
        Axios.post("http://localhost:8009/forgotpassword/otp",data).then(res => {
            this.setState({status:res.data.status,msg:'please entervalid OTP'})
            if(this.state.status==='true'){
            window.location.replace('http://localhost:8010/#/forgotpassword/Setpassword')
            }
        });
    
    }
      handleChange(e){
            this.setState({value:e.target.value})
      }
    render(){
        return(
            <div>
                <h2>OTP has been sent to Email: Please enter OTP</h2>
                
               <input type="password" id="otp" name="otp" onChange={this.handleChange}></input><br></br>
               <input className="btn btn-primary bbb" type="submit" onClick={this.click}></input><br/>

            </div>
        );
    }
}