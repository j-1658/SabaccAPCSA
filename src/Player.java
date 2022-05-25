import java.util.ArrayList;

public class Player {
    int playerBalance;
    int playerNum;
    String name;
    ArrayList<Card> hand;
    boolean isPlaying;
    boolean isBot;

    Game game;

    public Player(int pB, int pN, String n, boolean iB, Game g) {
        hand = new ArrayList<Card>();
        playerBalance = pB;
        playerNum = pN;
        name = n;
        isPlaying = true;
        isBot = iB;
        game = g;
    }


    public int calcHand() {
        boolean containsIdiot = false;
        boolean contains2 = false;
        boolean contains3 = false;
        int sum = 0;
        for (Card c: hand) {
            switch (c.getValue()) {
                case 0: containsIdiot = true;
                    break;
                case 2: contains2 = true;
                    break;
                case 3: contains3 = true;
                    break;
            }
            sum += c.getValue();
        }
        if (containsIdiot && contains2 && contains3 && hand.size() == 3) {
            return -1; //return special num for idiots array
        }
        return Math.abs(sum); //return abs value of all cards in hand
    }

    public void botPlay() {
        int stopVal = (int) ((Math.random() * 6) + 16);
        if (isBot) {
            while (calcHand() != -1 && calcHand() <= stopVal) {
                game.getCurrentRound().getTurn().hit(); //hit until idiots array or stopVal or higher
            }
        }
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

    public void setIsPlaying(boolean p) {
        isPlaying = p;
    }

    public boolean getIsPlaying(){ return isPlaying;}
}