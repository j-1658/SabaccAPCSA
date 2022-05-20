import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> deckList = new ArrayList<Card>();   //the deck itself; an array list of cards
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
    }   //deck constructor
    public void printDeck()    {
        for (int i = 0; i < deckList.size(); i++)   {
            System.out.println(deckList.get(i));
        }
    }   // prints the entire deck, not to useful outside of testing
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
    }   //takes all cards in deck & shuffles them(doesn't matter how many cards in deck)
    public ArrayList getDeckList()  {
        return deckList;
    }   //getter for the ArrayList deckList
    public Card drawCard()  {
        return deckList.remove(0);
    }   //removes the top card from deckList & returns it
    public void returnToDeck (Card returnedCard)    {
        deckList.add(returnedCard);
    }   //puts card at end of deckList
}
