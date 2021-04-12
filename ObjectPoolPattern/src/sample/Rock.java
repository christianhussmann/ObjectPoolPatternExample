package sample;

import javafx.scene.image.Image;

public class Rock {
    private double x;
    private double y;
    private Image img;
    private double speed;
    private double direction; //Radians

    public Rock() {
    }

    public Rock(double x, double y, Image img, double speed, double direction) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.speed = speed;
        this.direction = direction;
    }
    public void move(){
        double difX = Math.cos(direction)*speed;
        double difY = Math.sin(direction)*speed;
        x += difX;
        y += difY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}
