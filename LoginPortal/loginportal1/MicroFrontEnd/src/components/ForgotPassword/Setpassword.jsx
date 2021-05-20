import React from 'react';
import Axios from '../../Axios';
// import ReactNotification from 'react-notifications-component'
// import 'react-notifications-component/dist/theme.css'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { store } from 'react-notifications-component'

export default class Setpassword extends React.Component {

  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this)
    this.click = this.click.bind(this);
    this.checkScore = this.checkScore.bind(this);
    this.validatePassword = this.validatePassword.bind(this);
    this.state = {
      allow: 'false',
      password: "",
      confirmed: false,
      confirmPassword: "",
      isConfirming: false,
      status: null,
      value: null
    };
  }


  validatePassword() {
    this.copy();
    // console.log("vpwd");
    let pwd = document.getElementById("t1").value;
    let cpwd = document.getElementById("t2").value;
    // console.log(cpwd);
    //var passw=  /^[A-Za-z]\w{7,14}$/;

    if (pwd.length === 0)
      document.getElementById("msg1").innerText = "*This field can not be empty";
    else
      document.getElementById("msg1").innerText = " ";
    if (cpwd.length === 0)
      document.getElementById("msg2").innerText = "*This field can not be empty";
    else
      document.getElementById("msg2").innerText = "  ";


    // If confirm password not entered 
    if (cpwd !== pwd && pwd.length !== 0 && cpwd.length !== 0)
      document.getElementById("msg2").innerText = "Password doesn't match";
    else if (pwd === cpwd && pwd.length > 0) {

      document.getElementById("msg2").innerText = "  ";
      document.getElementById("msg2").innerText = this.checkScore();
    }

  }

  copy() {
    window.event.preventDefault();
    if (window.event.ctrlKey) {
      if (window.event.keyCode === 86) {
        //console.log("copy");
        //  document.getElementById("t1").value = " ";
        document.getElementById("t2").value = "";


      }
    }
  }
  checkScore() {
    let cpwd = document.getElementById("t2").value;
    let pass = cpwd;

    var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    if ((pass.match(decimal))) {
      this.setState({ allow: 'true' })
      return " ";
    }
    else
      return "Please enter in correct format";

  }
  handleChange(e) {
    this.setState({ value: e.target.value });
  }
  click() {
    let data = {
      pwd: this.state.value,
      email: this.props.emailID
    }
    let pwd = document.getElementById("t1").value;
    let cpwd = document.getElementById("t2").value;
    if (pwd === cpwd && pwd !== '' && this.state.allow === 'true') {
      // Axios.post("http://10.150.121.20:8009/forgotpassword/set",data).then(res => this.setState({status:res.data.status}));
      Axios.auth.forgotPassword("/set", data).then(res => {
        this.setState({ status: res.data.status })
        if (this.state.status === 'true') {

          toast.success('Your password has been changed successfully', {
            position: "top-center",
            autoClose: 2000,
            hideProgressBar: true,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
          });
        }
        window.location.replace('http://ec2-18-235-29-68.compute-1.amazonaws.com:8006/#/')
      }
      );
      // Axios.post("http://10.150.121.20:8009/forgotpassword/set",data).then(res => this.setState({status:res.data.status}));
    }
    else {
      this.setState({ status: "false" });
    }
  }
  render() {
    return (
      <div>
        <div className="card bg-light">
          <article className="card-body mx-auto" style={{ minWidth: '500px', maxWidth: '500px' }}>
            <h4 className="card-title mt-3 text-center">Enter your New Password</h4>
            <br /><br />
            <form>
            
              <div className="form-group input-group">
                <div className="input-group-prepend">
                  <span className="input-group-text"> <i className="fa fa-lock"></i> </span>
                </div>
                <input type="password" placeholder="New Password" className="form-control" name="password" id="t1" 
                onChange={this.handleChange} onKeyUp={this.validatePassword} ></input>
              </div>
              <p className="form-error">
                <span id="msg1" ></span>
              </p>
              <br />

              <div className="form-group input-group">
                <div className="input-group-prepend">
                  <span className="input-group-text"> <i className="fa fa-lock"></i> </span>
                </div>
                <input type="password" className="form-control" placeholder="Confirm New Password" name="cpassword" id="t2" 
                onChange={this.validatePassword} ></input><br/>
              </div>
              <p className="form-error">
                <span id="msg2"></span>
                <span id="msg3"></span>
              </p>
              <br />


              <div className="form-group">
                <button 
                  type="button" 
                  value="Submit"
                  onClick={this.click}
                  className="btn btn-primary btn-block"> Change Password </button>
              </div>
              <br />
              <br />
            </form>
          </article>
        </div>

      </div >


    )
  }
}