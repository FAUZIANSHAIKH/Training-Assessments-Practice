let mongoose = require('mongoose');
const movieSchema = mongoose.Schema({
    name:{
        type:String,
        required:true
    },
    _id:{
        type:String,
        required:true
    }
})
module.exports = mongoose.model('Movie',movieSchema);