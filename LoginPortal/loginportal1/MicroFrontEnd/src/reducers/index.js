import { combineReducers } from 'redux';
import RegisterReducer from './RegisterReducer'
import DeRegisterReducer from './DeRegisterReducer'

export default combineReducers({
    register : RegisterReducer,
    deregister : DeRegisterReducer
});