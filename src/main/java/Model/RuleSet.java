package Model;

import Controller.ChancecardHandler;
import Controller.GUIHandler;

public class RuleSet {

    GUIHandler guiHandler;

    public RuleSet(GUIHandler guiHandler){
        this.guiHandler = guiHandler;
    }

    public boolean gameOver(Player[] players)
    {
        boolean gameEnd = false;
        int numOfPlayersLost = 0;

        for(int i = 0; i < players.length; i++)
        {
            if(players[i].getPlayerLost())
            {
                numOfPlayersLost++;
            }
        }
        if(numOfPlayersLost == players.length - 1)
        {
            gameEnd = true;
        }
        return gameEnd;
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

    public void prisonEscape(Player player, String userInput, int facevalue1, int facevalue2)
    {
        int[] faceValues = new int[2];
        switch (userInput)
        {
            case "Terninger":
                if(facevalue1==facevalue2)
                {
                    guiHandler.playerRoll(player.getName());
                    guiHandler.getRoll(facevalue1, facevalue2);
                    player.setPrison(false);
                    faceValues[0] = facevalue1;
                    faceValues[1] = facevalue2;
                    guiHandler.printMessage("Tilykke du er ude af fængslet");

                } else
                    {
                        guiHandler.playerRoll(player.getName());
                        guiHandler.getRoll(facevalue1, facevalue2);
                        guiHandler.printMessage("Surt show, vent til næste runde");
                    }
                break;
            case "Betal":
                player.getAccount().updateScore(-1000);
                player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                player.setPrison(false);
                guiHandler.printMessage("Du har betalt dig ud af fænslet");
                break;
        }
    }

    public Player determineWinner(Player[] players)
    {
        Player winner = null;
        for (int i = 0; i < players.length; i++)
        {
            if(!players[i].getPlayerLost())
            {
                winner = players[i];
            }
        }
        return winner;
    }

}
