
/**
 * The farm level for the game.
 *
 * @author Owen J
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;

public class Farm extends JFrame
{
    //Declarations
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;

    //Finals
    final int WIDTH = 900;
    final int HEIGHT = 1080;
    final String WINDOWNAME = "Farm Level";
    final int TILEWIDTH = 180;
    final int TILEHEIGHT = 180;
    final int XOFFSET = 0;
    final int YOFFSET = 50;
    final int ROWS = 5;
    final int COLUMNS = 5;

    //Images
    String tileUnclickedFilePath = "Images/Unclicked.png";
    ImageIcon tileUnclicked = new ImageIcon(tileUnclickedFilePath);

    //Integers
    int xPos = 0;
    int yPos = 0;
    int columnID = 0;
    int rowID = 0;
    public Farm()
    {
        setTitle(WINDOWNAME);
        this.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        myGraphic = new Canvas();
        panel.add(myGraphic);
    }

    public int getXPosition(int X){
        X = (columnID * TILEWIDTH) + XOFFSET;
        return X;
    }

    public int getColumnID(int xPosition){
        columnID = (int)(Math.floor(xPosition - XOFFSET) / 180);
        return columnID;
    }

    public int getYPosition(int Y){
        Y = (rowID * TILEWIDTH) + YOFFSET;
        return Y;
    }

    public int getRowID(int yPosition){
        rowID = (int)(Math.floor(yPosition - YOFFSET) / 180);
        return rowID;
    }

    public void paint(Graphics g){
        super.paint(g);
        xPos = XOFFSET;
        yPos = YOFFSET;
        for(int y=0;y<COLUMNS;y++){
            for(int x=0;x<ROWS;x++){
                tileUnclicked.paintIcon(this,g,xPos,yPos);
                xPos = xPos + TILEWIDTH;
            }
            yPos = yPos + TILEHEIGHT;
        }

    }
}