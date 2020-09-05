import java.util.ArrayList;

// A player's hand of NumberTiles
public class Hand {
    private ArrayList<NumberTile> hand;
    private final static int INITIAL_SIZE = 5; // starting hand size

    // Creates a new hand of INITIAL_SIZE NumberTiles
    public Hand() {
        // TO DO: Code the body of this method
        for (int i = 0; i < INITIAL_SIZE; i++) {
            NumberTile tile = new NumberTile();
            hand.add(tile);
        }
    }

    // Get the NumberTile at the specified index in this Hand
    public NumberTile get(int index) {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        // return null;
        return hand.get(index);
    }

    // Get the number of tiles in this Hand
    public int getSize() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        // return -999;
        return hand.size();

    }

    // Add a new NumberTile to this Hand
    public void addTile() {
        // TO DO: Code the body of this method
        NumberTile tile = new NumberTile();
        hand.add(tile);
    }

    // Remove the NumberTile at the specified index from this Hand
    public void removeTile(int index) {
        // TO DO: Code the body of this method
        hand.remove(index);
    }

    // Is this hand empty?
    public boolean isEmpty() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        // return false ;
        return hand.isEmpty();
    }

    // Return this Hand as a multiline String.
    // If this Hand is empty, return an appropriate message
    public String toString() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        // return "The hand";
        String h = "";
        if (hand.isEmpty())
            return "Hand is Empty";
        else
            for (NumberTile tile : hand)
                h += tile;
        return h;

    }
}
