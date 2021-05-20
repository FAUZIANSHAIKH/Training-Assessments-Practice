
import React from 'react';
// import './ForgotPassword.css';
import Axios from '../../Axios';
import Methods from './Methods';

export default class ForgotPassword extends React.Component {
    constructor() {
        super();
        this.check = this.check.bind(this);
        this.click = this.click.bind(this);
        this.handleChange = this.handleChange.bind(this)
        this.state = {
            status: "false",
            alltrue: true,
            value: null,
            msg: null
        }

    }
    check(ev) {
        var v = this.validateEmail(ev.target.value);
        if (v) {

            this.setState({ msg: "" })
        }
        else {

            this.setState({
                alltrue: false,
                msg: '*Please enter correct email'
            });
        }
        this.handleChange(ev);
    }
    validateEmail(email) {
        return email.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
    }
    click() {

        let data = {
            emailID: this.state.value
        }
        console.log("clicked");
        //Axios.post("http://10.150.176.135:8009/forgotpassword/uic",data).then(res => this.setState({status:res.data.status,msg:'please enter an email registered'}));
        Axios.auth.forgotPassword("/uic", data).then(res => this.setState({ status: res.data.status, msg: '*Please enter an email registered' }));
        //Axios.post("http://10.150.121.20:8009/forgotpassword/uic",data).then(res => this.setState({status:res.data.status,msg:'please enter registered email'}));

    }
    handleChange(e) {
        this.setState({ value: e.target.value });
    }
    render() {
        return (

            <div>
                <div className="card bg-light">
                    <article className="card-body mx-auto" style={{ minWidth: '500px', maxWidth: '500px' }}>
                        <h4 className="card-title mt-3 text-center">Publicis Sapient</h4>
                        <p className="text-center">Please enter your email to recover the password</p>


                            <div className="form-group input-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"> <i className="fa fa-envelope"></i> </span>
                                </div>

                                <input type="email" className="form-control" placeholder='Email' name="email" id="email"
                                    onChange={this.check}></input>

                            </div>
                            <p className="form-error">
                                <span>{this.state.status === 'false' ? this.state.msg : ''}</span>
                            </p>


                            <div className="form-group">
                                <button type="submit" id="login" variant="primary"
                                    onClick={this.click} className="btn btn-primary btn-block"> Submit </button>
                            </div>

                            {this.state.status === 'true' ? <Methods emailID={document.getElementById('email').value} /> : ''}


                    </article>
                </div>

            </div>
        );
    }
}