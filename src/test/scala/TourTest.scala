import org.junit.Test
import org.junit.Assert._
import model.Cell
import adt.{YCoordinate, XCoordinate}

class TourTest {
  @Test
  def testIfTourCoversAllCells = {
    val allCells =
      (for {
        x <- (0 to 9).map(XCoordinate.force)
        y <- (0 to 9).map(YCoordinate.force)
      } yield Cell(x, y)).toSet
    val startLoc =
      for {
        x <- XCoordinate(3)
        y <- YCoordinate(4)
      } yield Cell(x, y)
    startLoc match {
      case Right(loc) =>
        val tourPath = Chessboard.tour(loc)
        assertEquals(allCells, tourPath.toSet)
      case Left(_) =>
        assertFail("Should have been a valid cell")
    }
  }
}
