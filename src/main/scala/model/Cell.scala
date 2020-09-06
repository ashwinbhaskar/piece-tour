package model

import adt.{XCoordinate, YCoordinate, Movement}
import adt.Movement._
import adt.YCoordinateOps
import adt.XCoordinateOps

final case class Cell(x: XCoordinate, y: YCoordinate)

object Cell:
    def addY(Cell: Cell, o: Int): Option[Cell] = 
        (Cell.y + o).toOption.map(yCoordinate => Cell.copy(y = yCoordinate))

    def addX(Cell: Cell, o: Int): Option[Cell] = 
        (Cell.x + o).toOption.map(xCoordinate => Cell.copy(x = xCoordinate))

    def nextPossibleCells(Cell: Cell): List[Cell] = 
        Movement.values.foldLeft(List[Cell]()) { (acc, movement) => 
            val newCell: Option[Cell] = 
                movement match {
                    case North => addY(Cell, 3)
                    case South => addY(Cell, -3)
                    case East =>  addX(Cell, 3)
                    case West => addX(Cell, -3)
                    case NorthEast => addY(Cell, 2).flatMap(newLoc => addX(newLoc, 2))
                    case NorthWest => addY(Cell, 2).flatMap(newLoc => addX(newLoc, -2))
                    case SouthEast => addX(Cell, 2).flatMap(newLoc => addY(newLoc, -2))
                    case SouthWest => addX(Cell, -2).flatMap(newLoc => addY(newLoc, -2))
                }
            newCell.fold(ifEmpty = acc)(_ +: acc)
        }