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

    public int prisonEscape(Player player, String userInput, int facevalue1, int facevalue2)
    {
        int totalFaceValue = 0;
        switch (userInput)
        {
            case "Terninger":
                if(facevalue1==facevalue2)
                {
                    player.setPrison(false);
                    totalFaceValue = facevalue1+facevalue2;
                }
                break;
            case "Betal":
                player.getAccount().updateScore(-1000);
                player.setPrison(false);
                break;
        }
        return totalFaceValue;
    }

}
