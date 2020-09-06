import javax.swing.JOptionPane;

// A test class for the NumberTile Game
public class TileGameTester {
    public static void main(String[] args) {
        // TO DO: Code the body of this method

        // Options for JOptionPane
        Object[] options = { "No", "Yes" };
        int playAgain;
        int timesPlayed = 1;
        do {
            System.out.println("\n\n::Game #: " + timesPlayed + "::\n");
            Hand hand1 = new Hand();
            Hand hand2 = new Hand();
            TileGame game1 = new TileGame(hand1, hand2);
            System.out.println("\t::Hand 1::" + hand1.toString());
            System.out.println("\n\t::Hand 2::" + hand2.toString());
            game1.play();
            System.out.println(game1.getResults());

            // Ask user if they want to play the game again
            playAgain = JOptionPane.showOptionDialog(null, "Play again?", "Tile Game", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);

            timesPlayed++;
        } while (playAgain != 0);

    }
}
