// Implements a domino-like game where two players, both of whom are
// the computer, take turns inserting NumberTiles into a Board
public class TileGameDebug {
    // instance vars
    private Board board; // the game board
    private Hand hand1; // Player 1 hand
    private Hand hand2; // Player 2 hand
    private String winner; // the winner - player1, player2,
                           // or a tie game

    // Creates a new TileGame with two initial hands and a board
    public TileGameDebug(Hand firstHand, Hand secondHand) {
        // TO DO: Code the body of this method
        board = new Board();
        hand1 = firstHand;
        hand2 = secondHand;
    }

    // Players take turn moving until one or both hand are empty
    public void play() {
        // TO DO: Code the body of this method
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Player 1 Play");
            makeMove(hand1);
            System.out.println("Player 2 Play");
            makeMove(hand2);
            // System.out.println(hand1.getSize());
            // System.out.println(hand2.getSize());

            if (hand1.isEmpty() || hand2.isEmpty()) {
                gameOver = true;
                if (hand1.isEmpty() && hand2.isEmpty())
                    winner = "\t[::It is a tie!::]";
                else if (hand1.isEmpty())
                    winner = "\t[::Player 1 Wins!::]";
                else if (hand2.isEmpty())
                    winner = "\t[::Player 2 Wins!::]";
            }
        }
    }

    // Utility method called by method makeMove. Returns the index at which a
    // new tile will be inserted into the board, or -1 if the tile cannot
    // be inserted. The new tile may be inserted either (1) between two
    // existing tiles, (2) as the new first tile, or (3) as the new last tile
    private int getIndexForFit(NumberTile tile) {
        // TO DO: Code the body of this method

        // Check for the new first tile
        if (board.getTile(0).getLeft() == tile.getRight())
            return 0;

        // Check for last tile
        int lastTile = board.getSize() - 1;
        if (board.getTile(lastTile).getRight() == tile.getLeft())
            return board.getSize();

        // The only way to place a tile between other 2 is if the tile has
        // the same value for the center
        if (tile.getLeft() == tile.getRight())
            for (int i = 1; i < board.getSize() - 1; i++) {

                int rightTile = board.getTile(i).getRight();
                // Doesn't matter which tile is checked
                if (tile.getRight() == rightTile)
                    return i + 1;
            }

        return -1;
    }

    // Utility method called by method play(). Checks consecutive tiles in the
    // hand - by calling method getIndexForFit() - to see if one can be inserted
    // into the board. When the first tile that fits is found, removes it from
    // the hand, inserts it into the board, and the move ends. The tile may be
    // rotated up to 3 times. If none of the tiles fit, adds a new, random tile
    // to the hand
    private void makeMove(Hand hand) {
        // TO DO: Code the body of this method

        boolean matchFound = false;
        // grab each tile in the hand
        outer: for (int i = 0; i < hand.getSize(); i++) {
            // Extract each tile
            System.out.println("tile grabbed");
            NumberTile tile = hand.get(i);
            // check tile for match
            for (int j = 0; j < 3; j++) {
                // Use helper method to check if the tile fits with
                // Its current position
                int checkFitIndex = getIndexForFit(tile);
                if (checkFitIndex == -1) {
                    tile.rotate();
                    System.out.println("tile rotated");
                } else if (checkFitIndex != -1) {
                    System.out.println("IT IS A MATCH");
                    board.addTile(checkFitIndex, tile);
                    hand.removeTile(i);
                    matchFound = true;
                    // No need to keep iterating
                    break outer;
                }

            }

        }
        // If after iterating over the entire hand no match was found
        // Then add a tile to the hand
        if (!matchFound) {
            hand.addTile();

        }
    }

    /**
     * Returns a String with the ending state for the Board , Hand objects.
     */
    public String getResults() {
        // TO DO: Code the body of this method
        // HINT: call toString for the board and for each hand and don't
        // forget the winner
        // asdad

        // temporary return statement so program skeleton will compile and run
        String divider = new String(new char[80]).replace("\0", "*");
        return String.format("\n\t::Results::\n" + divider + board.toString() + "\n\t::Final Hands::\n" + divider
                + "\n\n\t::Player 1 Final Hand::\n" + hand1.toString() + "\n\n\t::Player 2 Final Hand::\n"
                + hand2.toString() + "\n" + winner);

    }
} // end of TileGame2 class
