import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import ActiveUsers from './components/ActiveUsers';
import Admin from './components/Admin';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter as Router,Route,Link } from 'react-router-dom';

//ReactDOM.render(<App />, document.getElementById('root'));

const router=(
    <Router>
        
            <Route exact path="/" component ={App}/>
            <Route exact path="/activeusers" component ={ActiveUsers}/>
    </Router>
);

 

ReactDOM.render(
router,
document.getElementById('root'));
