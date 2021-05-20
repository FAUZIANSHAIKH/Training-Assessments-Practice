import React,{Component} from 'react';
import MaterialTable from 'material-table';
import Axios from "../../Axios";


export default class ActiveUsers extends Component {

    constructor(){
        super();
        //this.fun=this.fun.bind(this);
        this.state={
            columns:[
              { title: 'User Id', field: 'userid'},
              { title: 'Email', field: 'emailid', type: 'string' },
              { title: 'LoginTime', field: 'logged_in_time', type: 'datetime' }
            ],
            data:[]
        }
         
    }

    componentDidMount(){
      Axios.auth.getAllUserDetailsAdmin("/getAllActiveUsers")
        .then(res => {
          this.setState({
            data:res.data
          });
    
          console.log(res.data);
        })
     }

 
  
 
   
    render(){
        console.log(this );
     //   console.log(this.state.data);
        return  (   
          <div>
            <MaterialTable
              title="User List"
              columns={this.state.columns}
              data={this.state.data}
              
              //onRowClick={(event,data)=> handle(event,data)}
            
            
            />
           
            </div>
        );
    }
}