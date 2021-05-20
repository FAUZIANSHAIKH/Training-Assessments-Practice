//var swaggerUi = require('swagger-ui-express'),
  //  swaggerDocument = require('./swagger.json');

//app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));
let express = require('express');
let apiRoutes=require('./api-routes');
let bodyParser = require('body-parser');
let mongoose = require('mongoose');
var cors1=require('cors');

let app=express();
app.use(cors1());
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());
mongoose.connect('mongodb://localhost/resthub',{useNewUrlParser: true})
var db=mongoose.connection;

if(!db)
    console.log("Error connecting Db")
else
    console.log("Db connected Successfully")
app.get('/',(req, res)=>{
    res.send(JSON.stringify({message:'Hello world from Express!!'}))
});
app.use('/api',apiRoutes);
let port = process.env.PORT || 8001;
app.listen(port,()=>{
    console.log('Server started....');
})
