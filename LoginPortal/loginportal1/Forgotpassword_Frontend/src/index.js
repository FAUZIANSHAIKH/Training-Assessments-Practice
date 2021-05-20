import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {Router,Route} from 'react-router-dom';
import ForgotPassword from './components/ForgotPassword';
import Setpassword from './components/Setpassword';
import  history  from './history.js';
import Authenticate from './components/Authenticate';
import GetData from './components/GetData';


const router = (
    <Router history={history}>
        <div>
            <Route exact path="/" component={App}></Route>
            <Route exact path="/forgotpassword" component={ForgotPassword}></Route>
            <Route exact path="/forgotpassword/Setpassword" component={Setpassword}></Route>
            <Route exact path="/Authenticate" component={Authenticate}></Route>
            <Route exact path="/Getdata" component={GetData}></Route>
            
        </div>
    </Router>
)

ReactDOM.render(router, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
