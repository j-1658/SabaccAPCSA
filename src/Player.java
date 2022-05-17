import java.util.ArrayList;

public class Player {
    int playerBalance;
    int playerNum;
    String name;
    ArrayList<Card> hand;
    boolean isPlaying;

    public Player(int pB, int pN, String n) {
    playerBalance = pB;
    playerNum = pN;
    name = n;
    isPlaying = true;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }

    public void setPlayerBalance(int b) {
        playerBalance = b;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void removeCard(int index) {
        hand.remove(index);
    }

    public void addCard(int index, Card c) {
        hand.add(index, c);
    }

}
