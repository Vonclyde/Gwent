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

Se añadieron las clases correspondientes para jugar correctamente las cartas, estas representan el área donde el jugador juega sus cartas (class Battleground) y una clase para representar el tablero en donde se desarrolla la partida (class Board).

En la implementación para Player, decidí usar clases adicionales para el mazo y la mano del Jugador. El constructor de ambos se inicializa solo con una lista de cartas, tienen una función para entregar la cantidad de cartas en ellas, no utilice un trait para esto pues me parecio simple de implementar en cada uno, adicionalmente la clase para mano tiene una función para descartar todas las cartas en ella. La función draw() no ha sufrido cambios, esta roba la carta en la parte superior del mazo, y ahora el método play sirve para jugar cualquier tipo de carta en el campo de batalla del jugador, para esto cada carta sabe como jugarse. Si es una carta de unidad, esta llama al método en la clase Battleground para jugarse correctamente y añadirse a la zona correspondiente. Si la carta jugada es una de clima, esta carta se comunica con la clase que representa el tablero, la cual posee una función para cambiar el clima según la carta entregada.

En la implementación de Carta, se cambio la superclase Card a un trait Card que contiene los métodos comunes entre las cartas de clima y cartas de unidad. Las cartas de climas y cartas de unidad ahora poseen un método played, que recibe el jugador que la juega y el tablero donde se desarrolla el juego, el parámetro player es utilizado por las cartas de unidad para poder añadirse a dicho jugador, y el parámetro board es utilizado por plas cartas de clima para cambiar el clima actual del tablero al que le corresponde la carta.

