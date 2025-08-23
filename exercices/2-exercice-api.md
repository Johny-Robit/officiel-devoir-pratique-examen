# Exercice : Un nouvel API

⚠️ Vous pouvez faire cet exercice avant le refactoring si vous voulez, mais vous vous rendez la tâche plus 
difficile. Il sera plus simple de faire un nouvel API basé sur du code propre.

Dans `InspectionRessource`, nous avons un API `GET` permettant d'obtenir le status des équipements. Cependant, la BD
est toujours vide!

Créez un nouvel API qui permet de créer un établissement avec des équipements. Vous devez respecter la spécification
suivante **à la lettre** :

**Requête**

`HTTP POST /etablissements`

```json
{
  "nom": "Édifice ABC"::string,
  "equipements": [
    {
      "type": "perimable"::enum(perimable,contenant),
      "noSerie": "123"::string,
      "description": "Défibrilateur"::string,
      "localisation": "Bureau 102"::string,
      "derniereInspection": "2023-08-05T12:00:00"::date,
      "dureeValiditeEnJours": 90::int,
      "datePeremption": "2025-12-01T00:00:00"::date
    },
    {
      "type": "contenant":enum(perimable,contenant),
      "noSerie": "TS4":string,
      "description": "Trousse de premiers soins"::string,
      "localisation": "Réception"::string,
      "derniereInspection": "2023-08-05T12:00:00"::date,
      "dureeValiditeEnJours": 365::int,
      "equipements": [
        {
          "type": "perimable"::enum(perimable,contenant)
          // [... autres propriétés ...]
        }
      ]
    }
  ]
}
```

**Réponse**

`HTTP 201 Created`

`Location: /etablissements/{numero}` <-- ceci est un "header http"

```json
{
  "numero": "<le UUID généré ici>"::string
}
```

Assurez-vous que votre API fonctionne correctement! Vous pouvez démarrer le serveur et utiliser un outil
tel que [Postman](https://www.postman.com/) (il en existe plusieurs autres, IntelliJ en a même un d'intégré).

_Note_: La méthode pour sauvegarder un établissement est disponible dans `EtablissementStockage` et ses
implémentations.

_NOTE SUPER IMPORTANTE_: Assurez-vous de respecter la spécification à la lettre. Ce sera un requis lors du projet de
session (et durant toute votre carrière). Dire "ahh, mais c'était seulement une petite typo" n'est pas une bonne 
excuse, vous pouvez chercher "bugs caused by typos" sur Google si vous voulez!

