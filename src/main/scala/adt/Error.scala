package adt

enum Error(description: String):
    case InvalidXCoordinate(msg: String) extends Error(msg)
