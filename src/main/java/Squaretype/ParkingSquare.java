package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Refuge;

import javax.print.attribute.standard.PresentationDirection;
import java.awt.*;

public class ParkingSquare extends GameSquare {

    private String name = "Gratis Parkering";
    private String description = "Parker her og tag en pause";
    private Color bgColor = Color.WHITE;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;

    public ParkingSquare()
    {
        fieldType = new GUI_Refuge("default",name,"Parkering",description,bgColor,fgColor);
    }

    @Override
    public String function(Player player)
    {
        return "ParkingSquare";
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
}
