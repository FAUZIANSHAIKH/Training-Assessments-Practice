import React from 'react';
import Axios from 'axios';

export default class Authenticate extends React.Component{
    constructor(){
        super()
        this.state={
            name:null,
            password:null,
            status:null
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleChange1 = this.handleChange1.bind(this);
        this.click = this.click.bind(this);
    }
    handleChange1(e){
        this.setState({name:e.target.value})
    }
    handleChange(e){
        this.setState({password:e.target.value})
    }
    click(){
        let data = {
            username:this.state.name,
            password:this.state.password
        }
        Axios.post("http://localhost:9210/login",data).then(res => {
            localStorage.setItem('token',res.data.token);
            this.setState({status:res.status});
            if(this.state.status===200){
                  window.location.replace('http://localhost:8010/#/Getdata')
             }
            }
            );
    }
    render(){
        return(
            <div>
                <form>
                <input type="text" placeholder='username' name="name" onChange={this.handleChange1}></input><br/>
                <input type="password" placeholder='password' name="password" onChange={this.handleChange}></input><br></br>
                <input type="button" className="btn btn-primary" onClick={this.click} value="SUBMIT" type='reset'></input>
                </form>
                
            </div>
        )
    }
}