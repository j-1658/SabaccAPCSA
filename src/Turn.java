import java.util.Scanner;

public class Turn {
    int playerBet;
    Player currentPlayer;
    Scanner playerInput = new Scanner(System.in);

    public Turn(int b, Player p) {
        playerBet = b;
        currentPlayer = p;
    }

    public void updateFrame() { //idk what this will do but it was on design sheet

    }


    public void bet(Game g) { //no UI yet
        if (g.getCurrentMinBet() >= currentPlayer.getPlayerBalance()) {
            System.out.println("Insufficient funds");//temp
            fold(); //make player fold if min bet is larger than their balance
        } else if (playerBet < g.getCurrentMinBet() || playerBet > currentPlayer.getPlayerBalance()) {
            System.out.println("Bet amount to low");//temp
            bet(g); //make player bet amount they can afford
        } else {
            g.setCurrentMinBet(playerBet); //update min bet and remove the credits used to bet from the player
            currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance() - playerBet);
            g.setSabaccPot(g.getSabaccPot() + playerBet);
        }
    }

    public void run(){
        System.out.println(currentPlayer.getPlayerName() + "'s turn");
        System.out.println("Select Action");
        System.out.println("1.BET\n2.FOLD\n3.CHECK\n4.DISCARD\n5.DRAW\n6.QUIT");
        int choice = playerInput.nextInt();
        switch(choice){
            case 1 :
                //ui stuff
                break;
        }
    }

    public void fold() { //how

    }
}
