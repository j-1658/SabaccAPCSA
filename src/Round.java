public class Round {
    boolean isComplete;
    Player[] playerList;
    int currentTurnNum;
    Turn playerTurn;
    Game game;
    boolean checked;

    public Round(Player[] playLst){
        isComplete = false;
        this.playerList = playLst;
        currentTurnNum = -1;
        checked =false;
    }
    public void sabaccShift(){
        double shiftChance = 0.25; //25% chance to shift
        boolean isShifted = (Math.random() < shiftChance); //actually checks if it shifts
        if(isShifted){
            for (int p = 0; p < playerList.length; p++){ //for each player

                for(int c = 0; c < playerList[p].hand.size(); c++){ //for each card in each players hand
                    //checks if card is in interference field
                    if(!playerList[p].hand.get(c).getInField()){
                        //
                        //Randomize suit
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
                        //
                        //randomize value
                        int value = 0;
                        //checks if its a face card
                        if(suit.equals("Staves")||suit.equals("Coins")||suit.equals("Flasks")||suit.equals("Sabers")){
                            //normal values 1-15
                            value = (int) (Math.random() * 16) + 1;
                        } else{
                            //face card values
                            int[] specialList = {-11, 0, -8, -14,-15,-2,-13,-17};
                            int index = (int)Math.random()*7;
                            value = specialList[index];
                            switch(value){
                                case -11 : suit = "BALANCE"; break;
                                case 0 : suit = "IDIOT"; break;
                                case -8 : suit = "ENDURANCE"; break;
                                case -14 : suit = "MODERATION"; break;
                                case -15 : suit = "THE EVIL ONE"; break;
                                case -2 : suit = "THE QUEEN OF AIR AND DARKNESS"; break;
                                case -13 : suit = "DEMISE"; break;
                                case -17 : suit = "THE STAR"; break;
                            }
                        }
                        // actually changes the card
                        playerList[p].hand.get(c).setValue(value);
                        playerList[p].hand.get(c).setSuit(suit);
                    }
                }
            }
        }
    }

    boolean nextTurn(){
        playerTurn = new Turn(playerList[currentTurnNum+1],game);
        playerTurn.run();
        return playerTurn.getIsCheckTurn();
    }
    Player findWinner(){
        Player winner = new Player(1000, -1, "No Winner", true, game);
        for(int p = 0; p < playerList.length; p++){ //checks for highest value
            if(playerList[p].calcHand() > winner.calcHand()){
                winner.name = playerList[p].getName();
            }
        }
        for(int p = 0; p < playerList.length; p++){ //checks for special combos
            if(playerList[p].calcHand() == -1 || playerList[p].calcHand() == 23 ){ //idiots array and sabacc
                winner.name = playerList[p].getName();
            }
        }

        for(Player p: playerList){
            if(winner.name.equals(p.getName())){
                return p;
            }
        }
        return winner;
    }

    public Turn getTurn(){
        return playerTurn;
    }
    Player run(){
        int p = 0;
        while(!checked) {
            System.out.println("STARTING " + playerList[p].getName() + "'s turn"); //PLACEHOLDER
            checked = nextTurn();
        }
        return findWinner();

    }

}
