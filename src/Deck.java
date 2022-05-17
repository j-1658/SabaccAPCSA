import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> deckList;
    public Deck()   {
        String mySuit = "";
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
                deckList.add(new Card(false, mySuit, (j+1)));
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
}
