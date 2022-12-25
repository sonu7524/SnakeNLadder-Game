package main.snakenladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class Snakenladder extends Application {

    public static final int tileSize=60, height=10, width = 10;
    int lowerLine = tileSize*height;
    private int diceValue;

    Label rolledDiceValueLabel;

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+60);
        for(int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                Tile tile = new Tile(tileSize);
                tile.setTranslateX((j*tileSize));
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }
        }
        // root.getChildren().add(new Tile(tileSize));
        Image img = new Image("E:\\Project\\SnakeNLadder\\src\\main\\Snake&Ladder.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitHeight(tileSize*height);
        boardImage.setFitWidth(tileSize*width);


        Button playerOneButton = new Button("Player-1");
        playerOneButton.setTranslateX(100);
        playerOneButton.setTranslateY(lowerLine+20);
        Button playerTwoButton = new Button("Player-2");
        playerTwoButton.setTranslateX(450);
        playerTwoButton.setTranslateY(lowerLine+20);
        root.getChildren().addAll(boardImage, playerTwoButton,playerOneButton);
        return root;
    }
    void setDiceValue(){
        diceValue = (int) (Math.random()*6+1);
        rolledDiceValueLabel.setText("Dice Value : "+ diceValue);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}