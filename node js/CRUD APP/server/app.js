// creating expresss server
const express = require('express')
const app = express()
const port = process.env.PORT||3000
const mongoose=require("mongoose")
const cors = require("cors")

//schema definition
const TacheSchema = new mongoose.Schema({
    titre:String,
    description:String,
    Statut:String
})
const Tache =mongoose.model("Tache", TacheSchema)


//principal routes
app.get("/", (req, res)=>{
    res.send("welcome")
})

// Middleware
app.use(cors());
app.use(express.json());

// Routes pour CRUD
// Créer une nouvelle tâche
app.post('/taches', async (req, res) => {
  try {
    const nouvelleTache = new Tache(req.body);
    await nouvelleTache.save();
    res.status(201).json(nouvelleTache);
  } catch (error) {
    res.status(500).json({ error: 'Erreur lors de la création de la tâche' });
  }
});

// Lister toutes les tâches
app.get('/taches', async (req, res) => {
  try {
    const taches = await Tache.find();
    res.json(taches);
  } catch (error) {
    res.status(500).json({ error: 'Erreur lors de la récupération des tâches' });
  }
});

// Mettre à jour une tâche par ID
app.put('/taches/:id', async (req, res) => {
  try {
    const tache = await Tache.findByIdAndUpdate(req.params.id, req.body, { new: true });
    res.json(tache);
  } catch (error) {
    res.status(500).json({ error: 'Erreur lors de la mise à jour de la tâche' });
  }
});

// Supprimer une tâche par ID
app.delete('/taches/:id', async (req, res) => {
  try {
    await Tache.findByIdAndRemove(req.params.id);
    res.json({ message: 'Tâche supprimée avec succès' });
  } catch (error) {
    res.status(500).json({ error: 'Erreur lors de la suppression de la tâche' });
  }
});


;

// Connexion à MongoDB en utilisant une promesse
mongoose.connect('mongodb://localhost:27017/Gest_Taches', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log('Connexion à MongoDB établie avec succès');
  })
  .catch((error) => {
    console.error('Erreur de connexion à MongoDB :', error);
  });


// Connectez-vous à MongoDB et démarrez le serveur Express

  app.listen(port, () => {
    console.log(`Serveur en cours d'exécution sur le port ${port}`);
  });







