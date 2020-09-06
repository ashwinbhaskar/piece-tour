package adt

enum Error(description: String):
    case InvalidXCoordinate(msg: String) extends Error(msg)
    case InvalidYCoordinate(msg: String) extends Error(msg)
