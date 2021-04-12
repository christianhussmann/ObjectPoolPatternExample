package sample;

import javafx.scene.image.Image;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class RockPool {
    private List<Rock> rocks = new CopyOnWriteArrayList();
    private Deque<Rock> released = new ArrayDeque();
    

    private static RockPool instance;

    public static RockPool getInstance(){
        if(instance==null)
            instance = new RockPool();
        return instance;
    }

    private RockPool(){

    }

    public List<Rock> getRocks(){
        return rocks;
    }


    public void release(Rock rock){
        rocks.remove(rock);
        released.add(rock);
    }


    public void createRock(double x, double y, double speed, double direction, String imagePath, int imageH, int imageW){
        Rock rock;
        if(released.isEmpty()){
            Image imgRock = new Image(imagePath, imageH, imageW, true, true);
            rock = new Rock(x,y,imgRock,speed,direction);
        }
        else {
            rock = released.poll();
            rock.setDirection(direction);
            rock.setSpeed(speed);
            rock.setX(x);
            rock.setY(y);
            //rock.setImg(imgRock);
        }
        rocks.add(rock);
    }
}
