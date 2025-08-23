# Devoir: Pratique d'examen

## Instructions

Dans un premier temps, familiarisez-vous avec le code existant. Il est conseiller d'utiliser un IDE tel que Intellij
afin de facilité la navigation dans le code. Le code n'est pas particulièrement joli, ça fait partie de l'exercice! Il
est important de développer une capacité à lire du code, c'est ce que vous ferez pour une bonne partie de vos journées
durant votre carrière. Un survol rapide du code et des pistes sont fournis ci-bas.

Par la suite, vous devez effectuer les [exercices](exercices/README.md) demandés.

Nous vous conseillons également de faire des commits dans git fréquemment.

## Survol du code

### Concept

Le code donné est une application qui permet de gérer les équipements de sécurité dans un établissement. Imaginez que
vous possédez un immeuble à bureau de 43 étages, dans lequel vous avez des extincteurs (à inspecter tous les ans, à 
changer aux 10 ans), des trousses de premiers soins (à vérifier tous les 6 mois), des DEA (à calibrer tous les 2 ans),
etc. Il devient difficile de garder la trace de tout cet arsenal! C'est pour cela que cette application a été créée.

Évidement, l'application n'en est qu'à ses balbutiements, et ses premiers pas sont quelque peu maladroits. C'est ici
que vous entrez en jeu, afin de continuer à élaborer l'application tout en vous assurant de payer la 
[dette technique](https://www.splunk.com/en_us/data-insider/what-is-tech-debt.html) déjà accumulée dans l'application.

### Environnement

Vous devez avoir java 18+ et maven d'installés. Vous pouvez utiliser l'installer manuellement, ou utiliser 
[asdf](https://asdf-vm.com/) afin d'utiliser les versions dans [.tool-versions](.tool-versions) : 

```bash
asdf plugin-add java https://github.com/halcyon/asdf-java.git
asdf plugin-add maven https://github.com/skotchpine/asdf-maven
asdf install
```

### Démarrer le serveur

Vous pouvez démarrer le serveur de deux façons. En utilisant IntelliJ, ouvrez le `main()` dans
[Serveur](question/src/main/java/ca/ulaval/glo4002/tp/intro/question/Serveur.java) et exécutez-le. Vous pouvez aussi
utiliser les commandes maven `mvn compile && mvn exec:java -pl code`.

Le serveur sera disponible à l'adresse http://localhost:8181.

### Architecture

Voici un bref aperçu de l'architecture. Certains concepts inclus dans le projet ne sont pas encore connus - c'est 
normal, nous allons les étudier durant le cours. Vous devriez tout de même pouvoir comprendre comment fonctionne le
project, même si le pourquoi n'est pas immédiatement clair. 

Premièrement, un survol des packages :

```text
ca.ulaval.glo4002.tp.intro.question
|- application: Des classes contenant la logique applicative, certains appellent ceci des "use cases".
|- domaine: La logique d'affaire, le point central de notre application!
|- infrastructure: Des détails d'implémentation "low level", tel que la BD
\--- persistence
   \--- memoire: La "BD" dans notre cas se trouve seulement en mémoire afin de simplifier le projet
|- interfaces: Le UI de notre application (rest, cli, graphique, etc)
\--- rest: Dans notre cas, nous avons un UI qui est un API REST
```

Assurez-vous également de comprendre comment la structure des projects maven fonctionne. Il y a deux `pom.xml`, 
soit un [à la racine](pom.xml) et un dans le sous-module [code](code/pom.xml).

Nous vous recommandons de commencer à explorer le code par le "haut", soit son point d'entrée (l'API REST). La couche
`application` contient présentement la majorité du code (ce qui n'est pas forcément une bonne chose - ce sera un des
objectifs du devoir!).
