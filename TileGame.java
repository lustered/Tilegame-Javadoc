// Implements a domino-like game where two players, both of whom are
// the computer, take turns inserting NumberTiles into a Board
public class TileGame {
    // instance vars
    private Board board; // the game board
    private Hand hand1; // Player 1 hand
    private Hand hand2; // Player 2 hand
    private String winner; // the winner - player1, player2,
                           // or a tie game

    /**
     * Create TileGame object
     * 
     * @param firstHand  first unique Hand object
     * @param secondHand second unique Hand object
     */
    public TileGame(Hand firstHand, Hand secondHand) {

        board = new Board();
        hand1 = firstHand;
        hand2 = secondHand;
    }

    public void play() {

        boolean gameOver = false;

        while (!gameOver) {
            makeMove(hand1);
            makeMove(hand2);

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

    private int getIndexForFit(NumberTile tile) {
        // Check for the new first tile
        if (board.getTile(0).getLeft() == tile.getRight())
            return 0;

        // Check for last tile
        int lastTileIndex = board.getSize() - 1;
        if (board.getTile(lastTileIndex).getRight() == tile.getLeft())
            return board.getSize();

        // The only way to place a tile between other 2 is if the tile has
        // the same value for the center elements
        if (tile.getLeft() == tile.getRight())
            for (int i = 1; i < board.getSize() - 1; i++) {

                // right element of the tile on the board
                int rightTileElement = board.getTile(i).getRight();
                if (tile.getRight() == rightTileElement)
                    // i+1 is in front of the tile checked
                    return i + 1;
            }

        return -1;
    }

    private void makeMove(Hand hand) {
        boolean matchFound = false;

        // grab each tile in the hand
        outer: for (int i = 0; i < hand.getSize(); i++) {

            // Extract each tile
            NumberTile tile = hand.get(i);
            // check tile for match up to 3 rotations
            for (int j = 0; j < 3; j++) {

                // Use helper method to check if the tile fits with
                // Its current position
                int checkFitIndex = getIndexForFit(tile);

                // getIndexForFit() returns -1 if no match found
                if (checkFitIndex == -1) {
                    tile.rotate();
                } else if (checkFitIndex != -1) {
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
     * Returns a String with the ending state for the Board , Hand objects and
     * winner.
     * 
     * @return String
     */
    public String getResults() {
        String divider = new String(new char[80]).replace("\0", "*");
        return String.format("\n\t::Results::\n" + divider + board.toString() + "\n\t::Final Hands::\n" + divider
                + "\n\n\t::Player 1 Final Hand::\n" + hand1.toString() + "\n\n\t::Player 2 Final Hand::\n"
                + hand2.toString() + "\n" + winner);
    }
}
