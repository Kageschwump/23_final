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

    public void removePlayer(Player player){

        player.setPlayerLost();
        player.setPlacement(60);
    }



}
