import React,{Component} from 'react';
import MaterialTable from 'material-table';
import axios from 'axios';


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
      axios.get('http://localhost:8020/api/getAllActiveUsers')
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
           <a href="/" >Back to adminPage</a> 
            </div>
        );
    }
}