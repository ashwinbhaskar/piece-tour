import adt.{XCoordinate, YCoordinate}
import model.Cell

@main def launcher(startX: Int, startY: Int): Unit = 
  val startCell = 
    for {
      x <- XCoordinate(startX)
      y <- YCoordinate(startY)
    } yield Cell(x, y)
  
  assert(startCell.isRight)

  val path = startCell match {
    case Right(loc) => Chessboard.tour(loc)
    case Left(_) => assertFail("Invalid start Cell given. Should be 0 <= startLoc < 10")
  }

  println("Tour path:")
  path foreach println
