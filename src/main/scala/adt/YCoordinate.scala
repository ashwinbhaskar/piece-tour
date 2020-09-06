package adt

import Error._

opaque type YCoordinate = Int

object YCoordinate:
    def apply(y: Int): Either[Error, YCoordinate] = 
        if(y >= 0 && y < 10)
            Right(y)
        else
            Left(InvalidXCoordinate("Value should be less than 10 and greater or equal to 0"))
