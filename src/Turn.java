import java.util.Scanner;
public class Turn {
    private Player currentPlayer;
    private Game game;

    public Turn(Player p, Game g) {
        currentPlayer = p;
        game = g;
    }

    public void bet(int bet) { //no UI yet
        Scanner input = new Scanner(System.in);
        if (game.getCurrentMinBet() >= currentPlayer.getPlayerBalance()) {
            fold(); //make player fold if min bet is larger than their balance
        } else if (bet < game.getCurrentMinBet() || bet > currentPlayer.getPlayerBalance()) {
            System.out.println("Please input a valid bet");
            bet(input.nextInt()); //make player bet amount they can afford
        } else {
            game.setCurrentMinBet(bet); //update min bet and remove the credits used to bet from the player
            currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance() - bet);
            game.setSabaccPot(game.getSabaccPot() + bet);
        }
    }

    public void fold() {
        currentPlayer.setIsPlaying(false);
        game.getCurrentRound().nextTurn();
    }

    public void endTurn() {
        game.getCurrentRound().nextTurn();
    }

    public void hit() {
        //do later
    }
}
