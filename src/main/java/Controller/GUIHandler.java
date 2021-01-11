package Controller;

import Model.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class GUIHandler {
    private GUI gui;

    public GUIHandler(GUI_Field[] guiFields)
    {
        this.gui = new GUI(guiFields, Color.LIGHT_GRAY);
    }

    public void guiAddPlayer(GUI_Player player)
    {
        gui.addPlayer(player);
    }

    public int playerCount()
    {
        return gui.getUserInteger("Hvor mange spillere?",3,6);
    }

    public String playerString(String msg)
    {
        return gui.getUserString(msg);
    }

    public int playerInt(String msg)
    {
        return gui.getUserInteger(msg);
    }

    public void printMessage(String message){
        gui.showMessage(message);
    }

    public GUI_Car guiCreateCar()
    {
        String primaryColorString;
        Color primaryColor;
        String typeString;
        GUI_Car.Type type;

        primaryColorString = gui.getUserSelection("Hvilken farve?", "Sort","Blå","Rød","Grå","Grøn","Gul");
        switch (primaryColorString)
        {
            case ("Sort"):
                primaryColor = Color.BLACK;
                break;
            case("Blå"):
                primaryColor = Color.BLUE;
                break;
            case("Rød"):
                primaryColor = Color.RED;
                break;
            case("Grå"):
                primaryColor = Color.GRAY;
                break;
            case("Grøn"):
                primaryColor = Color.GREEN;
                break;
            case("Gul"):
                primaryColor = Color.YELLOW;
                break;


            default: primaryColor = Color.BLACK;;
        }

        typeString = gui.getUserSelection("Hvilken type bil?", "Bil","Traktor","Racerbil","UFO");
        switch(typeString){
            case("Bil"):
                type = GUI_Car.Type.CAR;
                break;
            case("Traktor"):
                type = GUI_Car.Type.TRACTOR;
                break;
            case("Racerbil"):
                type = GUI_Car.Type.RACECAR;
                break;
            case("UFO"):
                type = GUI_Car.Type.UFO;
                break;

            default: type = GUI_Car.Type.CAR;
        }

        GUI_Car gui_car = new GUI_Car(primaryColor,Color.BLACK,type, GUI_Car.Pattern.FILL);
        return gui_car;
    }

    public void playerRoll(String playername){
        gui.getUserButtonPressed("Din tur " + playername + "!", "Rul");
    }

    public void getRoll(int faceValue1, int faceValue2){
        gui.setDice(faceValue1, faceValue2);
    }

    public void resetCars(Player player, Player[] players, GUI_Field gui_field)
    {
        gui_field.removeAllCars();

        for (int i = 0; i < players.length; i++)
        {
            if (!player.getName().equals(players[i].getName()))
            {
                if(player.getPlacement() == players[i].getPlacement())
                {
                    gui_field.setCar(players[i].getGuiPlayer(),true);
                }
            }
        }

    }



}

