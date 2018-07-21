var express = require('express');

var app = express();
app.get('/', function (req, res){
    res.send('Hello Word');
});

app.listen(3000, function () {
    console.log('Exemplo app listing on port 3000!');
});


