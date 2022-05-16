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
    void nextTurn(){
        playerTurn = new Turn();

    }
    Player findWinner(){

    }

}
