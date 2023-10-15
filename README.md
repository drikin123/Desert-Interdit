# Explanation (French)


Nous avons tout d'abord réalisé le diagramme des classe , pour avoir une vision claire de la conception du projet.
Nous avons crée les différentes classes : Case, Controleur,Desert, Direction, Joueur, Main, Oeil, Piece, TypeZone et Vue.

Description Classe Case :
Le code ci-dessus est une implémentation de la classe "Case" pour un jeu de plateau appelé "Déert Interdit". Cette classe représente une case individuelle du plateau et contient des informations sur le niveau de sable présent sur la case, sa position dans le plateau et son contenu (s'il y a des joueurs ou non).
La classe "Case" comporte plusieurs méthodes, telles que "ensabler()" et "desensabler()" qui permettent d'augmenter ou de diminuer le niveau de sable sur la case, et "retourner()" qui indique si la case a été retournée ou non.
La méthode "getVoisin()" permet d'obtenir la case voisine dans une certaine direction donnée, en vérifiant si elle existe et en la renvoyant si elle est valide. La méthode "deplaceCase()" permet quant à elle de déplacer la case actuelle vers une case voisine si elle est valide et si elle ne contient pas de sable.
Enfin, la méthode "toString()" est utilisée pour afficher le niveau de sable présent sur la case ou le symbole "#" s'il y a des joueurs sur cette case.
Dans l'ensemble, ce code fournit une implémentation solide de la classe "Case" pour le jeu de plateau "Désert Interdit", avec des fonctionnalités utiles pour gérer les niveaux de sable et les déplacements de cases.


Description Classe Direction :
Le code ci-dessus présente une implémentation de l'énumération "Direction" pour le jeu de plateau "Déert Interdit". Cette énumération permet de représenter les différentes directions possibles dans lesquelles les joueurs peuvent se déplacer sur le plateau.
L'énumération "Direction" comporte deux méthodes: "getOpposee()" et "random()". La méthode "getOpposee()" renvoie la direction opposée à la direction actuelle, par exemple, si la direction actuelle est "NORD", la méthode renvoie "SUD".
La méthode "random()" est utilisée pour générer une direction aléatoire, en utilisant la classe "Random" de Java. Elle retourne l'une des quatre directions possibles (NORD, SUD, EST, OUEST) de manière aléatoire.

Description Classe Main :
Le code ci-dessus est la classe "Main" pour le jeu "Déert Interdit". Cette classe est utilisée pour tester et démontrer le fonctionnement du jeu en exécutant différentes méthodes.
Dans la méthode "main()", la première étape est la création du plateau de jeu en créant un tableau de "Case" de taille "Desert.HAUTEUR" par "Desert.LARGEUR". Ensuite, un objet "Desert" est créé en utilisant ce tableau de "Case".
Le code teste ensuite différentes méthodes du jeu, telles que l'ajout de sable à certaines cases, l'ajout d'un œil pour repérer les artefacts, la soufflerie de sable, le déplacement des joueurs et la modification des contenus des cases.
Le code commenté montre des tests supplémentaires pour des méthodes telles que "deplacerOeil()" et "deplacerJoueur()".

Description Classe Piece:
Le code ci-dessus présente l'implémentation d'une énumération nommée "Piece" avec des élément tels que : moteur,
helice, gouvernail, capteur, dans le contexte du jeu "Le désert interdit". Dans ce contexte, le jeu consiste de reconstruire le vaisseau .

Description Classe Type Zone:
Le code ci-dessus présente l'implémentation d'une énumération nommée "TypeZone". Cette énumération représente les différents types de zones qui peuvent être rencontrés dans le jeu "Le désert interdit".
Les valeurs de l'énumération "TypeZone" incluent "Oasis", "Oasis2", "Crash", "Piste", "Indice", "Indice2", "Indice3", "Indice4" et "Tunnel". Chaque valeur représente un type de zone spécifique dans le désert.

Description Classe Vue :
Le code crée également une instance de la classe Controleur en utilisant l'objet "desert" créé précédemment. L'objet "jeu" est également créé en passant l'objet "desert" à la classe Controleur.
Ensuite, le code crée plusieurs boutons pour les actions que le joueur peut effectuer dans le jeu, tels que "deplacer", "explorer", "desensabler", "ramasser" et "chaleur". Ces boutons ont des écouteurs d'événements associés pour traiter les actions de l'utilisateur lorsqu'il clique sur ces boutons.
Le bouton "souffler" simule une tempête de sable qui souffle dans le désert et modifie l'état du désert en conséquence.
Le code crée également une interface utilisateur graphique (GUI) pour le jeu en utilisant la bibliothèque Swing de Java. La fenêtre principale contient les boutons d'actions et l'affichage du désert. Le niveau de tempête actuel est affiché dans un panneau séparé sur le côté droit de la fenêtre.
Enfin, la méthode "main" du code exécute toutes ces étapes et affiche la fenêtre principale du jeu.

Description Classe Oeil :
Ce code définit une classe Oeil qui hérite de la classe Case. Cette classe représente un objet "œil" qui est placé sur une case particulière du désert et qui permet de surveiller les cases adjacentes dans toutes les directions.
La classe Oeil a deux attributs de classe : coordVOI et coordVOJ qui représentent les coordonnées de l'œil sur la grille du désert.
Le constructeur de la classe prend en paramètres deux entiers représentant les coordonnées de la case sur laquelle l'œil est placé. Ces coordonnées sont utilisées pour initialiser les attributs d'instance i et j de la classe Case.
La méthode toString() est redéfinie pour renvoyer une chaîne de caractères représentant l'œil, qui est représenté par le symbole "@" dans le jeu.

Description Classe Joueur :
Ce code définit une classe Joueur qui représente un joueur dans le jeu. Le joueur dispose d'une quantité d'eau qui peut être modifiée avec les méthodes eau_down() et eau_up(), ainsi qu'une liste de pièces qu'il a collectées, qui peut être obtenue avec la méthode getPiece(), et à laquelle on peut ajouter une pièce avec la méthode addPiece().
La quantité d'eau du joueur ne peut pas dépasser 5, et la méthode eau_down() permet de décrémenter cette quantité d'eau de 1 si elle est supérieure à 0. La méthode eau_up() permet d'incrémenter la quantité d'eau de la valeur passée en paramètre.
La méthode toString() retourne la représentation textuelle du joueur, ici "#".

Description Classe Desert :
Ce code représente une classe en Java appelée "Desert", qui contient des méthodes pour gérer un jeu de simulation de désert. Voici une description des principales parties de ce code:
    La classe possède deux constantes statiques: LARGEUR et HAUTEUR, qui représentent respectivement la largeur et la hauteur du désert.
    Il y a également une variable statique "niveauTempete" qui est un entier, qui représente le niveau d'une tempête dans le désert.
    La classe possède une variable de classe "cases", qui est un tableau à deux dimensions d'objets de type "Case". Cette variable est utilisée pour stocker toutes les cases du désert.
    La classe possède une variable "oeil" qui représente l'œil du joueur dans le désert.
    Il y a plusieurs méthodes pour récupérer et modifier la variable "cases", ainsi que pour récupérer et modifier la variable "oeil".
    Il y a une méthode de constructeur qui prend en paramètre un tableau de cases "cases", et qui initialise toutes les cases du désert avec des instances de la classe "Case".
    Il y a des méthodes pour sélectionner une case, déclarer une case, déplacer un œil, transformer une case en un œil et vice versa, explorer des cases, augmenter la quantité d'eau pour chaque joueur, et vérifier si un joueur a gagné la partie.
    La méthode "souffler" prend en paramètre une direction et une force et déplace l'œil dans cette direction en fonction de la force. Cette méthode est utilisée pour simuler les tempêtes de sable dans le désert.
    Il y a également des méthodes pour gérer les mouvements des joueurs et pour vérifier si un joueur a gagné la partie.
    D'autres méthodes sont présentes comme les suivantes:
    deplaceJoueur(Direction direction): Cette méthode permet de déplacer le joueur dans une direction donnée. Elle récupère d'abord la position actuelle du joueur, puis la case qui est adjacente dans la direction demandée. Si cette case est valide (non nulle, avec un niveau de sable inférieur à 2, non occupée par un Oeil et non déjà visitée), elle déplace le joueur dans cette case et vide la case d'origine. Enfin, elle incrémente le nombre d'actions effectuées.
    desensablevoisin(Direction direction): Cette méthode permet de désensabler la case voisine dans la direction donnée. Elle récupère la position actuelle du joueur, puis la case voisine dans la direction demandée. Si cette case est valide, elle la désensable (si c'était une case de niveau de sable 1) et incrémente le nombre d'actions effectuées.
    desensableActuelle(): Cette méthode permet de désensabler la case sur laquelle se trouve actuellement le joueur. Elle récupère la position actuelle du joueur, puis la case correspondante. Elle la désensable (si c'était une case de niveau de sable 1) et incrémente le nombre d'actions effectuées.
    explorer2(Direction direction), deplaceJoueur2(Direction direction), desensablevoisin2(Direction direction), desensableActuelle2(): Ces méthodes sont similaires aux précédentes, mais elles sont destinées à gérer un deuxième joueur.
    explorer3(Direction direction), deplaceJoueur3(Direction direction), desensablevoisin3(Direction direction), desensableActuelle3(): Ces méthodes sont similaires aux précédentes, mais elles sont destinées à gérer un troisième joueur.
    quelPiece(TypeZone t): Cette méthode prend en paramètre un type de zone et retourne la pièce correspondante (moteur, hélice, gouvernail ou capteur) si le type est valide.
    ramasser(), ramasser2(), ramasser3(): Ces méthodes permettent de ramasser une pièce si le joueur se trouve sur une case contenant une zone d'indice. Elles récupèrent la position actuelle du joueur, puis la case correspondante. Si cette case contient une zone d'indice et que le joueur est positionné sur cette case, la méthode retire la zone d'indice de la case, ajoute la pièce correspondante au joueur et incrémente le nombre d'actions effectuées.
    niveauEau(), niveauEau2(), niveauEau3(): Ces méthodes retournent le niveau d'eau actuel du joueur, du deuxième joueur et du troisième joueur respectivement.
    mortdeSoif(): Cette méthode retourne true si le niveau d'eau de l'un des joueurs est égal à zéro, et false sinon.
    eauDown(), eauDown2(), eauDown3(): Ces méthodes permettent de faire diminuer le niveau d'eau du joueur, du deuxième joueur et du troisième joueur respectivement. Cette diminution n'a lieu que si le joueur ne se trouve pas sur une case tunnel.
    getIJoueur(), getJJoueur(), `

En résumé, cette classe est utilisée pour gérer les interactions et les événements qui se produisent dans un jeu de simulation de désert.


Description Classe Controleur  :
Ce code est un extrait de la classe "Controleur"  en utilisant la bibliothèque Swing en Java.
La classe "Controleur" étend la classe "JPanel" de Swing et contient des références à l'objet "Desert" et à la taille des cases utilisées pour dessiner la grille.
Le constructeur de la classe initialise la couleur de fond et la taille préférée du panneau. Il crée également un JLabel pour afficher l'icône de la tempête en fonction du niveau de la tempête dans le désert.
La méthode "paintComponent" est appelée chaque fois que le panneau est dessiné. Elle dessine la grille en utilisant différentes images en fonction du contenu de chaque case du désert (oasis, crash, piste, indices, etc.). Elle dessine également le joueur (ou les joueurs) en utilisant une image spécifique.
La méthode "ecranFinal" est appelée lorsque la partie est terminée et affiche un message en fonction du résultat de la partie. Si la partie est terminée, elle supprime le panneau de jeu actuel et crée un nouveau panneau pour afficher le message final et un bouton "Quitter". Le bouton "Quitter" ferme l'application lorsque l'utilisateur clique dessus.


Description Jeu d'images :
Nous avons stockés dans le dossier images , l'ensemble des images caractérisant les différentes zones du désert, les joueurs...etc.
