## Piece Tour
A program to find out a tour path for a chess piece from a starting cell position. The contraints for moving the piece are:

a) The piece can move 3 spaces either North, East, South,
or West.

b) The piece can move 2 spaces diagonally: Northeast,
Southeast, Southwest, or Northwest.

c) Each space can only be visited once.

### Usage

The program takes the starting cell position of the piece, as the command line argument. The cell position is defined as `X` and `Y` coordinate. The program has a `Makefile`

### Test

```
make test
```

### Run

To run the program with starting cell as `3,4` run
```
make run X=3 Y=4
```