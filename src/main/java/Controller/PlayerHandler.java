package Controller;

import Model.Player;

public class PlayerHandler {

    private Player[] players;

    public PlayerHandler(int amountOfPlayers){
        players = new Player[amountOfPlayers];
    }

    public Player readPlayerByName(String name){
        Player givenPlayer = null;

        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getName().equals(name))
            {
                givenPlayer = players[i];
            }
        }
        return givenPlayer;
    }


}
