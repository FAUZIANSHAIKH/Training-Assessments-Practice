import React,{Component} from 'react';

import User from './User';
import Axios from 'axios';
import {BrowserRouter as Router , Route ,Link} from 'react-router-dom';
class DeleteMovie extends Component{
    
  componentDidMount(){
    let id=this.props.match.params.id;
	Axios.delete("http://localhost:8001/api/movies/"+id);
  }
  
	
    
 
 
 
   
    render(){
    
    
    
    return (
      
        
        
        <div className="left">
	    <h1> Deleted Successfully</h1>
		
     
             <Link className="btn-btn-primary" to="/movies">Back</Link>
               </div>
          
       
    );
}
}

export default DeleteMovie;