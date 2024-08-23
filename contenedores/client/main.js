const express = require('express');
const client = require('./client');

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    client.getUsers({}, (error, data) => {
        if (!error) {
            console.log(data);
            res.send(data);
        } else {
            console.error(error);
            res.status(500).send({ msg: error.message });
        }
    });
});

app.post('/add', (req, res) => {
    const user = req.body;
    client.addUser(user, (error, data) => {
        if (!error) {
            console.log(data);
            res.send({ msg: 'Data added successfully.', user: data });
        } else {
            console.error(error);
            res.status(500).send({ msg: error.message });
        }
    });
});

app.listen(5555, () => {
    console.log('Server started on 5555.');
});