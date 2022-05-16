import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Screen extends JFrame implements KeyListener{
    //An actively changing arraylist, that contains all options for the player to cycle through
    private ArrayList<Screen.possibleOptions> currentOptions = new ArrayList<>();

    //Check to see if we are listening to player input at that time
    private boolean listen;

    //All the possible-non card options the player can make
    public enum possibleOptions{
        BET, CHECK, FOLD, HIT, SWITCH, QUIT, CONTINUE
    }

    //Position of "currentOptions" arraylist
    private int optionPosition;




    public Screen(){

        //Set up Screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);

        this.listen = false;
        this.optionPosition = 0;
    }


    //Clear arraylist containing all choices
    public void clearOptions(){
        currentOptions.clear();
    }
    public void addOption(Screen.possibleOptions newOption){
        this.currentOptions.add(newOption);
    }

    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        if(listen) {
            switch(e.getKeyChar()) {

                //Up
                case 'w':

                    break;

                //Down
                case 'd':


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

                    break;

                //Up

                case 38:

                    break;

                //Down

                case 40:

                    break;
            }
        }

    }


    public void keyReleased(KeyEvent e) {
        System.out.println("Input received: " + e.getKeyCode());
    }

}
