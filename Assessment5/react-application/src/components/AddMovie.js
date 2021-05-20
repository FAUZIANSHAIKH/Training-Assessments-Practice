import React,{Component} from 'react';

import User from './User';
import Axios from 'axios';
import {BrowserRouter as Router , Route ,Link} from 'react-router-dom';
class AddMovie extends Component{
    

    constructor(props)
    {
        super(props);
        this.state={ users:{
		     name:'',
			 _id:'',
			
        }
           
    }
        console.log('called from const');
        
        this.handleInputChange=this.handleInputChange.bind(this);
       this.handleSubmit=this.handleSubmit.bind(this);

    }
	
    
 
 
 handleInputChange(event){
	 const target=event.target;
	 const name=target.name;
	 const value=target.value;
	 this.setState({
     [name]:value
    });
	 
 }
  
 handleSubmit(){
	let movie={
	    name:this.state.name,
		_id:this.state._id,
		
    }
	Axios.post("http://localhost:8001/api/movies",movie).then(res=>(console.log(res)));
	 
	 
 }
   
    render(){
    
    return (
      
        
        
        <div className="left">
	    <form onSubmit={this.handleSubmit}>
		<h1>AddMovies</h1>
		<h4>Name:<input type="text" name="name" value={this.state.name} onChange={this.handleInputChange}></input></h4>
        <h4>Id:<input type="text" name="_id" value={this.state._id} onChange={this.handleInputChange}></input></h4>
		<h4>Review:<input type="text" name="review" value={this.state.review} onChange={this.handleInputChange}></input></h4>
        <input type="submit" name="submit" value="SUBMIT"></input>
		<input type="reset" name="reset" value="RESET"></input>
		
     </form>
             <Link className="btn-btn-primary" to="/movies">Back</Link>
               </div>
          
       
    );
}
}

export default AddMovie;