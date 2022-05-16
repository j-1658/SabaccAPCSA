public class Round {
    boolean isComplete;
    Player[] playerList;
    int currentTurnNum;
    Turn playerTurn;

    public Round(Player[] playLst, ){
        isComplete = false;
        this.playerList = playLst;
        currentTurnNum = 0;
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

    void nextTurn(){
        playerTurn = new Turn();

    }
    Player findWinner(){

    }

}
