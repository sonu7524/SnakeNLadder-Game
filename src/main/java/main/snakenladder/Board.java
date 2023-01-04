package main.snakenladder;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private ArrayList<Pair<Integer, Integer>> positionCoordinates;
    private Map<Integer, Integer> snakeNladder;

    public Board(){
        populatePositionCoordinates();
        populateSnakeLadderPosition();
    }

    private void  populateSnakeLadderPosition(){
        snakeNladder = new HashMap<>();
        //ladder
        snakeNladder.put(6,45);
        snakeNladder.put(20,59);
        snakeNladder.put(52,72);
        snakeNladder.put(57,96);
        snakeNladder.put(71,92);
        snakeNladder.put(2,23);

        //snake
        snakeNladder.put(98,40);
        snakeNladder.put(84,58);
        snakeNladder.put(87,49);
        snakeNladder.put(73,15);
        snakeNladder.put(56,8);
        snakeNladder.put(43,17);
        snakeNladder.put(50,5);
    }
    private void populatePositionCoordinates(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer,Integer>(0,0));
        int x=1, y=10, xPos, yPos;
        for(int i=0; i< Snakenladder.height; i++){
            x=1;
            for(int j=0; j< Snakenladder.width; j++) {
                if (y % 2 == 0){
                    xPos = x * Snakenladder.tileSize - Snakenladder.tileSize / 2;
                }
                else{
                    xPos = Snakenladder.width*Snakenladder.tileSize -(x * Snakenladder.tileSize - Snakenladder.tileSize / 2);
                }
                yPos = (y*Snakenladder.tileSize)-Snakenladder.tileSize/2;
                positionCoordinates.add(new Pair<Integer,Integer>(xPos, yPos));
                x++;
            }
            y--;
        }
    }
    public int getXCoordinate(int position){
        return positionCoordinates.get(position).getKey();
    }
    public int getYCoordinate(int position){
        return positionCoordinates.get(position).getValue();
    }

    public  int  getNextPosition(int position){
        if(position>=1 && position<=100 && snakeNladder.containsKey(position)) {
            return snakeNladder.get(position);
        }
        return -1;
    }
    public static void main(String[] args) {
        Board board = new Board();
        board.populatePositionCoordinates();
        for (int i = 0; i< board.positionCoordinates.size(); i++){
            System.out.println(i+ " # x:"+ board.positionCoordinates.get(i).getKey()+" y:"+
            board.positionCoordinates.get(i).getValue());
        }
    }
}
