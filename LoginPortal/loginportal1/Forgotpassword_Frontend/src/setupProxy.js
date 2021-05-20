const proxy = require('http-proxy-middleware');
module.exports = function(app) {
    app.use(proxy('/Getdata', 
        { target: 'http://localhost:8762/reviews-api/user/hello' }
    ));
}