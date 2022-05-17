import java.util.ArrayList;

public class Game {
    int sabaccPot;
    Player[] playerList;
    Deck deck;
    Round currentRound;
    int currentMinBet;

    public Game(int pot, Player[] pList, Deck d, Round cR) {
        sabaccPot = pot;
        playerList = pList;
        deck = d;
        currentRound = cR;
        currentMinBet = 10;
    }
    public void setup(){

    }
    public void startRound(){
        Round thisRound = new Round(playerList);
        thisRound.run(this);
    }

    public void updateFrame(){

    } //For Chris to do key listeners and Jj to do animation
    public void nextRound(){

    }
    public Player[] getPlayerList(){
        return this.playerList;
    }
    public ArrayList<Card> getDeck(){
        return this.deck.deckList;
    }

    public int getCurrentMinBet() { return this.currentMinBet; }

    public void setCurrentMinBet(int b) { currentMinBet = b; }

    public void setSabaccPot(int p) { sabaccPot = p; }

    public int getSabaccPot() { return this.sabaccPot; }
    public void runGame(){

    }
}
