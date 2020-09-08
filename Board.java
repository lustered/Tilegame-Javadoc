import java.util.ArrayList;

// The board for the NumberTile game  
public class Board {
    private ArrayList<NumberTile> board; // the board for a NumberTile game

    /**
     * Creates a new Board containing a single random NumberTile
     */
    public Board() {
        // TO DO: Code the body of this method
        board = new ArrayList<NumberTile>();
        board.add(new NumberTile());
    }

    /**
     * @param index Index to check in Board
     * @return NumberTile at the index
     */
    public NumberTile getTile(int index) {
        return board.get(index);
    }

    /**
     * Return the current number of tiles on this Board
     * 
     * @return size of Board
     */
    public int getSize() {
        return board.size();
    }

    /**
     * Insert a new tile into this Board at the specified index
     * 
     * @param index index at which NumberTile will be inserted
     * @param tile  NumberTile to be inseted into the board
     */
    public void addTile(int index, NumberTile tile) {
        // TO DO: Code the body of this method
        board.add(index, tile);
    }

    /**
     * @return Return a multiline string containing all the tiles on this Board
     */
    public String toString() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        String tiles = " ";
        for (NumberTile t : board)
            tiles += "\n" + t;
        return tiles;

    }
}
