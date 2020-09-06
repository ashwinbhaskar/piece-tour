package model

import adt.{XCoordinate, YCoordinate, Movement}
import adt.Movement._
import adt.YCoordinateOps
import adt.XCoordinateOps

final case class Location(x: XCoordinate, y: YCoordinate)

object Location:

    def addY(location: Location, o: Int): Option[Location] = 
        (location.y + o).toOption.map(yCoordinate => location.copy(y = yCoordinate))

    def addX(location: Location, o: Int): Option[Location] = 
        (location.x + o).toOption.map(xCoordinate => location.copy(x = xCoordinate))

    def nextPossibleLocations(location: Location): List[Location] = 
        Movement.values.foldLeft(List[Location]()) { (acc, movement) => 
            val newLocation: Option[Location] = 
                movement match {
                    case North => addY(location, 3)
                    case South => addY(location, -3)
                    case East =>  addX(location, 3)
                    case West => addX(location, -3)
                    case NorthEast => addY(location, 2).flatMap(newLoc => addX(newLoc, 2))
                    case NorthWest => addY(location, 2).flatMap(newLoc => addX(newLoc, -2))
                    case SouthEast => addX(location, 2).flatMap(newLoc => addY(newLoc, -2))
                    case SouthWest => addX(location, -2).flatMap(newLoc => addY(newLoc, -2))
                }
            newLocation.fold(ifEmpty = acc)(_ +: acc)
        }