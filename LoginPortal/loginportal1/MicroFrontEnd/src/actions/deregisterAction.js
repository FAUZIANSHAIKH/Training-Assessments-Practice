import {
    FETCH_USER_NAME
} from './types';

export const fetchUserName = (data) => (dispatch) => {
    console.log(data);
    return dispatch({
        type: FETCH_USER_NAME,
        payload: data
    })
}