package adt

import Error._

opaque type XCoordinate = Int

object XCoordinate:
    def apply(x: Int): Either[Error, XCoordinate] = 
        if(x >= 0 && x < 10)
            Right(x)
        else
            Left(InvalidXCoordinate("Value should be less than 10 and greater or equal to 0"))
