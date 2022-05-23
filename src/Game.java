import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int sabaccPot;
    Player[] playerList;
    Deck deck;

    Screen myScreen;
    private Round currentRound;
    int currentMinBet;

    final Scanner scan = new Scanner(System.in);


    public Game(int pot) {
        sabaccPot = pot;
        currentMinBet = 10;
        deck = new Deck();
    }
    public void setup(){
        playerListCreation();
        myScreen = new Screen(this);
        nextRound();
    }
    public Player startRound(){ //returns the winner
        Round thisRound = new Round(playerList);
        return thisRound.run();
    }
    public Round getCurrentRound(){
        return currentRound;
    }
    public Turn getCurrentTurn(){
        return this.getCurrentRound().getTurn();
    }
    
    public void updateFrame(){

    } //For Chris to do key listeners and Jj to do animation
    public void nextRound(){
        for(int k = 0; k < playerList.length; k++){
            for(int i = 0; i < playerList[k].getHand().size(); i++){
                deck.returnToDeck(playerList[k].getHand().remove(i));
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
            System.out.println("Player " + win.getPlayerNum() + " won! Want to play again?");
            playerList[win.getPlayerNum()].setPlayerBalance(playerList[win.getPlayerNum()].getPlayerBalance()+sabaccPot);
            sabaccPot = 200;

        }
        myScreen.setCurrentOptions(Screen.optionListPresets.BETWEENROUND);

    }

    public void playerListCreation(){
        System.out.println("How many players do you want to have (1 - 6)");
        int x = scan.nextInt();

        playerList = new Player[x+1];
        playerList[0] = new Player(200, 0, "bot lmao", true, this);
        for(int i = 1; i < x+1; i++){
            System.out.println("What is your player Name, player number" + i);
            playerList[i] = new Player(200, i, scan.nextLine(), false, this);
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
