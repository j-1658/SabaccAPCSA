import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Screen extends JFrame implements KeyListener{
    private Game game;
    private Scanner scan = new Scanner(System.in);

    //An actively changing arraylist, that contains all current options for the player to cycle through
    private ArrayList<Screen.possibleOptions> curOptions = new ArrayList<>();

    //Check to see if we are listening to player input at that time
    private boolean listen;

    //All the possible-non card options the player can make
    public enum possibleOptions{
        BET, CHECK, FOLD, HIT, QUIT, CONTINUE, BACK;
    }
    //A list of presets for the curOptions List
    public enum optionListPresets{
        DRAWING, BETWEENROUND, BET, AFTERBET;
    }

    //Position of "currentOptions" arraylist
    private int curOptionPosition;

    //initialize Screen
    public Screen(Game g){

        //Set up Screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);

        this.listen = false;
        this.curOptionPosition = 0;
        this.game = g;
    }

    //Clear arraylist containing all choices
    public void clearOptions(){
        curOptions.clear();
    }

    //Add an option to curOptions
    public void addOption(Screen.possibleOptions newOption){
        this.curOptions.add(newOption);
    }

    //Check which choice was selected
    public void determineChoice(Screen.possibleOptions choice){
        switch(choice){
            //Bet something or go back
            case BET:
                this.setCurrentOptions(optionListPresets.BET);
                // Re Draw Buttons *******************************************************************
                this.game.getCurrentTurn().bet(scan.nextInt());
                break;
            //Gain a card
            case HIT:
                game.getCurrentTurn().hit();
                break;
            //Fold
            case FOLD:
                this.game.getCurrentTurn().fold();
                break;
            // End the screen
            case QUIT:
                this.dispose();
                //something to stop game ***************************** ********************************************
                break;
            //end player's turn
            case CHECK:
                this.game.getCurrentTurn().endTurn();
                break;
            //Continue playing game by starting another round
            case CONTINUE:
                game.startRound();
                break;
            //Stop betting
            case BACK:
                this.setCurrentOptions(optionListPresets.DRAWING);
                // Re Draw Buttons ********************************************************
                break;

        }
    }
    //Use presets to make list of options
    public void setCurrentOptions(Screen.optionListPresets preset){
        curOptions.clear();
        curOptionPosition = 0;
        switch(preset){
            //Normal case, during the drawing period of a round or you went back from betting

            case DRAWING:
                curOptions.add(0, possibleOptions.BET);
                curOptions.add(possibleOptions.CHECK);
                curOptions.add(possibleOptions.FOLD);
                curOptions.add(possibleOptions.HIT);
                break;
            //After a round finishes, you choose to continue or not
            case BETWEENROUND:
                curOptions.add(possibleOptions.CONTINUE);
                curOptions.add(possibleOptions.QUIT);
                break;
            //While ur betting you have one option to go back or enter a bet
            case BET:
                curOptions.add(possibleOptions.BACK);

                break;
            //No option to bet after you bet
            case AFTERBET:
                curOptions.add(possibleOptions.CHECK);
                curOptions.add(possibleOptions.FOLD);
                curOptions.add(possibleOptions.HIT);
                break;
        }
    }
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        if(listen) {
            switch(e.getKeyChar()) {

                //Up
                case 'w':
                    //it will either go up one, or go to the bottom (case: highest position)
                    if(this.curOptionPosition == 0){
                        this.curOptionPosition = curOptions.size()-1;

                    } else{
                        this.curOptionPosition--;
                    }
                    //update buttons ***************************************************************
                    break;

                //Down
                case 'd':
                    //it will either go down one, or go to the top (case: lowest position)
                    if(this.curOptionPosition == curOptions.size()-1) {
                        this.curOptionPosition = 0;
                    } else {
                        this.curOptionPosition++;
                    }
                    //update buttons ******************************************************************
                    break;
            }
        }

    }
    public void keyPressed(KeyEvent e) {

        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output

        if(listen){
            switch(e.getKeyCode()) {
                //SpaceBar
                case 32:
                    determineChoice(curOptions.get(curOptionPosition));

                    break;
                //Up
                case 38:
                    //it will either go up one, or go to the bottom (if highest position)
                    if(this.curOptionPosition == 0){
                        this.curOptionPosition = curOptions.size()-1;
                    } else {
                        this.curOptionPosition--;
                    }
                    // update buttons **************************************************************************
                    break;

                //Down
                case 40:
                    //it will either go down one, or go to the top (if lowest position)
                    if(this.curOptionPosition == curOptions.size()-1) {
                        this.curOptionPosition = 0;
                    } else {
                        this.curOptionPosition++;
                    }
                    //update buttons ****************************************************************************
                    break;
            }
        }

    }


    public void keyReleased(KeyEvent e) {
        //Once you release a key
        System.out.println("Input received/Released: " + e.getKeyCode());
    }

}
