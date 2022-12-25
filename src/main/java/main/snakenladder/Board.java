package main.snakenladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer, Integer>> positionCoordinates;

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
                yPos = y*Snakenladder.tileSize-Snakenladder.tileSize/2;
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
        return positionCoordinates.get(position).getKey();
    }
    public static void main(String[] args) {
        Board board = new Board();
        board.populatePositionCoordinates();
        for (int i = 0; i< board.positionCoordinates.size(); i++){
            System.out.println(i+ " # x:"+ board.positionCoordinates.get(i).getKey()+" y:"+
            board.positionCoordinates.get(i).getKey());
        }
    }
}
