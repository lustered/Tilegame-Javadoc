import javax.swing.JOptionPane;

// A test class for the NumberTile Game
public class TileGameTester {
    public static void main(String[] args) {
        // TO DO: Code the body of this method

        Object[] options = { "NO", "YES" };
        int playAgain;
        do {
            Hand hand1 = new Hand();
            Hand hand2 = new Hand();
            TileGame game1 = new TileGame(hand1, hand2);
            System.out.println("\t::Hand 1::" + hand1.toString());
            System.out.println("\n\t::Hand 2::" + hand2.toString());
            game1.play();
            System.out.println(game1.getResults());

            playAgain = JOptionPane.showOptionDialog(null, "Play again?", "Tile Game", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        } while (playAgain != 0);

    }
}
