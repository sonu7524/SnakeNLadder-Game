package main.snakenladder;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import static javafx.scene.paint.Color.*;

public class Tile extends Rectangle {


    public Tile(int titleSize){
        setWidth(titleSize);
        setHeight(titleSize);
        setFill(RED);
        setStroke(BLACK);
    }
}