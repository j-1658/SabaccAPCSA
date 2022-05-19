import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> deckList = new ArrayList<Card>();
    public Deck()   {
        String mySuit = "";
        Card myCard = new Card(false,"YIPEE!",100);
        for (int i = 0; i < 4; i++)    {
            if     (i == 0)
                mySuit = "FLASKS";
            else if(i == 1)
                mySuit = "SABERS";
            else if(i == 2)
                mySuit = "STAVES";
            else if(i == 3)
                mySuit = "COINS";
            for (int j = 0; j < 15; j++)    {
                myCard = new Card(false, mySuit, (j+1));
                deckList.add(myCard);
            }
        }
        for(int i = 0; i < 2; i++)  {
            deckList.add(new Card(false, "BALANCE", -11));
            deckList.add(new Card(false, "THE IDIOT", 0));
            deckList.add(new Card(false, "ENDURANCE", -8));
            deckList.add(new Card(false, "MODERATION", -14));
            deckList.add(new Card(false, "THE EVIL ONE", -15));
            deckList.add(new Card(false, "THE QUEEN OF AIR AND DARKNESS", -2));
            deckList.add(new Card(false, "DEMISE", -13));
            deckList.add(new Card(false, "THE STAR", -17));
        }
    }
    public void printDeck()    {
        for (int i = 0; i < deckList.size(); i++)   {
            System.out.println(deckList.get(i));
        }
    }
    public void shuffle()   {
        Card[] tempDeck = new Card[deckList.size()];
        int i = -1;
        for(Card x : deckList)  {
            do
                i = (int)(Math.random()*deckList.size());
            while (tempDeck[i] != null);
            tempDeck[i] = x;
        }
        deckList.clear();
        for(Card y : tempDeck)  {
            deckList.add(y);
        }
    }
    public ArrayList getDeckList()  {
        return deckList;
    }
    public Card drawCard()  {
        return deckList.remove(0);
    }
    public void returnToDeck (Card returnedCard)    {
        deckList.add(returnedCard);
    }
}
