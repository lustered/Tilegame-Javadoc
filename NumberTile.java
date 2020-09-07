import java.util.ArrayList;
import java.util.Random;

// A NumberTile is a square tile with a number from 1 to 9 on each side
public class NumberTile {
    private ArrayList<Integer> tile; // the 4-sided tile
    private static final Random gen = new Random();

    /**
     * Create a NumberTile object with 4 random ints in the range 1 to 9
     */
    public NumberTile() {
        tile = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            int n = gen.nextInt(9);
            tile.add(n + 1);
        }
    }

    /**
     * Rotate this NumberTile 90 degrees
     */
    public void rotate() {
        tile.add(0, tile.remove(3));
    }

    /**
     * Return the number on the left side of this NumberTile
     * 
     * @return left element in the NumberTile
     */
    public int getLeft() {
        // Do NOT modify this method
        return tile.get(0);
    }

    /**
     * Return the number on the right side of this NumberTile
     * 
     * @return right element in NumberTile
     */
    public int getRight() {
        // Do NOT modify this method
        return tile.get(2);
    }

    /**
     * Return this NumberTile as a multiline string in the form:
     */
    public String toString() {
        return "\n\t\t" + tile.get(1) + "\n\t" + tile.get(0) + "\t\t" + tile.get(2) + "\n\t\t" + tile.get(3);
    }
}
