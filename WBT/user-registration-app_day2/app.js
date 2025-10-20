const express = require("express");
const mysql  = require("mysql");
const app = express();
app.use(express.urlencoded({extended: true}));
const db= mysql.createConnection({
    host: 'localhost',
     user: 'root',     
    password: 'YashChatse',      
    database: 'ygfchatse'

});
db.connect(err => {
    if (err) throw err;
    console.log('Connected to MySQL');
});

// Serve a simple HTML form
app.get('/', (req, res) => {
    res.send(`
        <h2>User Registration</h2>
        <form action="/register" method="post">
            First Name: <input type="text" name="firstName" required><br><br>
            Last Name: <input type="text" name="lastName" required><br><br>
            Email: <input type="email" name="email" required><br><br>
            User ID: <input type="text" name="userId" required><br><br>
            Password: <input type="password" name="password" required><br><br>
            <button type="submit">Register</button>
        </form>
    `);
});


app.post('/register', (req, res) => {
    const { firstName, lastName, email, userId, password } = req.body;

    const sql = 'INSERT INTO Users (first_name, last_name, email, user_id, password) VALUES (?, ?, ?, ?, ?)';
    db.query(sql, [firstName, lastName, email, userId, password], (err, result) => {
        if (err) {
            console.log(err);
            return res.send('Error saving data!');
        }
        res.send('User registered successfully!');
    });
});

app.listen(3000, () => {
    console.log('Server running at http://localhost:3000');
});