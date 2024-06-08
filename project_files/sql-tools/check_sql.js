const mysql = require('mysql2');

// Creating a connection to the MySQL database
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'root',
  database: 'employees',
  port: 3307
});

// Establishing the connection
connection.connect((error) => {
  if (error) {
    console.error('Error connecting to the database:', error);
    return;
  }
  console.log('Connected to MySQL database');
  
  // Perform database operations here
  
  // Closing the connection
  connection.end();
});