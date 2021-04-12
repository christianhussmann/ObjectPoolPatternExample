package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane mainPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Canvas canvas = new Canvas(960, 539);
        mainPane.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image imgBg = new Image("bg.jpg");

        Random rand = new Random();


        AnimationTimer t = new AnimationTimer() { //  run 60 times pr. sec.
            @Override
            public void handle(long l) {
                RockPool.getInstance().createRock(rand.nextInt((int)canvas.getWidth()), 0, 5, Math.PI/2,"rock.jpg" ,25, 25);
                gc.drawImage(imgBg, 0, 0); //clear screen.
                for (Rock rock : RockPool.getInstance().getRocks()) {
                    rock.move();
                    gc.drawImage(rock.getImg(), rock.getX(), rock.getY());
                    if(rock.getX()<0 || rock.getX()>canvas.getWidth()||
                            rock.getY()<0 || rock.getY()>canvas.getHeight())
                    {
                        RockPool.getInstance().release(rock);
                    }
                }
            }
        };
        t.start();
    }


}
