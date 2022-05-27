import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int sabaccPot;
    Player[] playerList;
    Deck deck;

    Screen myScreen;
    private Round currentRound;
    int currentMinBet;
    boolean continuedGame;

    final Scanner scan = new Scanner(System.in);

    public Game(int pot) {
        sabaccPot = pot;
        currentMinBet = 10;
        deck = new Deck();
        continuedGame = false;
    }
    public void setup(){

           playerListCreation();
           continuedGame = true;
        //myScreen = new Screen(this);
        while(continuedGame) {
            continuedGame = false;
            nextRound();
        }
    }
    public Player startRound(){ //returns the winner
        currentRound = new Round(this);
        return currentRound.run();
    }
    public Round getCurrentRound(){
        return currentRound;
    }
    public Turn getCurrentTurn(){
        return this.getCurrentRound().getTurn();
    }

   // public void updateFrame(){

    //} //For Chris to do key listeners and Jj to do animation
    public void nextRound(){
        //itterate through players
        for(int k = 0; k < playerList.length; k++){
            for(int i = 0; playerList[k].getHand().size() > 0; i++){
                deck.returnToDeck(playerList[k].getHand().remove(0));
            }
        }
        deck.shuffle();
        for(Player p: playerList){
            p.getHand().add(this.deck.drawCard());
            p.getHand().add(this.deck.drawCard());
        }
        Player win = this.startRound();
        if(win.getPlayerNum() == -1){
            System.out.println("Nobody won, Want to play again?");
            //Pot stays
        } else {
            System.out.println(win.getName() + " won with a hand of " + win.getHand() + "Want to play again?");
            playerList[win.getPlayerNum()].setPlayerBalance(playerList[win.getPlayerNum()].getPlayerBalance()+sabaccPot);
            sabaccPot = 20;
            currentMinBet = 10;
            System.out.println("1. Play Again\n2. Quit");
            if(scan.nextInt()==1){
                continuedGame = true;
            }
            else{
                System.out.println("Thanks for playing!");
            }

        }
        //myScreen.setCurrentOptions(Screen.optionListPresets.BETWEENROUND);

    }

    public void playerListCreation(){
        System.out.println("How many players do you want to have (1 - 6)");
        int x = Integer.parseInt(scan.nextLine());
        int singlePlayer = x==1? 1:0;
        playerList = new Player[x+singlePlayer];


        if(singlePlayer==1) {
            playerList[0] = new Player(200, 0, "bot lmao", true, this);
        }
        String tempName = "";
        for(int i = singlePlayer; i < x+singlePlayer; i++){
            System.out.println("What is your player name, Player " + (i+1-singlePlayer) +"?");
            tempName = scan.next();
            playerList[i] = new Player(200, i, tempName, false, this);
        }
    }



    public Player[] getPlayerList(){
        return this.playerList;
    }
    public ArrayList<Card> getDeck(){
        return this.deck.getDeckList();
    }

    public int getCurrentMinBet() { return this.currentMinBet; }

    public void setCurrentMinBet(int b) { currentMinBet = b; }

    public void setSabaccPot(int p) { sabaccPot = p; }

    public int getSabaccPot() { return this.sabaccPot; }
    public void runGame(){
        setup();
    }
}
