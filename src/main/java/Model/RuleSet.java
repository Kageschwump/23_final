package Model;

import Controller.ChancecardHandler;

public class RuleSet {

    GameBoard gameBoard;
    ChancecardHandler chancecardHandler;

    public RuleSet(GameBoard gameBoard, ChancecardHandler chanceCardHandler){
        this.chancecardHandler = chanceCardHandler;
        this.gameBoard = gameBoard;
    }

    public boolean gameOver()
    {

        return false;
    }

    public int determineStarter(Player[] players)
    {
        int index = 0;
        int min = players[index].getAge();

        for (int i = 1; i < players.length; i++){
            if (players[i].getAge() <= min){
                min = players[i].getAge();
                index = i;
            }
        }
        return index;
    }

}
