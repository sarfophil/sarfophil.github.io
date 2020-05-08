const http = require('http');
const app = http.createServer();
const path = require('path')
const fs = require('fs')

app.on('request',(req,res) => {
    res.writeHead(200,{'Content-Type':'text/html'})
    fs.readFile(__dirname + req.url,function(err,data){
        if (err) {
            res.writeHead(404);
            res.end(JSON.stringify(err));
            return;
          }
          res.writeHead(200,{'Content-Type':'text/html'});
          res.end(data);
       })
}).listen(3000);




