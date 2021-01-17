package Squaretype;

import Controller.GUIHandler;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Tax;

import java.awt.*;

public class TaxSquare extends GameSquare {
    private String name = "Skat";
    private String description = "Husk at betale skat!";
    private Color bgColor = Color.white;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;
    private int tax;

    public TaxSquare(String name, int tax)
    {
        fieldType = new GUI_Tax(name,"",description,bgColor,fgColor);
        this.name = name;
        this.tax = tax;
    }

    @Override
    public void function(Player player, GUIHandler guiHandler) {
        fieldType.setCar(player.getGuiPlayer(),true);
        guiHandler.printMessage(description + " Der bliver trukket " + tax + " fra din konto");
        player.getAccount().updateScore(-tax);
        player.getGuiPlayer().setBalance(player.getAccount().getBalance());

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public GUI_Field getGuiField() {
        return fieldType;
    }

    @Override
    public String getDesc() {
        return description;
    }

    @Override
    public Color getColor() {
        return bgColor;
    }

    @Override
    public void removeOwner() {

    }
}
