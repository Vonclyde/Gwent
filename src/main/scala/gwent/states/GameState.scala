package cl.uchile.dcc
package gwent.states

class GameState protected(val context: GameController){
  context.state = this
}
