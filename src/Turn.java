public class Turn {
    int playerBet;
    Player currentPlayer;

    public Turn(int b, Player p) {
        playerBet = b;
        currentPlayer = p;
    }

    public void updateFrame() { //idk what this will do but it was on design sheet

    }

    public void bet(Game g) { //no UI yet
        if (g.getCurrentMinBet() >= currentPlayer.getPlayerBalance()) {
            fold(); //make player fold if min bet is larger than their balance
        } else if (playerBet < g.getCurrentMinBet() || playerBet > currentPlayer.getPlayerBalance()) {
            bet(g); //make player bet amount they can afford
        } else {
            g.setCurrentMinBet(playerBet); //update min bet and remove the credits used to bet from the player
            currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance() - playerBet);
            g.setSabaccPot(g.getSabaccPot() + playerBet);
        }
    }

    public void fold() { //how

    }
}
