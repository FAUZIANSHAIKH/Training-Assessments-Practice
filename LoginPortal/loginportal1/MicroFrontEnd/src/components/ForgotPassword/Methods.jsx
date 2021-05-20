import React from 'react';
import Axios from '../../Axios';
import Securityquestion from './Securityquestions';
import OTPtoMail from './OTPtoMail';

export default class Methods extends React.Component {
    constructor(props) {
        super(props)
        this.click = this.click.bind(this);
        this.state = {
            data: null,
            checked: "0"
        }
    }
    click() {
        console.log("hais")
        var cc = document.getElementsByName("method");
        var i;
        var data;
        console.log(cc)
        for (i = 0; i < cc.length; i++) {
            if (cc[i].checked) {
                data = {
                    choice: cc[i].value,
                    email: this.props.emailID
                }
            }
        }
        //Axios.post("http://10.150.176.135:8009/forgotpassword/mts",data).then(res => this.setState({data:res.data,checked:data.choice}) )
        Axios.auth.forgotPassword("/mts", data).then(res => this.setState({ data: res.data, checked: data.choice, status: res.data.status }))
        // Axios.post("http://10.150.121.20:8009/forgotpassword/mts",data).then(res => this.setState({data:res.data,checked:data.choice}));
    }
    render() {
        return (

            <div>

                <div className="form-check">
                    <input type="radio" className="form-check-input" name="method" value="1" id="1" onChange={this.click} />
                    <label className="form-check-label">
                        Send Link to email
                    </label>
                </div>

                <div className="form-check">
                    <input type="radio" className="form-check-input" name="method" value="2" id="2" onChange={this.click} />
                    <label className="form-check-label">
                        Send OTP to email
                    </label>
                </div>
                <div className="form-check">
                    <input type="radio" className="form-check-input" name="method" value="3" id="3" onChange={this.click} />
                    <label className="form-check-label">
                        Security Questions
                    </label>
                </div>
                <input className="form-control" type="email" value={this.props.email} name="email" id="email" hidden style={{ display: 'none' }}></input>
                <br />
                {this.state.checked === "1" ? this.state.status === 'true' ? "Link has been succesfully sent" : " " : ''}
                {this.state.checked === "2" ? <OTPtoMail /> : null}
                {this.state.checked === "3" ? <Securityquestion email={this.props.emailID} ques1={this.state.data.question1} ques2={this.state.data.question2} /> : ''}

            </div>
        );
    }
}