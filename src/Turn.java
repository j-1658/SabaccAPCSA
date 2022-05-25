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
        if (!currentPlayer.isBot && currentPlayer.isPlaying) {
            //game.myScreen.setCurrentOptions(Screen.optionListPresets.DRAWING);
            System.out.println("Current Hand: " + currentPlayer.getHand());
            System.out.println("How much would you like to bet?\n Current Balance: " + currentPlayer.getPlayerBalance() + "c\n Minimum Bet: " + game.currentMinBet + "c");
            int theBet = kybd.nextInt();
            this.bet(theBet);
            System.out.println("Current Hand: " + currentPlayer.getHand());
            System.out.println("Would you like to:\n" +
                    "1. Check\n" + "2. Fold\n" + "3. Hit\n\nInput your number of choice.");
            int choice = kybd.nextInt();
            switch (choice) {
                case 1:
                    endTurn();
                    break;
                case 2:
                    this.fold();
                    break;
                case 3:
                    hit();
                    break;
            }
        }
        else if (currentPlayer.isBot){
            int betAmt = (int)(Math.random()*(currentPlayer.getPlayerBalance()/3));
            bet(betAmt);

            currentPlayer.botPlay();
        }
        else{
            System.out.println(currentPlayer.getName() + " has folded, skipping turn...");
        }
    }
    public void bet(int bet) { //no UI yet
        if(!currentPlayer.isBot) {
            Scanner input = new Scanner(System.in);
            if (game.getCurrentMinBet() > currentPlayer.getPlayerBalance()) {
                fold(); //make player fold if min bet is larger than their balance
                System.out.println("Due to a lack of sufficient balance, " + currentPlayer.getName() + " has been forced to fold.");
            } else if (bet < game.getCurrentMinBet() || bet > currentPlayer.getPlayerBalance()) {
                System.out.println("Please input a valid bet: \n Current Min Bet = " + game.getCurrentMinBet());
                bet(input.nextInt()); //make player bet amount they can afford
            } else {
                game.setCurrentMinBet(bet); //update min bet and remove the credits used to bet from the player
                currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance() - bet);
                game.setSabaccPot(game.getSabaccPot() + bet);
            }
        }
        else{
            if(bet < game.getCurrentMinBet()) {
                bet = game.getCurrentMinBet();
            }
            if (game.getCurrentMinBet() > currentPlayer.getPlayerBalance()) {
                fold(); //make player fold if min bet is larger than their balance
                System.out.println("Due to a lack of sufficient balance, " + currentPlayer.getName() + " has been forced to fold.");
            } else {
                game.setCurrentMinBet(bet); //update min bet and remove the credits used to bet from the player
                currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance() - bet);
                game.setSabaccPot(game.getSabaccPot() + bet);
                System.out.println(currentPlayer.getName() + " has bet " + bet);
            }
        }
    }

    public void fold() {
        currentPlayer.setIsPlaying(false);
        isCheckTurn = false;
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
