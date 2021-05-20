import React,{Component} from 'react';

import User from './User';
import Axios from 'axios';
import AddMovie from './AddMovie';
import DeleteMovie from './DeleteMovie';
           

class Main extends Component{
    // const titleMessage = "IPhone X";
    constructor()
    {
        super();
        this.state={ users:[
            ]
           
    }
        console.log('called from const');
        
        this.selectedProduct=this.selectedProduct.bind(this);


    }
    
    selectedProduct(title,body)
    {
        console.log(title);
        console.log('came inside the selected product function');
       // console.log(`${name}`);
      
     //  const filteredList=this.state.org.filter(org=>org.name!==title);
      // console.log(filteredList);
       // this.setState({
       //     phones:filteredList
      //  })
    
    }
 
 
     componentDidMount(){
         
         console.log(`Component is mounted on the DOM`)
      const arr= Axios.get('http://localhost:8001/api/movies')
         .then(res=> this.setState({
             
              users:res.data.data
         })
       
         );
        
         console.log(arr);
        
     }
 
    render(){
    
    
    
    return (
      
        
        
        <div className="left">
               {this.state.users.map((users,index)=><User key={index} id={users._id} title={users.name} mail={users.review} selected={this.selectedProduct}/>)}

               </div>
          
       
    );
}
}

export default Main;