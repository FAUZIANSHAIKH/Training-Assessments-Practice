import React, { Component } from "react";
import Axios from '../../Axios';
// import '../App.css';
import { Button } from 'react-bootstrap';
import { store } from 'react-notifications-component';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';

class ChangePassword extends Component {
  constructor() {
    super();
    this.state = {
      userID: "",
      password: "",
      hpassword: "",
      oldPassword: "",
      confirmPassword: "",
      fields: {
        hpassword: '',
        oldPassword: '',
        confirmPassword: ''
      },
      errors: {}
    }
    this.validateOldPwd = this.validateOldPwd.bind(this);
    this.validateNewPwd = this.validateNewPwd.bind(this);
    this.validateConfPwd = this.validateConfPwd.bind(this);
    this.clear = this.clear.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  isEmpty(args) {
    let fields = this.state.fields;
    if (!fields[args]) {
      return true;
    }
    return false;
  }
  validateOldPwd(e) {
    let fields = this.state.fields;
    fields[e.target.name] = e.target.value;
    let errors = this.state.errors;
    if (this.isEmpty("oldPassword")) {
      errors["oldPassword"] = <font color="red">*This field can not be empty</font>;
    }
    else {
      errors["oldPassword"] = null;
    }
    this.setState({
      errors: errors
    });
  }
  validateNewPwd(e) {
    let fields = this.state.fields;
    fields[e.target.name] = e.target.value;
    let errors = this.state.errors;
    if (this.isEmpty("hpassword")) {
      errors["hpassword"] = <font color="red">*This field can not be empty</font>;
    }
    else if (!fields["hpassword"].match(/^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/)) {
      errors["hpassword"] = <font color="red">*Please enter in correct format</font>;
    }
    else if (fields["hpassword"] === fields["oldPassword"]) {
      errors["hpassword"] = <font color="red">*Password should not match with old one</font>;
    }
    else {
      errors["hpassword"] = null;
    }
    this.setState({
      errors: errors
    });
  }
  validateConfPwd(e) {
    let fields = this.state.fields;
    fields[e.target.name] = e.target.value;
    let errors = this.state.errors;
    if (this.isEmpty("confirmPassword")) {
      errors["confirmPassword"] = <font color="red">*This field can not be empty</font>;
    }
    else if (!fields["confirmPassword"].match(/^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/)) {
      errors["confirmPassword"] = <font color="red">*Please enter in correct format</font>;
    }
    else if (fields["hpassword"] !== fields["confirmPassword"]) {
      errors["confirmPassword"] = <font color="red">*Password doesn't match</font>;
    }
    else {
      errors["confirmPassword"] = null;
    }
    this.setState({
      errors: errors
    });
  }

  clear = () => {
    this.setState({
      oldPassword: '',
      hpassword: '',
      confirmPassword: '',
      errors: {}
    })
  }

  onSubmit(e) {
    e.preventDefault();
    let fields = this.state.fields;
    let errors = this.state.errors;
    if (this.isEmpty("oldPassword")) {
      errors["oldPassword"] = <font color="red">*This field can not be empty</font>;
      this.setState({
        errors: errors
      });
    }
    if (this.isEmpty("hpassword")) {
      errors["hpassword"] = <font color="red">*This field can not be empty</font>;
      this.setState({
        errors: errors
      });
    }
    if (this.isEmpty("confirmPassword")) {
      errors["confirmPassword"] = <font color="red">*This field can not be empty</font>;
      this.setState({
        errors: errors
      });
    }
    if (errors["oldPassword"] == null && errors["hpassword"] == null && errors["confirmPassword"] == null) {
      const userObject = {
        userID: this.props.state.userId,
        passwordHistory: {
          pwd1: fields["oldPassword"],
          pwd2: fields["hpassword"]
        }
      }
      console.log(userObject);
      Axios.auth.changePassword('/change', userObject)
        .then(
          res => {
            console.log(res.data);
            if (res.data === "Password changed successfully") {
              //window.location.replace('http://10.150.120.146:8014');
              store.addNotification({
                title: "Success !",
                message: "Password changed successfully",
                type: "success",
                insert: "top",
                container: "top-center",
                dismiss: {
                  duration: 2000
                },
                animationIn: ["animated", "flip"],
                animationOut: ["animated", "fadeOut"],
              });
              this.setState({
                errors: {},
                fields: {
                  hpassword: '',
                  oldPassword: '',
                  confirmPassword: ''
                }
              }, this.props.history.push('/'))
            }
            else if (res.data === "Please enter correct password") {
              store.addNotification({
                title: "Error",
                message: "Please enter correct password",
                type: "danger",
                insert: "top",
                container: "top-center",
                dismiss: {
                  duration: 2000
                },
                animationIn: ["animated", "flip"],
                animationOut: ["animated", "fadeOut"],
              });
            }
            else if (res.data === "new password should not be same as last three old passwords") {
              store.addNotification({
                title: "Error",
                message: "new password should not be same as last three old passwords.Please enter another",
                type: "danger",
                insert: "top",
                container: "top-center",
                dismiss: {
                  duration: 2000
                },
                animationIn: ["animated", "flip"],
                animationOut: ["animated", "fadeOut"],
              });
            }
          })
        .catch(error => {
          store.addNotification({
            title: "Error",
            message: "Network error",
            type: "danger",
            insert: "top",
            container: "top-center",
            dismiss: {
              duration: 4000
            },
            animationIn: ["animated", "flip"],
            animationOut: ["animated", "fadeOut"],
          });
          console.log(error.response);
          window.location.reload();
        });
    }
  }
  render() {
    return (
      <div>
        <div className="card bg-light">
          <article className="card-body mx-auto" style={{ minWidth: '500px', maxWidth: '500px' }}>
            <h4 className="card-title mt-3 text-center">Change Password</h4>
              <br/><br/>
            <form className="changepassword" id="form" action="/">
              {/* <div className="text-center">
                <br />
                <br />
                <h1 >Change Password</h1>
                <br /> */}

              <div className="form-group input-group">
                <div className="input-group-prepend">
                  <span className="input-group-text"> <i className="fa fa-lock"></i> </span>
                </div>
                <input type="password" className="form-control" name="oldPassword" id="oldpwd" ref="clearPwd"
                  onKeyUp={this.validateOldPwd} placeholder="Old Password" required></input>

              </div>
              <p className="form-error">
                <span>{this.state.errors.oldPassword}</span>
              </p>
              <br/>

              <div className="form-group input-group">
                <div className="input-group-prepend">
                  <span className="input-group-text"> <i className="fa fa-lock"></i> </span>
                </div>
                <input type="password" className="form-control" name="hpassword" id="newpwd" ref="clearPwd"
                  onKeyUp={this.validateNewPwd} placeholder="New Password" required></input>
              </div>
              <p title="Use 8 or more characters with a mix of letters, numbers and symbols"
                style={{ color: 'blue', fontSize: '12px', float: 'right' }}>
                Need help?
              </p>
              <p className="form-error">
                <span>{this.state.errors.hpassword}</span>
              </p>
              <br />

              <div className="form-group input-group">
                <div className="input-group-prepend">
                  <span className="input-group-text"> <i className="fa fa-lock"></i> </span>
                </div>
                <input type="password" className="form-control" name="confirmPassword" id="confirmnewpwd" ref="clearPwd"
                  onKeyUp={this.validateConfPwd} placeholder="Confirm New Password" required></input>
              </div>
              <p className="form-error">
                <span>{this.state.errors.confirmPassword}</span>
              </p>
              <br />

              <div className="form-group">
                <button id="change"
                  variant="primary"
                  type="submit"
                  onClick={this.onSubmit}
                  className="btn btn-primary btn-block"> Change Password </button>
              </div>

              {/* <Button
                id="clear"
                variant="primary"
                type="reset"
                onClick={this.clear}
              >
                Reset
          </Button> */}
              <br />
              <br />
            </form>
          </article>
        </div>

      </div >
    )
  }
}

ChangePassword.propTypes = {
  state: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
  state: state.register
})

export default connect(mapStateToProps, {})(ChangePassword);

