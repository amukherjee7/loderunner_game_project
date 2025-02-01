import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World{
    public GreenfootImage bg;
    public GreenfootImage brick;
    public MyWorld(){    
        super(600, 480, 1);
        bg = new GreenfootImage(600, 480);
        Color color = Color.BLACK;
        bg.fillRect(0, 0, 600, 480);
        setBackground(bg);
        
        brick = new GreenfootImage("bricks.png");
        //bg.drawImage(brick, 100, 100);
                
        walls(6, 0, 53);
        walls(3, brick.getWidth()*5, 70+brick.getHeight()*5);
        grid(3, 4, 0, 60+brick.getHeight()*15);
        walls(26, 0, getHeight()-11);
        walls(9, brick.getWidth()*3, 60+brick.getHeight()*15);
        grid(2, 3, brick.getWidth()*13, 60+brick.getHeight()*16);
        grid(1, 3, brick.getWidth()*20, 60+brick.getHeight()*16);
        grid(3, 3, brick.getWidth()*22, 60+brick.getHeight()*16);
        
        Player player = new Player();
        addObject(player, 20, 20);
        
        buildLadder(5, 140, 55);
        buildLadder(8, 100, 177);
        buildLadder(8, 188, 177);
        buildLadder(3, 285, 377);
        buildLadder(3, 501, 397);
        buildLadder(3, 593, 397);
        
        buildBar(3, 400, 20);
        buildBar(7, 310, 370);
        buildBar(4, 200, 150);
    }
    
    public void buildBar(int numBars, int x, int y) {
        for(int i=0; i<numBars; i++) {
            Bar bar = new Bar();
            addObject(bar, x, y);
            x+=bar.getImage().getWidth();
        }
    }
    
    public void buildLadder(int numLadders, int x, int y) {
        for(int i=0; i<numLadders; i++) {
            Ladder ladder = new Ladder();
            addObject(ladder, x, y);
            y+=ladder.getImage().getHeight();
        }
    }
    
    public void walls(int numWalls, int x, int y) {
        int dx = 0;
        for(int i=0; i<numWalls; i++) {
            Wall wall = new Wall();
            addObject(wall, x+dx, y);
            dx+=brick.getWidth();
        }
    }
    
    public void grid(int numWalls, int numRows, int x, int y) {
        int dy = 0;
        for(int i=0; i<numRows; i++) {
            walls(numWalls, x, y+dy);
            dy+=1.1*brick.getHeight();
        }
    }
}
