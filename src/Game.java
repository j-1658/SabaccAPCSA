import java.util.ArrayList;

public class Game {
    int sabaccPot;
    Player[] playerList;
    Deck deck;

    Screen myScreen;
    private Round currentRound;
    int currentMinBet;


    public Game(int pot, Player[] pList, Deck d, Round cR) {
        sabaccPot = pot;
        playerList = pList;
        deck = d;
        currentRound = cR;
        currentMinBet = 10;
        setup();
    }
    public void setup(){

        deck.shuffle();
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
        Player win = this.startRound();
        if(win.getPlayerNum() == -1){
            System.out.println("Nobody won, Want to play again?");
            //Pot stays
        } else {
            System.out.println("Player " + win.getPlayerNum() + " won! Want to play again?");
            playerList[win.getPlayerNum()].setPlayerBalance(playerList[win.getPlayerNum()].getPlayerBalance()+sabaccPot);

        }
        myScreen.setCurrentOptions(Screen.optionListPresets.BETWEENROUND);
        
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

    }
}
