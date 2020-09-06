package adt

enum Movement(description: String):
    case North extends Movement("North")
    case South extends Movement("South")
    case East extends Movement("East")
    case West extends Movement("West")
    case NorthEast extends Movement("North East")
    case NorthWest extends Movement("North West")
    case SouthEast extends Movement("South East")
    case SouthWest extends Movement("South West")