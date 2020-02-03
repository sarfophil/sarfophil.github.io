let fs = require('fs'),
    http = require('http');
//create a server object:
let server = http.createServer(function (req, res) {
   fs.readFile(__dirname + req.url,function(err,data){
    if (err) {
        res.writeHead(404);
        res.end(JSON.stringify(err));
        return;
      }
      res.writeHead(200);
      res.end(data);
   })
 
})

server.listen(8000); 