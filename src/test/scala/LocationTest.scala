import org.junit.Test
import org.junit.Assert._
import model.Location
import adt.{YCoordinate, XCoordinate}

class LocationTest {
  @Test
  def nextPossibleLocationsTest = {
    val startX = XCoordinate(2)
    val startY = YCoordinate(6)
    val startLocation = for {
      x <- startX
      y <- startY
    } yield (Location(x, y))

    startLocation match {
      case Right(location) =>
        val actual =
          Location.nextPossibleLocations(location).toSet
        val east = location.copy(x = XCoordinate.force(5))
        val north = location.copy(y = YCoordinate.force(9))
        val south = location.copy(y = YCoordinate.force(3))
        val northEast = Location(XCoordinate.force(4), YCoordinate.force(8))
        val southEast = Location(XCoordinate.force(4), YCoordinate.force(4))
        val northWest = Location(XCoordinate.force(0), YCoordinate.force(8))
        val southWest = Location(XCoordinate.force(0), YCoordinate.force(4))
        val expected =
          Set(east, north, south, northEast, southEast, northWest, southWest)

        assertEquals(expected, actual)
      case Left(_) => assertFail("Should have been a valid location")
    }
  }
}
