const express = require('express');
const app = express();
const cors = require("cors");

app.use(express.json());

// mettre le serveur à l'écoute(en marche) sur le port 90
app.listen(
    90,
    ()=>{console.log("Serveur Express a l ecoute sur le port 90");}
);

var corsOptions = {
    //origin: "http://localhost:4200"
    origin: "*"
  };

app.use(cors(corsOptions));

// CONNEXION TO DATABASE MONGODB
const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017';
const dbName = 'gestibank';
let db 
MongoClient.connect(url, function(err, client) {
 console.log("Connexion réussi avec Mongo");
 db = client.db(dbName);
});

// CUSTOMER CRUD REQUESTS

// Get all clients by role's filter  
app.get('/customers/list', (req,res) => {
    db.collection('users').find({"role": "CUSTOMER"}).toArray(function(err, docs) {
        if (err) {
            console.log(err)
            throw err
        }
        res.status(200).json(docs)
      }) 
  })

app.get('/customers/waiting/list', (req,res) => {
    db.collection('users').find({"role": "CUSTOMER", "status" : "WAITING"}).toArray(function(err, docs) {
        if (err) {
            console.log(err)
            throw err
        }
        res.status(200).json(docs)
      }) 
  })

app.get('/customers/validated/list', (req,res) => {
    db.collection('users').find({"role": "CUSTOMER", "status" : "VALIDATED"}).toArray(function(err, docs) {
        if (err) {
            console.log(err)
            throw err
        }
        res.status(200).json(docs)
      }) 
  })

app.post('/customers/add',  async (req,res) => {
    try {
           const newCustomer = req.body
           const addedCustomer = await db.collection('users').insertOne(newCustomer)
           res.status(200).json(addedCustomer)
       } catch (err) {
           console.log(err)
           throw err
       } 
 })

 app.put('/customers/update/:email',  async (req,res) => {
    try {
        const email = req.params.email;
        const updateCustomer = req.body
        const customer = await db.collection('users').replaceOne({email, "role" : "CUSTOMER"},updateCustomer)
        res.status(200).json(customer)
    } catch (err) {
        console.log(err)
        throw err
    }
 })

 app.delete('/customers/delete/:email',  async (req,res) => {
    try {
        const email = req.params.email
        const customer = await db.collection('users').deleteOne({email})
        res.status(200).json(customer)
    } catch (err) {
        console.log(err)
        throw err
    } 
  })

// ALL USERS

app.get('/user/:email',  async (req,res) => {
    try {
        const email = req.params.email;
        const user = await db.collection('users').findOne({email})
        res.status(200).json(user)
    } catch (err) {
        console.log(err)
        throw err
    }
 })
 

// AGENT CRUD REQUESTS

app.get('/agents/list', (req,res) => {
    db.collection('users').find({"role": "AGENT"}).toArray(function(err, docs) {
        if (err) {
            console.log(err)
            throw err
        }
        res.status(200).json(docs)
      }) 
  })

app.post('/agents/add',  async (req,res) => {
    try {
           const newAgent = req.body
           const addedAgent = await db.collection('users').insertOne(newAgent)
           res.status(200).json(addedAgent)
       } catch (err) {
           console.log(err)
           throw err
       } 
 })

app.put('/agents/update/:matricule',  async (req,res) => {
    try {
        const matricule = req.params.matricule;
        const updateAgent = req.body
        const agent = await db.collection('users').replaceOne({"role" : "AGENT", matricule},updateAgent)
        res.status(200).json(agent)
    } catch (err) {
        console.log(err)
        throw err
    }
 })






// ADMIN CRUD REQUESTS

app.get('/admins/list', (req,res) => {
    db.collection('users').find({"role": "ADMINISTRATOR"}).toArray(function(err, docs) {
        if (err) {
            console.log(err)
            throw err
        }
        res.status(200).json(docs)
      }) 
  })

app.post('/admins/add',  async (req,res) => {
    try {
           const newAdmin = req.body
           const addedAdmin = await db.collection('users').insertOne(newAdmin)
           res.status(200).json(addedAdmin)
       } catch (err) {
           console.log(err)
           throw err
       } 
 })

 app.put('/admins/update/:matricule',  async (req,res) => {
    try {
        const matricule = req.params.matricule;
        const updateAdmin = req.body
        const admin = await db.collection('users').replaceOne({"role" : "ADMINISTRATOR", matricule},updateAdmin)
        res.status(200).json(admin)
    } catch (err) {
        console.log(err)
        throw err
    }
 })