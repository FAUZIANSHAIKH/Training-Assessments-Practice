/**
  * 1990-2019 Publicis Sapient Corporation. All rights reserved.   
*/
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';  
import {Router, Route} from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import history from './history';
import Login from './components/Login/Login';
import RegistrationPage from './components/Register/RegistrationPage';
import ConfirmMail from './components/UserConfirmation/ConfirmMail';
import ForgotPassword from './components/ForgotPassword/ForgotPassword';
import Setpassword from './components/ForgotPassword/Setpassword';
import Admin from './components/Admin/admin';
import DeregisterButton from './components/DeRegister/DeregisterButton';
import EditProfile from './components/EditProfile/edit_profile';
import ChangePassword from './components/ChangePassword/ChangePassword';
import DisplayReviews from './components/DeRegister/DisplayReviews';
import ActiveUsers from './components/Admin/ActiveUsers';
// import Register from './components/Register';
import Home from './components/Home';
import CheckEmail from './components/Register/CheckEmail';
import { Provider } from 'react-redux';
import store from './store/store';

// All routing details
const router = (
   <Provider store={store}>
               <ToastContainer />
        <Router history = {history}>
        <ul>
            <Route exact path="/" component={Login} /> <br />
            <Route exact path="/register" component={RegistrationPage} /> <br />
            <Route exact path="/confirmmail/:uid" component={ConfirmMail} /> <br />
            <Route exact path="/forgotpassword" component={ForgotPassword} /> <br />
            <Route exact path="/forgotpassword/SetPassword" component={Setpassword} /> <br />
            <Route exact path="/admin" component={Admin} /> <br />
            <Route exact path="/activeusers" component={ActiveUsers} /> <br />
            <Route exact path='/welcome' component={DeregisterButton} /> <br/>
            <Route exact path='/update' component={EditProfile} /> <br/>
            <Route exact path='/change' component={ChangePassword} /> <br/>
            <Route exact path='/reviews' component={DisplayReviews} /> <br/>

            <Route exact path="/checkmail" component={CheckEmail} /> <br />
        </ul>
    </Router>
   </Provider>
)


ReactDOM.render(
    router, 
    document.getElementById('root'));
