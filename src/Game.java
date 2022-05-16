import java.util.ArrayList;

public class Game {
    int sabaccPot;
    Player[] playerList;
    Deck deck;
    Round currentRound;
    int currentMinBet;

    public void setup(){

    }
    public void sabaccShift(){
        double shiftChance = 0.25;
        boolean isShifted = (Math.random() < shiftChance);
        if(isShifted){
            for (int p = 0; p < playerList.length; p++){
                for(int c = 0; c < playerList[p].hand.size(); c++){
                    if(!playerList[p].hand[c].inField){
                        String suit = "";
                        switch((int)Math.random()*5){
                            case 0 :
                                suit = "Staves";
                                break;
                            case 1:
                                suit = "Coins";
                                break;
                            case 2 :
                                suit = "Flasks";
                                break;
                            case 3 :
                                suit = "Sabers";
                                break;
                            case 4:
                                suit = "Special";
                                break;
                        }
                        int value = 0;
                        if(!suit.equals("Special")) {
                            value = (int) (Math.random() * 16) + 1;
                        } else{
                            int[] specialList = {-11, 0, -8, -14,-15,-2,-13,-17};
                            int index = (int)Math.random()*7;
                            value = specialList[index];
                        }
                        playerList[p].hand[c].setValue(value);
                        playerList[p].hand[c].setSuit(suit);
                    }
                }
            }
        }
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
