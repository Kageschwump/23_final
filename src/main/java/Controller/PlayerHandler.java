package Controller;

import Model.Player;
import gui_fields.GUI_Car;

public class PlayerHandler {

    private Player[] players;

    public PlayerHandler(int amountOfPlayers){
        players = new Player[amountOfPlayers];
    }

    public Player createPlayer(int id, String name, int age, GUI_Car gui_car, int startBalance){
        return new Player(id,name,age,gui_car,startBalance);
    }

    public Player[] getPlayers() {
        return players;
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

    public void updatePlacement(int newPlacement, Player player){
        player.updatePlacement(newPlacement);
    }

    public void removePlayer(Player player){
        Player[] newPlayerArray = new Player[players.length - 1];
        int counter = 0;
        for(int i = 0; i <= players.length; i++){
            if (!player.getName().equals(players[i].getName())){
                newPlayerArray[counter] = players[i];
                counter++;
            }
        }
        players = newPlayerArray;
    }



}
