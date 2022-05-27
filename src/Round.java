public class Round {
    boolean isComplete;
    Player[] playerList;
    int currentTurnNum;
    Turn playerTurn;
    Game game;
    boolean checked;

    public Round(Game g){
        isComplete = false;
        this.playerList = g.getPlayerList();
        currentTurnNum = 0;
        checked = false;
        game = g;
    }
    /*public void sabaccShift(){
        double shiftChance = 0.25; //25% chance to shift
        boolean isShifted = (Math.random() < shiftChance); //actually checks if it shifts
        if(isShifted){
            for (int p = 0; p < playerList.length; p++){ //for each player

                for(int c = 0; c < playerList[p].hand.size(); c++){ //for each card in each player's hand
                    //checks if card is in interference field
                    if(!playerList[p].hand.get(c).getInField()){
                        //
                        //Randomize suit
                        String suit = "";
                        switch((int)(Math.random()*5)){
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
                        int value ;
                        //checks if it's a face card
                        if(suit.equals("Staves")||suit.equals("Coins")||suit.equals("Flasks")||suit.equals("Sabers")){
                            //normal values 1-15
                            value = (int) (Math.random() * 16) + 1;
                        } else{
                            //face card values
                            int[] specialList = {-11, 0, -8, -14,-15,-2,-13,-17};
                            int index = (int)(Math.random()*7);
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
    }*///had to be scrapped but leaving code because I want to add it back later

    void nextTurn(){
        Player nextPlayer;
        if(currentTurnNum >= playerList.length) currentTurnNum = 0;
        nextPlayer = playerList[currentTurnNum];

        System.out.println("\f------------------STARTING " + nextPlayer.getName() + "'s turn------------------");
        playerTurn = new Turn(nextPlayer,game);
        playerTurn.run();

        currentTurnNum++;
    }
    public Player findWinner(){
        Player winner = new Player(0, -1, "No Winner", true, game);

        int winnerHand = 0;
        int winnerCardCount = 0;

        for (Player player : playerList) { //checks for highest value
            if (player.getIsPlaying()) {
                if (player.calcHand() > winnerHand && winnerHand != -1 && winnerHand <=23) {
                    if (player.getHand().size() == winnerCardCount) {
                        int x = (int) (Math.random() * 2);
                        if (x == 0) {
                            winner.playerNum = player.getPlayerNum();
                            winnerCardCount = player.getHand().size();
                            winnerHand = player.calcHand();
                        }
                    } else {
                        winner.playerNum = player.getPlayerNum();
                        winnerCardCount = player.getHand().size();
                        winnerHand = player.calcHand();
                    }
                }
                if (player.calcHand() == -1) { //idiots array and sabacc
                    if (winnerHand == -1) {
                        if (player.getHand().size() == winnerCardCount) {
                            int x = (int) (Math.random() * 2);
                            if (x == 0) {
                                winner.playerNum = player.getPlayerNum();
                                winnerCardCount = player.getHand().size();
                                winnerHand = player.calcHand();
                            }
                        }
                    } else {
                        winner.playerNum = player.getPlayerNum();
                        winnerCardCount = player.getHand().size();
                        winnerHand = player.calcHand();
                    }
                }
            }
        }

        for(Player p: playerList){
            if(winner.playerNum == p.playerNum){
                return p;
            }
        }
        game.setCurrentMinBet(10);
        return winner;
    }

    public Turn getTurn(){
        return playerTurn;
    }

    public Player run(){
        while(!checked){
            nextTurn();
            checked = playerTurn.getIsCheckTurn();
            if(checked){
                break;
            }
        }
        return findWinner();

    }

}
