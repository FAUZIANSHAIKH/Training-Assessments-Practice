import React,{Component} from 'react';
import Axios from 'axios';

import User from './User';
class  UserDetails extends Component {
    constructor()
    {
        super();
        this.state={ users:[
            ]
           
    }
}
    componentDidMount()
    {
        let {id}=this.props.match.params;
        console.log(`Component is mounted on the DOM`)
        Axios.get('http://localhost:8001/api/movies/'+id)
        .then(res=> this.setState({
            
             users:res.data.data
        })
        
       )
       
        
       
    }
    render()
    {
        
    
        return(
            <div>
                    <h1>Movie Details</h1>
                    <div className="card" style={{width: 18 +'rem', margin:10+'px'}}>
                    <div className="card-body">
                    <h3>MOVIE_NAME</h3> <h5 className="card-title">{this.state.users.name}</h5>
                   <h3>MOVIE_ID</h3> <p className="card-title">{this.state.users._id}</p>
                   <h3>REVIEW </h3> <p className="card-title">{this.state.users.review}</p>
                    
                   
                    </div>
                </div>

            </div>
        )
    }
    }

  
  export default UserDetails;