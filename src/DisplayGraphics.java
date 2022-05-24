import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DisplayGraphics extends JPanel {
    int presetScene; // to work with Screen class's preset options
    Game game;
    Player[] localPlayerList;
    //CONSTRUCTORS//
    public DisplayGraphics(Game g){
        game = g;
        localPlayerList = g.getPlayerList();
        presetScene = -1;
    }
    public DisplayGraphics(int p, Game g){
        game = g;
        localPlayerList = g.getPlayerList();
        presetScene = p;
    }

    //Image reader method that is a simplified version of code from https://www.dummies.com/article/technology/programming-web-design/java/how-to-write-java-code-to-show-an-image-on-the-screen-150767/
    public BufferedImage getImage(String p){
        BufferedImage image = new BufferedImage(100, 200, BufferedImage.TYPE_INT_ARGB); //the numbers are supposed to be the height/width of the image but I have found they dont actually change anything so its fine if they are hardcoded
        File file;

        //read image
        try{
            file = new File(p); //image file path
            image = ImageIO.read(file); // reads file
            System.out.println("Reading complete.");
        }catch(IOException e) { // checks if file exists and is an image and also ImageIO gets mad about unhandled exeptions
            System.out.println("Error: " + e);
        }
        return image;
    }

    ////
    //Image creation from card method
    public BufferedImage getCardImage(Card c){

        return getImage("src/resources/images/" + c.getSuit() + c.getValue()+".png");
    }
    //overload so I can get the back of cards
    public BufferedImage getCardImage(){

        return getImage("src/resources/images/cardBack.png");
    }
    ////

    //
    BufferedImage creditSymbol = getImage("src/resources/images/CREDIT.png");
    //

    public void paintComponents(Graphics g){
        super.paintComponents(g);
        /* This commented code is for creating vector drawings of the cards which is my prefered way of doing graphics but 
        // i ran out of time so I'm using imported images of cards I drew in google slides
        */
        /*
        Color back1Color = new Color(67,67,67);
        Color back2Color = new Color(102,102,102);
        //
        Color coinsColor = new Color(241,194,50);
        Color stavesColor = new Color(126, 190, 96);
        Color flasksColor = new Color();
        Color sabersColor = new Color();
        //
        Color front1Color = new Color();
        Color front2Color = new Color();
        //
        Color faceCardBorder = new Color();

        Color balanceColor = new Color();
        Color idiotColor = new Color();
        Color starColor = new Color();
        Color evilColor = new Color();
        Color queenColor = new Color();
        Color enduranceColor = new Color();
        Color demiseColor = new Color();
        Color moderationColor = new Color();
        //


        //Polygons//
        int[] cardX = {95,120,180,205,180,120};
        int[] cardY = {160,80,80,160,240,240};
        Polygon card = new Polygon(cardX, cardY, 6);
        */

        //Table Color
        Color rectColor = new Color(209,130,88);
        //Button Color
        Color unusedButton = new Color(173,173,173);
        Color selectedButton = new Color(111, 168, 220);
        Color holoColor = new Color(159, 241, 241);
        //
        Color warningColor = new Color(255, 229, 153);
        Color warningTextColor = new Color(204, 0, 0);

        //base scene
        setBackground(Color.BLACK);
        g.setColor(rectColor);
        g.fillRect(20,20,1400,900);
        //
        //int width = 150;
        //g.drawImage(getImage("src/resources/images/cardBack.png"), 1400/2-width, 900/2-(width*3/2), width, width*3/2,  this);
        //template for drawing cards
        int width = 150;
        Card testCard = new Card(false, "staves", 8);
        g.drawImage(getCardImage(testCard), 1400/2-width, 900/2-(width*3/2), width, width*3/2,  this);


        switch(presetScene){
            case 1:
                //Drawing and review stage
                //other ppls hands and deck
                g.drawImage(getCardImage(testCard), 1400/2-width, 900/2-(width*3/2), width, width*3/2,  this);
                g.drawImage(getCardImage(testCard), 1400/2-width, 900/2-(width*3/2), width, width*3/2,  this);
                g.drawImage(getCardImage(testCard), 1400/2-width, 900/2-(width*3/2), width, width*3/2,  this);
                //display balances and names
                Player prevPlayer = null;
                Player nextPlayer = null;
                try {
                    prevPlayer = localPlayerList[this.game.getCurrentTurn().getCurrentPlayer().getPlayerNum() - 1];
                } catch (IndexOutOfBoundsException e){
                    prevPlayer =  localPlayerList[localPlayerList.length-1];
                }
                try {
                    nextPlayer = localPlayerList[this.game.getCurrentTurn().getCurrentPlayer().getPlayerNum() + 1];
                } catch (IndexOutOfBoundsException e){
                    nextPlayer = localPlayerList[0];
                }

                g.drawString(prevPlayer.getName(), 40, 200);
                g.drawString(nextPlayer.getName(), 40, 200);
                break;
            case 2:
                //winner announcement
                break;
            case 3:
                //betting screen
                break;
            case 4:
                //Options after bet
                break;
            default:
                //
                break;
        }
    }
    /*public static void main(String[] args) {
        DisplayGraphics m = new DisplayGraphics();
        JFrame f = new JFrame();

        f.setSize(1500,1000);
        f.add(m);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }*/
}
