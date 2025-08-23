# Exercice : Un peu de ménage!

Dans un premier temps, il serait intéressant de rendre le code plus lisible. Votre objectif est d'améliorer la qualité
de tout le codebase. Afin de vous aider, voici une liste de suggestions d'étapes à suivre. Vous n'êtes pas obligés
de procéder dans cet ordre, ce ne sont que des suggestions. Le résultat final doit être un code que vous seriez
fier de pousser en *pull request* dans un emploi ou dans un projet d'équipe!

## Clean code 

La classe `ServiceInspection` est, en bon français, un _mess_!

Avant de faire un _refactoring_ (réusinage) en profondeur de cette classe, il est important de la rendre lisible, afin
d'éviter de faire des erreurs lors du refactoring.

Dans cet objectif, rendez le code de `ServiceInspection` plus lisible en utilisant les concepts de Clean Code vu dans
vos cours précédents. Vous pouvez créer d'autres classes, extraire des fonctions, etc. au besoin, mais limitez-vous
aux problèmes de Clean Code. Si vous essayez de tout réécrire d'un seul coup, vous ferez inévitablement des erreurs.

_Note_: Afin d'éviter des problèmes de Clean Code dans le futur, il existe des outils tels que
[checkstyle](https://checkstyle.sourceforge.io/). Ne l'ajoutez pas au projet dans le cadre de ce devoir, mais vous pourriez le considérer dans le cadre
de votre projet d'équipe plus tard dans la session! Vous trouverez des instructions d'installation
[ici](https://maven.apache.org/plugins/maven-checkstyle-plugin/usage.html). Il existe aussi des configurations pré-faites, telles que [celle de google](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml),
mais n'hésitez pas à la modifier si vous n'aimez pas certains aspects! Par exemple,
personnellement, je trouve qu'une longueur de ligne maximale à 100 est plutôt bas, je préfère 160 (on a tous
des moniteurs 1080p de nos jours!).

## Polymorphisme

Dans la classe `NoEtablissement`, on peut voir une opportunité manquée d'utiliser du polymorphisme. L'objectif était de
supporter deux types d'ID (les anciens qui sont des chiffres, et les nouveaux qui sont des UUID).

Cette implémentation maladroite mène à quelques complications :

- Dans les méthodes `equals`, `hashCode` et `asString`: il faut toujours commencer par voir quel "version" est utilisée
  avant de poser une action
- La méthode `genererV1` est dépréciée, mais elle devrait idéalement être simplement supprimée, vu qu'elle ne fait
  que lancer une exception
- Dans la méthode `InspectionRessource::etatDesEquipements`, la ressource REST doit connaitre les versions du numéro. On peut
  facilement imaginer que cette connaissance devra être dupliquée dans toutes les méthodes qui gèrent des numéros
  d'établissement

Procédez à un refactoring (réusinage) du code afin d'utiliser du polymorphisme et régler ces problèmes. Pensez également
à une façon d'éviter que le code servant a identifié la version de l'ID ne soit dupliqué dans toutes les ressources. Un
_design pattern_ tel que la [factory](https://www.baeldung.com/java-factory-pattern) (ou la factory method qui est aussi
mentionnée dans cet article, faites un choix judicieux!).

_Note_: Les méthodes `equals` et `hashCode` doivent demeurer, celles-ci sont nécessaires pour la BD (une HashMap).

## Refactoring complet

Procédez maintenant au réusinage (refactoring) complet du code.

Il est conseillé d'écrire également les tests pour le nouveau code. Ceci vous permet de pratiquer, mais, encore plus important, les tests seront une bonne critique de votre architecture. Les tests vous parlent! Si c'est dur à tester, il y a probablement une meilleure solution.

Qu'est-ce que nous entendons par réusinage complet? Cet exercice inclut **tous** les concepts vus dans le cours et dans
les cours préalables. Référez-vous au semainier du cours pour avoir un aperçu de ceux-ci. Entre autre, il y a
certainement des problèmes avec le non-respect des principes de base tel que le clean code, OO (SOLID, TDA, etc) et
architecturaux (couches applicatives, design du domain, etc).
