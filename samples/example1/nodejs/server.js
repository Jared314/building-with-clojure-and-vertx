var path = require('path'),
    express = require('express'),
    app = express(),
    port = process.env.PORT || 3000;

app.get('/currenttime', function (req, res) {
  res.send(Date.now()+'');
});

app.get('/*', function (req, res) {
  res.sendFile(path.join(__dirname, 'index.html'));
});

var server = app.listen(port, function () {
  console.log('Starting Http server on port %s', port);
});