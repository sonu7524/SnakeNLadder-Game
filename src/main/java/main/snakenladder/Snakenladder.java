package main.snakenladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Snakenladder extends Application {

    public static final int tileSize=60, height=10, width = 10;
    int lowerLine = tileSize*height;
    private int diceValue;

    boolean firstPlayerTurn = true, secondPlayerTurn = false, gameStarted = false;
    Button startGameButton;


    Player firstPlayer = new Player(tileSize-10, Color.GREEN,"Sonu");
    Player secondPlayer = new Player(tileSize-20, Color.BLUE,"Rahul");
    Label rolledDiceValueLabel;

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+100);
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
        playerOneButton.setTranslateX(120);
        playerOneButton.setTranslateY(lowerLine+20);

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(gameStarted){
                    if(firstPlayerTurn){
                        setDiceValue();
                        firstPlayer.movePlayer(diceValue);
                        if(firstPlayer.playerWon() != null){
                            rolledDiceValueLabel.setText(firstPlayer.playerWon());
                        }
                        firstPlayerTurn = false;
                        secondPlayerTurn = true;
                    }
                }
            }
        });

        Button playerTwoButton = new Button("Player-2");
        playerTwoButton.setTranslateX(420);
        playerTwoButton.setTranslateY(lowerLine+20);

        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(secondPlayerTurn){
                        setDiceValue();
                        secondPlayer.movePlayer(diceValue);
                        if(secondPlayer.playerWon() != null){
                            rolledDiceValueLabel.setText(secondPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                        }
                        firstPlayerTurn = true;
                        secondPlayerTurn = false;
                    }
                }

            }
        });

        startGameButton = new Button("Start");
        startGameButton.setTranslateX(285);
        startGameButton.setTranslateY(660);
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted = true;
                rolledDiceValueLabel.setText("Game Begin");
            }
        });


        rolledDiceValueLabel = new Label("To Start The Game \n Press Start Button");
        rolledDiceValueLabel.setTranslateX(270);
        rolledDiceValueLabel.setTranslateY(620);
        root.getChildren().addAll(boardImage, playerTwoButton,playerOneButton,
                firstPlayer.getCoin(),secondPlayer.getCoin(),rolledDiceValueLabel, startGameButton);
        return root;
    }
    private void setDiceValue(){
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