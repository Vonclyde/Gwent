package cl.uchile.dcc
package gwent.states
import scala.util.Random

class StartingGameState(context: GameController) extends GameState(context) {
  override def toActivePlayerState(): Unit = {
    context.state = new ActivePlayerState(context)
  }

  override def decideOrder(): Unit = {
    val rand = Random.between(0,2)
    if (rand == 0){
      context.playerTurn()
    }
    else {
      context.cpuTurn()
    }
  }
}
