import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Screen extends JFrame implements KeyListener{
    private Game game;
    //An actively changing arraylist, that contains all current options for the player to cycle through
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Screen.possibleOptions> curOptions = new ArrayList<>();

    //Check to see if we are listening to player input at that time
    private boolean listen;

    //All the possible-non card options the player can make
    public enum possibleOptions{
        BET, CHECK, FOLD, HIT, SWITCH, QUIT, CONTINUE, BACK;
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
            case BET:
                //Bet something
                listen = false;
                this.game.getCurrentTurn().bet(scan.nextInt());
                break;
            case HIT:
                //Gain card
                listen = false;
                //game.getCurrentTurn().hit()
                break;
            case FOLD:
                this.game.getCurrentTurn().fold();
                break;
            case QUIT:
                //Quit game
                break;
            case CHECK:
                //proceed in order
                break;
            case SWITCH:
                //switch card
                break;
            case CONTINUE:
                //play another round
                break;
            case BACK:
                //go back to last few choices
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
                    break;

                //Down
                case 'd':
                    //it will either go down one, or go to the top (case: lowest position)
                    if(this.curOptionPosition == curOptions.size()-1) {
                        this.curOptionPosition = 0;
                    } else {
                        this.curOptionPosition++;
                    }
                    break;
            }
        }

    }

    public void keyPressed(KeyEvent e) {

        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output

        if(listen){
            switch(e.getKeyCode()) {
                //enter
                case 13:
                    determineChoice(curOptions.get(curOptionPosition));

                    break;
                //Up
                case 38:
                    //it will either go up one, or go to the bottom (case: highest position)
                    if(this.curOptionPosition == 0){
                        this.curOptionPosition = curOptions.size()-1;
                    } else {
                        this.curOptionPosition--;
                    }
                    break;
                //Down
                case 40:
                    //it will either go down one, or go to the top (case: lowest position)
                    if(this.curOptionPosition == curOptions.size()-1) {
                        this.curOptionPosition = 0;
                    } else {
                        this.curOptionPosition++;
                    }
                    break;
            }
        }

    }


    public void keyReleased(KeyEvent e) {
        //Once you release a key
        System.out.println("Input received: " + e.getKeyCode());
    }

}
