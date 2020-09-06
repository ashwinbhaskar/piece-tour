package adt

import Error._

opaque type YCoordinate = Int

object YCoordinate:
    private[adt] val error = InvalidYCoordinate("Value should be less than 10 and greater or equal to 0")
    def apply(y: Int): Either[Error, YCoordinate] = 
        if(isValid(y))
            Right(y)
        else
            Left(error)
    
    def isValid(y: Int): Boolean = y >= 0 && y < 10

    def force(y: Int): YCoordinate = 
        if(isValid(y))
            y
        else
            throw new IllegalArgumentException("Value should be in the range of 0 and 10")

extension YCoordinateOps on (y: YCoordinate):
    def +(o: Int): Either[Error, YCoordinate] = 
        if(YCoordinate.isValid(o + y))
            Right(o + y)
        else
            Left(YCoordinate.error)
    def -(o: Int): Either[Error, YCoordinate] = 
        if(YCoordinate.isValid(y - o))
            Right(y - 0)
        else
            Left(YCoordinate.error)
