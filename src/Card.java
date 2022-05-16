public class Card {
    private boolean inField;
    private String suit;
    private int value;
    public Card(boolean inField, String suit, int value)   {
        this.inField = inField;
        this.suit = suit.toUpperCase();
        this.value = value;
    }
    public void setInterface(boolean inField) {
        this.inField = inField;
    }
    public boolean getInterface() {
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
            case 1: return "ONE";
                    break;
            case 2: return "TWO";
                    break;
            case 3: return "THREE";
            break;
            case 4: return "FOUR";
            break;
            case 5: return "FIVE";
            break;
            case 6: return "SIX";
            break;
            case 7: return "SEVEN";
            break;
            case 8: return "EIGHT";
            break;
            case 9: return "NINE";
            break;
            case 10: return "TEN";
            break;
            case 11: return "ELEVEN";
            break;
            case 12: return "TWELVE";
            break;
            case 13: return "THIRTEEN";
            break;
            case 14: return "FOURTEEN";
            break;
            case 15: return "FIFTEEN";
            break;
        }
    }
    public String toString()    {
        String output = "";
        output += stringValue() + " of "+ ;
    }
}
