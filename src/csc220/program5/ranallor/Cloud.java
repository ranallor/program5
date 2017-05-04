package csc220.program5.ranallor;

/**
 * Robert Ranallo
 * Project 5
 * 5/3/2017
 * A subclass of GameCharacter, this Class draws a cloud with a smiley face on it that has a set
 * animation path that can be altered from within the program, thanks to the List class which is also found in
 * this package. The drawing of the cloud itself, is a modified object that has been used in previous projects.
 */


import csc220.program5.GameCharacter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cloud extends GameCharacter {
    
    private int over, down, width;
    
    public Cloud(int x, int y, int moveInterval) {
        super(x, y, 50, 50, 1000, new List<Point>());
        over = x;
        down = y;
        width = 50;
        animationPath.add(new Point(x, y));
        animationPath.add(new Point(x + 100, y));
        animationPath.add(new Point(x, y + 100));
        animationPath.add(new Point(x + 100, y + 100));
        animationPath.add(new Point(x + 50, y + 50));
        animationPath.add(new Point(x + 100, y + 50));
        animationPath.add(new Point(x + 50, y + 100));
        animationPath.add(new Point(x + 50, y));
        animationPath.add(new Point(x, y + 50));
    }
    
    @Override
    public void draw( Graphics g ) {     
        //Cloud outline
        int over = getOver();
        int down = getDown();
        int width = getWidth();
        g.setColor(Color.BLACK);
        g.drawOval(over, down, width, width);
        g.drawOval(over - 18, down + 18, width, width);
        g.drawOval(over, down + 18, width, width);
        g.drawOval(over + 18, down + 18, width, width);
        g.drawOval(over - 35, down + 35, width, width);
        g.drawOval(over - 18, down + 35, width, width);
        g.drawOval(over, down + 35, width, width);
        g.drawOval(over + 18, down + 35, width, width);
        g.drawOval(over + 35, down + 35, width, width);

        //Cloud
        g.setColor(Color.DARK_GRAY);
        g.fillOval(over, down, width, width);
        g.fillOval(over - 18, down + 18, width, width);
        g.fillOval(over, down + 18, width, width);
        g.fillOval(over + 18, down + 18, width, width);
        g.fillOval(over - 35, down + 35, width, width);
        g.fillOval(over - 18, down + 35, width, width);
        g.fillOval(over, down + 35, width, width);
        g.fillOval(over + 18, down + 35, width, width);
        g.fillOval(over + 35, down + 35, width, width);
        
        //Smiley Face
        g.setColor(Color.WHITE);
        g.fillOval(over, down + 22, 19, 19);
        g.fillOval(over + 26, down + 22, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(over, down + 22, 20, 20);
        g.drawOval(over + 26, down + 22, 20, 20);
        g.fillArc(over, down + 30, width, width, 180, 180);
        g.fillOval(over + 8, down + 30, 12, 12);
        g.fillOval(over + 35, down + 30, 12, 12);
    }
   
}