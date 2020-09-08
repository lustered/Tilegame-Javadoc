import java.util.ArrayList;

// A player's hand of NumberTiles
public class Hand {
    private ArrayList<NumberTile> hand;
    private final static int INITIAL_SIZE = 5; // starting hand size

    /**
     * Creates a new hand of INITIAL_SIZE NumberTiles
     */
    public Hand() {
        hand = new ArrayList<NumberTile>();
        for (int i = 0; i < INITIAL_SIZE; i++) {
            hand.add(new NumberTile());
        }
    }

    /**
     * Get the NumberTile at the specified index in this Hand
     * 
     * @param index index of the NumberTile
     * @return NumberTile at the specified index
     */
    public NumberTile get(int index) {
        return hand.get(index);
    }

    /**
     * Get the number of tiles in this Hand
     * 
     * @return return the size of the hand
     */
    public int getSize() {
        return hand.size();

    }

    /**
     * Add a new random NumberTile to this Hand
     */
    public void addTile() {
        NumberTile tile = new NumberTile();
        hand.add(tile);
    }

    /**
     * Remove the NumberTile at the specified index from this Hand
     * 
     * @param index Index of the NumberTile element to remove from Hand
     */
    public void removeTile(int index) {
        hand.remove(index);
    }

    /**
     * Check if Hand is empty
     * 
     * @return boolean true if Hand is empty, else false
     */
    public boolean isEmpty() {
        return hand.isEmpty();
    }

    /**
     * @return Return this hand as a multiline String if it has elements, otherwise
     *         return a messaging saying so
     */
    public String toString() {
        String handPrint = "";

        if (hand.isEmpty())
            return "\n\t[::Hand is Empty::]\n";
        else
            // iterate over every tile and append it to the return
            for (NumberTile tile : hand)
                handPrint += "\n" + tile;
        return handPrint;
    }
}
