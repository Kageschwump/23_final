package Model;

import Controller.ChancecardHandler;
import Controller.GUIHandler;

public class RuleSet {

    GameBoard gameBoard;
    ChancecardHandler chancecardHandler;
    GUIHandler guiHandler;
    ShuffleCup shuffleCup;

    public RuleSet(GameBoard gameBoard, ChancecardHandler chanceCardHandler, GUIHandler guiHandler, ShuffleCup shuffleCup){
        this.chancecardHandler = chanceCardHandler;
        this.gameBoard = gameBoard;
        this.guiHandler = guiHandler;
        this.shuffleCup = shuffleCup;
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

    public void prisonEscape(Player player, String userInput)
    {
        switch (userInput)
        {
            case "Terninger":
                    shuffleCup.roll();
                    guiHandler.getGui().getUserSelection(player + "kast med terningerne", "rul");
                    if(shuffleCup.getDice1().getFaceValue() == shuffleCup.getDice2().getFaceValue()){
                        player.setPrison(false);
                        guiHandler.printMessage("tillykke, du slog 2 ens, og er ude af fængslet!");
                        shuffleCup.roll();
                    }
                    else{
                        guiHandler.printMessage("Surt show, du må vente til næste tur");
                    }
                break;
            case "Betal":
                player.getAccount().updateScore(-1000);
                player.setPrison(false);
                guiHandler.printMessage("Du har betalt dig ud a fængslet ");
                break;
        }
    }

}
