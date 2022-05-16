import java.util.ArrayList;

public class Game {
    int sabaccPot;
    Player[] playerList;
    Deck deck;
    Round currentRound;
    int currentMinBet;

    public void setup(){

    }
    public void startRound(){
        Round thisRound = new Round();
    }
    public void updateFrame(){

    }
    public void nextRound(){

    }
    public Player[] getPlayerList(){
        return this.playerList;
    }
    public ArrayList<Card> getDeck(){
        return this.deck.deckList;
    }
    public void runGame(){

    }
}
