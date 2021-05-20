import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Main from './components/Main';
import UserDetails from './components/UserDetails';
import AddMovie from './components/AddMovie';
import DeleteMovie from './components/DeleteMovie';
import {BrowserRouter as Router , Route ,Link} from 'react-router-dom';
const router=(
    <Router>
        <ul>
           
            <li><Link to="/main">List Movies</Link></li>
            <li><Link to="/add">AddMovies</Link></li>
             <li><Link to="/delete">DeleteMovies</Link></li>
            
            
        </ul>
        
            <Route exact path="/app" component={App}/>
            <Route  path="/main" component={Main}/>
            <Route path="/users/:id" component={UserDetails}/>
            <Route path="/add" component={AddMovie}/>
            <Route path="/delete/:id" component={DeleteMovie}/>
       
    </Router>
)

ReactDOM.render(router, document.getElementById('root'));
