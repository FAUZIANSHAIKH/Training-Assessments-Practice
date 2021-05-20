import React from 'react'
export default class Reviews extends React.Component{
    constructor(props){
        super(props);
        //console.log(this.state)
    }
    render(){
        return(
            <div>
                <h5>{this.props.index}.  {this.props.review}</h5>
            </div>
        )
    }
}