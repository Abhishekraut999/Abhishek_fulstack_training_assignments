const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const path = require('path');

const app = express();
const port = 3000;

app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static('public'));

// Path to the products file
const productsFilePath = path.join(__dirname, 'data', 'products.json');

// Function to read products from the file
function getProducts() {
  const data = fs.readFileSync(productsFilePath, 'utf-8');
  return JSON.parse(data);
}

// Function to save products to the file
function saveProducts(products) {
  fs.writeFileSync(productsFilePath, JSON.stringify(products, null, 2), 'utf-8');
}

// User roles
const users = [
  { username: 'admin', password: 'admin123', role: 'admin' },
  { username: 'user', password: 'user123', role: 'user' },
];

// Middleware to check authentication
let loggedInUser = null;

function authenticate(username, password) {
  return users.find(user => user.username === username && user.password === password);
}

// Routes
app.get('/', (req, res) => {
  res.render('home');
});

app.get('/login', (req, res) => {
  res.render('login', { error: null });
});

app.post('/login', (req, res) => {
  const { username, password } = req.body;
  const user = authenticate(username, password);

  if (user) {
    loggedInUser = user;
    if (user.role === 'admin') {
      res.redirect('/admin');
    } else if (user.role === 'user') {
      res.redirect('/user');
    }
  } else {
    res.render('login', { error: 'Invalid credentials!' });
  }
});

app.get('/admin', (req, res) => {
  if (loggedInUser && loggedInUser.role === 'admin') {
    const products = getProducts();
    res.render('admin', { products });
  } else {
    res.redirect('/');
  }
});

app.post('/admin/add-product', (req, res) => {
  const { name, id, price, category, manufacturingDate, expDate } = req.body;
  const products = getProducts();
  products.push({ name, id, price, category, manufacturingDate, expDate });
  saveProducts(products);
  res.redirect('/admin');
});

app.post('/admin/delete-product/:id', (req, res) => {
  const productId = req.params.id;
  
  const products = getProducts();

  const updatedProducts = products.filter(product => product.id !== productId);

  saveProducts(updatedProducts);

  res.redirect('/admin');
});

app.get('/user', (req, res) => {
  if (loggedInUser && loggedInUser.role === 'user') {
    const products = getProducts();
    res.render('user', { products, searchResults: null });
  } else {
    res.redirect('/');
  }
});

app.post('/user/search', (req, res) => {
  const { query, type } = req.body;
  const products = getProducts();
  const searchResults = products.filter(product =>
    product[type].toLowerCase().includes(query.toLowerCase())
  );
  res.render('user', { products, searchResults });
});

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
