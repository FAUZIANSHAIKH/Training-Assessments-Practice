
import React, { Component } from 'react';
import MaterialTable from 'material-table';
import Axios from "../../Axios";
import axios from 'axios';
import {Link} from 'react-router-dom';




export default class Admin extends Component {

  constructor() {
    super();
    //this.fun=this.fun.bind(this);
    this.state = {
      columns: [
        { title: 'User Id', field: 'userID', filtering: false },
        { title: 'FirstName', field: 'firstName', filtering: false },
        { title: 'Last Name', field: 'lastName', filtering: false },
        { title: 'Email', field: 'emailID', type: 'string', filtering: false },
        { title: 'Phone', field: 'phoneNo', filtering: false },
        { title: 'Account_Status', field: 'accountStatus', type: 'string', filtering: true, lookup: { ACTIVE: 'ACTIVE', DELETE: 'DELETE', PURGE: 'PURGE', DEACTIVE: 'DEACTIVE', UNCONFIRMED: 'UNCONFIRMED' } }
      ],
      data: []
    }

  }

  componentDidMount() {
    Axios.auth.getAllUserDetailsAdmin("/getAll")
      .then(res => {
        this.setState({
          data: res.data
        });
        console.log(res.data);
      })
  }


  handle(event, rowData) {
    console.log(rowData);
    window.location.assign("http://localhost:8003")
    window.location.reload();
  }

  handleDelete(event, rowData) {
    console.log(rowData);
    Axios.deleteUser("/deleteuser", { userID: rowData.userID })
    window.location.reload();
  }

  handleUndelete(event, rowData) {
    console.log(rowData);
    Axios.deleteUser("/undeleteuser", { userID: rowData.userID })
    window.location.reload();
  }

  handlePurge(event, rowData) {
    console.log(rowData);
    Axios.deleteUser("/purgeuser", { userID: rowData.userID })
    window.location.reload();
  }


  render() {
    console.log(this);

    return (
      <div>
        <MaterialTable
        title="User List"
        columns={this.state.columns}
        data={this.state.data}
        //onRowClick={(event,data)=> handle(event,data)}
        options={{
          actionsColumnIndex: 6,
          filtering: true

        }}
        actions={[
          rowData => ({
            title: 'Edit',
            icon: 'edit',
            tooltip: 'Edit Profile',
            onClick: (event, rowData) => this.handle(event, rowData),
            disabled: rowData.accountStatus === 'DELETE' || rowData.accountStatus === 'PURGE'
          }),
          rowData => ({
            icon: 'delete',
            tooltip: 'Delete User',
            onClick: (event, rowData) => this.handleDelete(event, rowData),
            disabled: rowData.accountStatus === 'DELETE' || rowData.accountStatus === 'PURGE'
          }),
          rowData => ({
            title: 'Undelete',
            icon: 'restore_from_trash',
            tooltip: 'Undelete Profile',
            onClick: (event, rowData) => this.handleUndelete(event, rowData),
            disabled: rowData.accountStatus === 'ACTIVE' || rowData.accountStatus === 'DEACTIVE'
              || rowData.accountStatus === 'UNCONFIRMED'
          }),
          rowData => ({
            title: 'Purge',
            icon: 'delete_forever',
            tooltip: 'Purge Profile',
            onClick: (event, rowData) => this.handlePurge(event, rowData),
            disabled: rowData.accountStatus === 'PURGE'
          })

        ]}
      />
      <Link to="/activeusers" >View Current users</Link> 
      </div>
    );
  }
}