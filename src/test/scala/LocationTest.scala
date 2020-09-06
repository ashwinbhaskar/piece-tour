import org.junit.Test
import org.junit.Assert._
import model.Cell
import adt.{YCoordinate, XCoordinate}

class CellTest {
  @Test
  def nextPossibleCellsTest = {
    val startX = XCoordinate(2)
    val startY = YCoordinate(6)
    val startCell = for {
      x <- startX
      y <- startY
    } yield (Cell(x, y))

    startCell match {
      case Right(cell) =>
        val actual =
          Cell.nextPossibleCells(cell).toSet
        val east = cell.copy(x = XCoordinate.force(5))
        val north = cell.copy(y = YCoordinate.force(9))
        val south = cell.copy(y = YCoordinate.force(3))
        val northEast = Cell(XCoordinate.force(4), YCoordinate.force(8))
        val southEast = Cell(XCoordinate.force(4), YCoordinate.force(4))
        val northWest = Cell(XCoordinate.force(0), YCoordinate.force(8))
        val southWest = Cell(XCoordinate.force(0), YCoordinate.force(4))
        val expected =
          Set(east, north, south, northEast, southEast, northWest, southWest)

        assertEquals(expected, actual)
      case Left(_) => assertFail("Should have been a valid Cell")
    }
  }
}
