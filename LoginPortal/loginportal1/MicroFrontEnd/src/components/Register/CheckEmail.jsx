/**
  * 1990-2019 Publicis Sapient Corporation. All rights reserved.   
*/

import React, { Component } from 'react'
import {Link} from 'react-router-dom'

// If user already exists this will be called
export default class CheckEmail extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }
    render() {
        return (
            <div >
               <div className="text-center" style={{maxWidth:'500px', margin: '0 auto'}}>
               <h1>You are successfully registered, Check your mail to confirm your account.</h1>
                <br /><br />
                <div className="form-group">
                    <Link to='/'>
                        <button type="button" className="btn btn-primary btn-block"> Login </button>
                    </Link>
                </div>
               </div>
            </div>
        )
    }
}