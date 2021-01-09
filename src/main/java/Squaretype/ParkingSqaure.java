package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Refuge;

import java.awt.*;

public class ParkingSqaure extends GameSquare {

    private String name = "Gratis Parkering";
    private String description = "Parker her og tag en pause";
    private Color bgColor = Color.WHITE;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;

    public void ParkingSquare()
    {
        fieldType = new GUI_Refuge("default",name,"Parkering",description,bgColor,fgColor);
    }

    @Override
    public void function(Player player)
    {

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
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
