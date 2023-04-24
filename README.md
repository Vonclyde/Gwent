# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**

En la implementación para Player, decidí usar clases adicionales para el mazo y la mano del Jugador. El constructor de ambos se inicializa solo con una lista de cartas, luego se calcula la cantidad de cartas que hay en ellos. Esto lo hice con el fin de facilitar la funciones play() y draw() del Jugador, play para jugar una carta de la mano y draw para robar la carta en la parte superior del mazo.

En la implementación de Carta, existe una superclase Card la cual utilicé para testear las funciones del jugador para jugar y robar cartas. Adicionalmente creé una subclase WeatherCard de momento para futura implementación de las cartas de este tipo, y también para las cartas de tipo unidad creé una interfaz para ellas la cual solo contiene el nombre. Finalmente hay una clase abstracta AbstractUnitClass que corresponde a una carta de unidad sin ninguna categoría, con esto se crearon las clases Melee, Ranged y Siege, para las clasificaciones de las cartas de este tipo.