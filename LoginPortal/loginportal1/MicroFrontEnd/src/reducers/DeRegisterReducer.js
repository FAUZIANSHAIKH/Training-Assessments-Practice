import {
    FETCH_USER_NAME
  } from '../actions/types';
  
  const inState = {
    userDetails: {
      userId: "",
      
    },
    allcorrect: true,
    // fullList: [],
    userId: ""
  
  };
  
  export default function (state = inState, action) {
    switch (action.type) {
     
      
      case FETCH_USER_NAME:
        return {
          ...state,
          userDetails: { ...state.userDetails , userId : action.payload}
          
        }
  
      default:
        return state;
    }
  }