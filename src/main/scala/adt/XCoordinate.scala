package adt

import Error._

opaque type XCoordinate = Int

object XCoordinate:
    private[adt] val error = InvalidXCoordinate("Value should be less than 10 and greater or equal to 0")
    def apply(x: Int): Either[Error, XCoordinate] = 
        if(x >= 0 && x < 10)
            Right(x)
        else
            Left(InvalidXCoordinate("Value should be less than 10 and greater or equal to 0"))

    def isValid(y: Int): Boolean = y >= 0 && y < 10

    def force(x: Int): XCoordinate = 
        if(isValid(x))
            x
        else
            throw new IllegalArgumentException("Value should be less in the range 0 to 10")

extension XCoordinateOps on (x: XCoordinate):
    def +(o: Int): Either[Error, XCoordinate] = 
        if(XCoordinate.isValid(o + x))
            Right(o + x)
        else
            Left(XCoordinate.error)
    def -(o: Int): Either[Error, XCoordinate] = 
        if(YCoordinate.isValid(x - o))
            Right(x - o)
        else
            Left(XCoordinate.error)