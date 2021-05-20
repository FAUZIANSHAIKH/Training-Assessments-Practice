import Axios from "axios";
import React from 'react';
import {Redirect} from 'react-router';
import Reviews from "./Reviews";
export default class GetData extends React.Component{
    constructor(){
        super();
        this.state={
            status:null,
            data:[]
        }
        let config = {
            headers: {
              Authorization: 'Bearer '+localStorage.getItem('token'),
            }
          }
          //console.log(config);
        Axios.get('http://localhost:9210/reviews',config).then(res => this.setState({data:res.data.status})).catch(err => this.setState({status:err.response.status}));
    }
    render(){
        if(this.state.status === 401){
            return (<Redirect to="/Authenticate" />);
        }
        else{
            return(
                <div>
                    <h3>Your reviews are:</h3>
                    {this.state.data.map((name,index) => <Reviews key={index} review={name.review}></Reviews>)}
                </div>
            )
        }
    }
}