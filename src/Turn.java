import java.util.Scanner;
public class Turn {
    private Player currentPlayer;
    private Game game;
    private boolean isCheckTurn;
    private Scanner kybd = new Scanner(System.in);

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Turn(Player p, Game g) {
        currentPlayer = p;
        game = g;
    }

    public void run() {
        //game.myScreen.setCurrentOptions(Screen.optionListPresets.DRAWING);
        System.out.println("Would you like to:\n"+
                "1. Bet\n"+"2. Check\n"+"3. Fold\n"+"4. Hit\n\nInput your number of choice.");
        int choice = kybd.nextInt();
        switch(choice)  {
            case 1 :
                System.out.println("How much would you like to bet?");
                int theBet = kybd.nextInt();
                this.bet(theBet);
                break;
            case 2 :
                endTurn();
                break;
            case 3 :
                this.fold();
                break;
            case 4 :
                hit();
                break;
        }
        // Refresh/draw set of stuff for next player ***********************************************************
    }
    public void bet(int bet) { //no UI yet
        Scanner input = new Scanner(System.in);
        if (game.getCurrentMinBet() > currentPlayer.getPlayerBalance()) {
            fold(); //make player fold if min bet is larger than their balance
            System.out.println("Due to a lack of sufficient balance, you have been forced to fold.");
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
        isCheckTurn = true;
    }

    public void endTurn()
    { isCheckTurn = true; }

    public boolean getIsCheckTurn() {
        return isCheckTurn;
    }

    public void hit() {
        currentPlayer.getHand().add(game.deck.drawCard()); //index 0 is top card here, might change later
        if (currentPlayer.calcHand() > 23) {
            fold();
        }
    }
}
