public class Card {
    private boolean inField;    //keeps track on whether the card is in the interference field
    private String suit;    //the string of the suit, for the special cards it is the name of the card itself
    private int value;  //the int value of the card's worth
    public Card(boolean inField, String suit, int value)   {    //card constructor
        this.inField = inField;
        this.suit = suit.toUpperCase();
        this.value = value;
    }
    public void setInField(boolean inField) {   //used put a card in or out of the interference field
        this.inField = inField;
    }
    public boolean getInField() {   //used to return weather a card is in the interference field
        return this.inField;
    }
    public void setSuit(String suit) {  //can be used to change a card's suit
        this.suit = suit.toUpperCase();
    }
    public String getSuit() {
        return this.suit;
    }   //gets the suit
    public void setValue(int value) {   //can change the int value of a card
        this.value = value;
    }
    public int getValue()   {   //gets the int value of a card
        return this.value;
    }
    public String stringValue(int v) {  //used in the toString method ot return a string version of the int value.
        switch (v)  {
            case 1 : return "ONE";
            case 2 : return "TWO";
            case 3 : return "THREE";
            case 4 : return "FOUR";
            case 5 : return "FIVE";
            case 6 : return "SIX";
            case 7 : return "SEVEN";
            case 8 : return "EIGHT";
            case 9 : return "NINE";
            case 10: return "TEN";
            case 11: return "ELEVEN";
            case 12: return "COMMANDER";
            case 13: return "MISTRESS";
            case 14: return "MASTER";
            case 15: return "ACE";
            default: return "";
        }
    }
    public boolean isSpecial()  {   //checks if a card is 'special'
        if (suit.equals("BALANCE"))
            return true;
        else if (suit.equals("THE IDIOT"))
            return true;
        else if (suit.equals("ENDURANCE"))
            return true;
        else if (suit.equals("MODERATION"))
            return true;
        else if (suit.equals("THE EVIL ONE"))
            return true;
        else if (suit.equals("THE QUEEN OF AIR AND DARKNESS"))
            return true;
        else if (suit.equals("DEMISE"))
            return true;
        else if (suit.equals("THE STAR"))
            return true;
        else
            return false;
    }
    public String toString() {
        String output = "";
        if(isSpecial())
            output = suit;
        else
            output = stringValue(value) + " of "+ suit;
        return output;
    }
}
