    
import React,{Component} from 'react';
import { Link} from 'react-router-dom';
import Axios from 'axios';
export default class User extends Component {
    constructor()
    {
        super();
        console.log('called from const');
        
        this.details=this.details.bind(this);
        this.state={ users:[
        ]
       
}

    }
    componentDidMount()
    {
        
        console.log(`Component is mounted on the DOM`)
      Axios.get('https://jsonplaceholder.typicode.com/users')
        .then(res=> this.setState({
            
             users:res.data
        })
        
       )
       
        
       
    }
    
    details(){
  console.log('came inside the click event handler');
    }
    render(){
       
        return  (
            <div className="card" style={{width: 18 +'rem'}}>
                <div className="card-body">
                <h5>MOVIE_NAME</h5>   <h5 className="card-title">{ this.props.title}</h5>
                    
                    
                    <Link to ={`/users/${this.props.id}`} >Details</Link><br></br>
                    <Link to ={`/delete/${this.props.id}`} >Delete</Link>

                </div>
                </div>
        );
    }
}