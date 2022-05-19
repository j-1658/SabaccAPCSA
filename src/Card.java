public class Card {
    private boolean inField;
    private String suit;
    private int value;
    public Card(boolean inField, String suit, int value)   {
        this.inField = inField;
        this.suit = suit.toUpperCase();
        this.value = value;
    }
    public void setInField(boolean inField) {
        this.inField = inField;
    }
    public boolean getInField() {
        return this.inField;
    }
    public void setSuit(String suit) {
        this.suit = suit.toUpperCase();
    }
    public String getSuit() {
        return this.suit;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue()   {
        return this.value;
    }
    public String stringValue(int v) {
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
    public boolean isSpecial()  {
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
