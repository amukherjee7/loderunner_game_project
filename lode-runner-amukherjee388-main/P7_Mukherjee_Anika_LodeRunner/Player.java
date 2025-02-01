import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor {
    int dx = 3;
    int dy = 3;
    int count = 0;
    public void act() {
        int x = getX();
        int y = getY();
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        Wall newWall = new Wall();
        int ww = newWall.getImage().getWidth();
        Ladder ladder = new Ladder();
        
        Actor wallBelow = getOneObjectAtOffset(0, getImage().getHeight()/2+1, Wall.class);
        //Actor wallLeft = getOneObjectAtOffset(-ww/2+1, h/2+1, Wall.class);
        //Actor wallRight = getOneObjectAtOffset(ww/2-1, h/2+1, Wall.class);
        if(wallBelow != null) {
            if(x>w && x<getWorld().getWidth()-w && y>h && y<getWorld().getHeight()-h) {
                if(Greenfoot.isKeyDown("left")) {
                    setLocation(getX()-dx, getY()); 
                    if(count%3 == 0) {
                        setImage("player_run_01.png");
                    } else if(count%3 == 1) {
                        setImage("player_run_02.png");
                    } else if(count%3 == 2) {
                        setImage("player_run_03.png");
                    }
                } else if(Greenfoot.isKeyDown("right")) {
                    setLocation(getX()+dx, getY());
                    if(count%3 == 0) {
                        setImage("player_run_01.png");
                    } else if(count%3 == 1) {
                        setImage("player_run_02.png");
                    } else if(count%3 == 2) {
                        setImage("player_run_03.png");
                    }
                } else if(Greenfoot.isKeyDown("up")) {
                    setLocation(getX(), getY()-dy);
                    if(count%3 == 0) {
                        setImage("player_run_01.png");
                    } else if(count%3 == 1) {
                        setImage("player_run_02.png");
                    } else if(count%3 == 2) {
                        setImage("player_run_03.png");
                    }
                }
            }
        } else {
            setLocation(getX(), getY()+dy);
        }
        
        Actor ladderBelow = getOneObjectAtOffset(0, getImage().getHeight()/2+1, Ladder.class);
        Actor ladderAbove = getOneObjectAtOffset(0, -getImage().getHeight()/2, Ladder.class);
        if(ladderBelow!= null) {
            if(x>w && x<getWorld().getWidth()-w && y>h && y<getWorld().getHeight()-h) {
                if(Greenfoot.isKeyDown("down")) {
                    setLocation(getX(), getY()+dy);
                }
            }
        } 
        if(ladderAbove!=null) {
            if(x>w && x<getWorld().getWidth()-w && y>h && y<getWorld().getHeight()-h) {
                if(Greenfoot.isKeyDown("up")) {
                    setLocation(getX(), getY()-dy);
                }
            } 
        }
        
        count++;
    }
}
