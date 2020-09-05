
// Implements a domino-like game where two players, both of whom are
// the computer, take turns inserting NumberTiles into a Board
public class TileGame {
    // instance vars
    private Board board; // the game board
    private Hand hand1; // Player 1 hand
    private Hand hand2; // Player 2 hand
    private String winner; // the winner - player1, player2,
                           // or a tie game

    // Creates a new TileGame with two initial hands and a board
    public TileGame(Hand firstHand, Hand secondHand) {
        // TO DO: Code the body of this method
        hand1 = firstHand;
        hand2 = secondHand;
    }

    // Players take turn moving until one or both hand are empty
    public void play() {
        // TO DO: Code the body of this method
        boolean gameOver = false;

        while (!gameOver) {
            makeMove(hand1);
            makeMove(hand2);

            if ((hand1.isEmpty() ^ hand2.isEmpty())) {
                gameOver = true;
                if (hand1.isEmpty())
                    winner = "Player 1";
                if (hand2.isEmpty())
                    winner = "Player 2";
                if (hand1.isEmpty() && hand2.isEmpty())
                    winner = "It is a tie!";
            }
        }
    }

    // Utility method called by method makeMove. Returns the index at which a
    // new tile will be inserted into the board, or -1 if the tile cannot
    // be inserted. The new tile may be inserted either (1) between two
    // existing tiles, (2) as the new first tile, or (3) as the new last tile
    private int getIndexForFit(NumberTile tile) {
        // TO DO: Code the body of this method
        int fitTile = -1;
        System.out.println(board.getSize());

        // beginning of the game
        if (board.getSize() == 1 && board.getTile(0).getRight() == tile.getLeft())
            return 1;

        // For last tile
        int lastTile = board.getSize() - 1;
        if (board.getTile(lastTile).getRight() == tile.getRight())
            return board.getSize();

        if (tile.getLeft() == tile.getRight())
            for (int i = 2; i < board.getSize() - 1; i++) {

                int rightTile = board.getTile(i).getRight();

                // Doesn't matter either tile checked since they have
                // to be the same to pass the check
                if (tile.getRight() == rightTile)
                    return i + 1;
            }

        return fitTile;
    }

    // Utility method called by method play(). Checks consecutive tiles in the
    // hand - by calling method getIndexForFit() - to see if one can be inserted
    // into the board. When the first tile that fits is found, removes it from
    // the hand, inserts it into the board, and the move ends. The tile may be
    // rotated up to 3 times. If none of the tiles fit, adds a new, random tile
    // to the hand
    private void makeMove(Hand hand) {
        // TO DO: Code the body of this method
    }

    // Return results of the game as a humongous multi-line String containing
    // the final board, both both player's final hands, and the winner
    public String getResults() {
        // TO DO: Code the body of this method
        // HINT: call toString for the board and for each hand and don't
        // forget the winner

        // temporary return statement so program skeleton will compile and run
        return "Results";
    }
} // end of TileGame2 class
