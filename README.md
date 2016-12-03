# JEU_HTTP
Exemple d'implémentation d'une application web JEE sous forme d'un jeu http. Le but est de créer une application web JEE qui sépare la logique métier de la logique présentation. On respecte dans la couche web le pattern MVC.

Pour rappeler, le principe du jeu est le suivant :

- L'ordinateur tire au sort un nombre entre 0 et 100.
- Il demande à l'utilisateur de deviner le nombre. L'utilisateur entre donc un nombre entre 0 et 100.
- L'ordinateur compare le nombre de l'utilisateur avec le nombre qu'il a tiré au sort. Il dit à l'utilisateur si le nombre est supérieur ou inférieur à celui que l'utilisateur a entré.
- Puis l'ordinateur redemande à l'utilisateur le nombre.
- Et il indique à l'utilisateur si le nombre est supérieur ou inférieur.
- Et ainsi de suite, jusqu'à ce que l'utilisateur trouve le nombre aléatoire.

Le projet aborde les éléments suivants :

- La création d'un projet web dynamique basé sur tomcat.
- La création et le déployement d'une servlet
- La création d'une JSP en utilisant JSTL
- L'utilisation des objet request, response et session.
