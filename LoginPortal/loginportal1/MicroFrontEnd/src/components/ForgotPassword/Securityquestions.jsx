import React from 'react';
import Axios from '../../Axios';

export default class Securityquestions extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            status: "false",
            msg: null
        }
        this.click = this.click.bind(this)
    }
    click() {
        let data = {
            ans1: document.getElementById("ans1").value,
            ans2: document.getElementById("ans2").value,
            email: this.props.email
        }
        console.log(data);
        //Axios.post("http://10.150.176.200:8076/forgotpassword/sec",data).then(res => console.log(res));
        //Axios.post("http://10.150.176.135:8009/forgotpassword/sec",data).then(res => this.setState({status:res.data.status,msg:'please enter correct answers'}));
        Axios.auth.forgotPassword("/sec", data).then(res => {
            this.setState({ status: res.data.status, msg: 'please enter correct answers' })
            if (this.state.status === 'true') {
                console.log(this.props.history);
                //this.props.history.push('/forgotpassword/Setpassword');
                window.location.replace('http://ec2-18-235-29-68.compute-1.amazonaws.com:8006/#/forgotpassword/Setpassword')
            }
        });
        //Axios.post("http://10.150.121.20:8009/forgotpassword/sec",data).then(res => this.setState({status:res.data.status,msg:'please enter correct answers'}));
    }
    render() {
        return (
            <article className="card-body mx-auto" style={{ minWidth: '500px', maxWidth: '500px' }}>
                <h5 className="card-title mt-3 text-center">Please answer the following security Questions</h5>
                <br/><br/>
                <div className="security-question">
                    <h7>{this.props.ques1}  </h7>
                </div>
                <div className="form-group input-group">
                    <input type="text" name="ans1" id="ans1" className="form-control" ></input>
                </div>
                <div className="security-question">
                    <h7>{this.props.ques2} </h7>
                </div>
                <div className="form-group input-group">
                    <input type="text" name="ans2" id="ans2" className="form-control" ></input>
                </div>

                <div className="form-group">
                    <button type="submit" id="login" variant="primary"
                        onClick={this.click} className="btn btn-primary"> Submit </button>
                </div>



            </article>


        );
    }
}