import java.util.ArrayList;
import java.util.Random;

// A NumberTile is a square tile with a number from 1 to 9 on each side
public class NumberTile {
    private ArrayList<Integer> tile; // the 4-sided tile
    private static final Random gen = new Random();

    // Create a NumberTile object with 4 random ints in the range 1 to 9
    public NumberTile() {
        // TO DO: Code the body of this method
        tile = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            int n = gen.nextInt(9);
            tile.add(n + 1);
        }
    }

    // Rotate this NumberTile 90 degrees
    public void rotate() {
        // TO DO: Code the body of this method
        // This is no good
        // tile.add(0, tile.remove(3));
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(tile.get(1));
        tmp.add(tile.get(3));
        tmp.add(tile.get(0));
        tmp.add(tile.get(2));
        for (int i = 0; i < tile.size(); i++) {
            tile.set(i, tmp.get(i));
        }
    }

    // Return the number on the left side of this NumberTile
    public int getLeft() {
        // Do NOT modify this method
        return tile.get(1);
    }

    // Return the number on the right side of this NumberTile
    public int getRight() {
        // Do NOT modify this method
        return tile.get(2);
    }

    // Return this NumberTile as a multiline string in the form:
    // 9
    // 3 7
    // 6
    //
    public String toString() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        // return null ;
        return "\n\t\t" + tile.get(0) + "\n\t" + tile.get(1) + "\t\t" + tile.get(2) + "\n\t\t" + tile.get(3);
    }
} // end of NumberTile class
