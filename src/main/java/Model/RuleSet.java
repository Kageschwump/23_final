package Model;

import Controller.ChancecardHandler;

public class RuleSet {

    GameBoard gameBoard;
    ChancecardHandler chancecardHandler;

    public RuleSet(GameBoard gameBoard, ChancecardHandler chanceCardHandler){
        this.chancecardHandler = chanceCardHandler;
        this.gameBoard = gameBoard;
    }

    public boolean gameOver(Player[] players)
    {
        boolean isGameOver = false;
        for(int i = 0; i < players.length; i++)
        {
            if (players[i].getAccount().getBalance() < 0)
            {
                isGameOver = true;
                break;
            }
        }
        return isGameOver;
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

    public Player determineWinner(Player[] players){
        Player winner = null;
        int max = 0;

        for (int i = 0; i < players.length; i++){
            if (players[i].getAccount().getBalance() > max){
                winner = players[i];
                max = players[i].getAccount().getBalance();
            }
        }
        return winner;
    }
}
