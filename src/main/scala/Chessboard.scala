import model.Cell
import adt.{XCoordinate, YCoordinate}

object Chessboard:
  private val allPositions = 
    (for{
        x <- (0 to 9).map(XCoordinate.force)
        y <- (0 to 9).map(YCoordinate.force)
    } yield 
        Cell(x, y)).toSet

  private def warndorffSort: (Cell, Cell) => Boolean = 
    (cell1, cell2) => Cell.nextPossibleCells(cell1).size < Cell.nextPossibleCells(cell2).size

  def tour(startCell: Cell): List[Cell] = 
    def internal(cell: Cell, visited: Set[Cell]): List[Cell] = 
        val v = visited + cell
        if(v == allPositions)
            List(cell)
        else
            val solution: Option[List[Cell]] = Cell
                .nextPossibleCells(cell)
                .filterNot(visited.contains)
                .sortWith(warndorffSort)
                .view
                .map(c => internal(c, v))
                .find(_.nonEmpty)
            solution.fold(ifEmpty = List.empty[Cell])(f = cell +: _)
    internal(startCell, visited = Set.empty[Cell])
