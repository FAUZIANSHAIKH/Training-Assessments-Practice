let Movie = require('./movieModel')
exports.create=function(req,res){
    res.header('Access-Control-Allow-Origin',"*");
    console.log('Came inside the save method of MoviesController');
    let movie = new Movie();
    movie.name=req.body.name;
    movie._id=req.body._id;
    movie.save(function(err){
        res.header('Access-Control-Allow-Origin',"*");
        // console.log('Came inside the movie method of MoviesController');
        // console.log(err);
        res.json({
            status:'Successfully Saved',
            // data:movie
        })
    })

    
};


exports.listAll = function (req, res) {
    res.header('Access-Control-Allow-Origin',"*");

    Movie.find(function (err, movies) {
        if (err) {
            
            res.json({
                status: "error",
                message: err,
            });
        }
        res.json({
            status: "success",
            message: "Movies retrieved successfully",
            data: movies
        });
    });
};
// exports.listAll = function(req,res){
    
//     res.json([
//         {
//             id:1,
//             name:'Kal Ho Na Ho'
//         },
//         {
//             id:2,
//             name:'Jurassic Park'
//         }

//     ]
//     );
// };
// exports.findById=function(req,res){
//     console.log(req.params.id);
//     res.json([
//         {
//             id:1,
//             name:'Kal Ho Na Ho'
//         }
//     ])
// }
exports.findByID = function (req, res) {
    res.header('Access-Control-Allow-Origin',"*");

    Movie.findById(req.params.id, function (err, movies) {
        if (err)
            res.send(err);
        res.json({
            message: 'Movies details loading..',
            data: movies
        });
    });
};
exports.delete = function (req, res) {
    res.header('Access-Control-Allow-Origin',"*");

    Movie.remove({
        _id: req.params.id
    }, function (err, movies) {
        if (err)
            res.send(err);
res.json({
            status: "success",
            message: 'Movie deleted'
        });
    });
};
exports.update = function (req, res) {
    res.header('Access-Control-Allow-Origin',"*");

    Movie.findById(req.params.id, function (err, movies) {
            if (err)
                res.send(err);
    movies.name = req.body.name ? req.body.name : movies.name;
            
            
           
    // save the contact and check for errors
            movies.save(function (err) {
                if (err)
                    res.json(err);
                res.json({
                    message: 'Movie Info updated',
                    data: movies
                });
            });
        });
        
  
    };