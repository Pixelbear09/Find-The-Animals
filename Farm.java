
/**
 * Write a description of class Farm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;

public class Farm extends JFrame implements MouseListener
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

    String tileClickedFilePath = "Images/Clicked.png";
    ImageIcon tileClicked = new ImageIcon(tileClickedFilePath);

    String sheepFilePath = "Images/Sheep.png";
    ImageIcon sheep = new ImageIcon(sheepFilePath);

    //Integers
    int xPos = 0;
    int yPos = 0;
    int columnID = 0;
    int rowID = 0;
    int animalX = (int)(Math.random() * COLUMNS);
    int animalY = (int)(Math.random() * ROWS);
    int animals = 0;

    //Arrays
    boolean[][] clicked = new boolean [ROWS][COLUMNS];
    boolean[][] animal = new boolean [ROWS][COLUMNS];
    public Farm(){
        while (animals > 10){
            if(animal[animalX][animalY] == true){
                animalX = (int)(Math.random() * COLUMNS);
                animalY = (int)(Math.random() * ROWS);         
            }else{
                animal[animalX][animalY] = true;
                animalX = (int)(Math.random() * COLUMNS);
                animalY = (int)(Math.random() * ROWS); 
            }
        }

        setTitle(WINDOWNAME);
        this.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);

        addMouseListener(this);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        myGraphic = new Canvas();
        panel.add(myGraphic);
    }

    public void mouseExited(MouseEvent e){
        System.out.println("exit");
    }

    public void mouseEntered(MouseEvent e){
        System.out.println("enter");
    }

    public void mouseReleased(MouseEvent e){
        System.out.println("release");
    }

    public void mousePressed(MouseEvent e){
        System.out.println("press");
    }

    public void mouseClicked(MouseEvent e){
        int mouseX=e.getX();
        int mouseY=e.getY();
        System.out.println("click at "+mouseX+", "+mouseY);

        getColumnID(mouseX);
        getRowID(mouseY);
        System.out.println(columnID);
        System.out.println(rowID);
        System.out.println(ROWS);
        if(mouseX <= (TILEWIDTH * COLUMNS) && mouseY <= (TILEHEIGHT * ROWS)
        && mouseX >= XOFFSET && mouseY >= YOFFSET){
            clicked[columnID][rowID] = true; 
        }
        repaint();
    }

    public int getXPosition(int mouseX){
        mouseX = (columnID * TILEWIDTH) + XOFFSET;
        return mouseX;
    }

    public int getColumnID(int xPosition){
        columnID = (int)(Math.floor(xPosition - XOFFSET) / 180);
        return columnID;
    }

    public int getYPosition(int mouseY){
        mouseY = (rowID * TILEWIDTH) + YOFFSET;
        return mouseY;
    }

    public int getRowID(int yPosition){
        rowID = (int)(Math.floor(yPosition - YOFFSET) / 180);
        return rowID;
    }

    public void paint(Graphics g){
        super.paint(g);
        xPos = XOFFSET;
        yPos = YOFFSET;
        for (int y=0; y<COLUMNS;y++){
            for (int x=0; x<ROWS;x++){
                if(animal[animalX][animalY] == true && clicked[x][y] == true){
                    sheep.paintIcon(this,g,xPos,yPos);
                }else if(clicked[x][y] == true){
                    tileClicked.paintIcon(this,g,xPos,yPos);
                }else{
                    tileUnclicked.paintIcon(this,g,xPos,yPos);
                }
                xPos = xPos + TILEWIDTH;
            }
            yPos = yPos + TILEHEIGHT;
            xPos = 0;
        }
    }
}