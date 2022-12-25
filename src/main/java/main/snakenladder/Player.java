package main.snakenladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {
    private Circle coin;
     private String name;
     private int coinPosition;
     Board gameBoard = new Board();

     public Player(int titleSize, Color coinColor, String playerName){
         coinPosition =1;
         name = playerName;
         coin = new Circle(titleSize/2);
     }
     public void movePlayer(int diceValue){
         if(coinPosition + diceValue <=100){
             coinPosition+= diceValue;
             coin.setTranslateX(gameBoard.getXCoordinate(coinPosition));
             coin.setTranslateY(gameBoard.getYCoordinate(coinPosition));
         }
     }


}
