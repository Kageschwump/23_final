package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Field;
import gui_fields.GUI_Shipping;

import java.awt.*;

public class BrewerySquare extends GameSquare {
    private String name = "Virksomhed";
    private String description = "Snup en sodavand!";
    private Color bgColor = Color.pink;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;

    public BrewerySquare(String name, String rent){
        fieldType = new GUI_Brewery( "default", name ,"",description, rent,bgColor,fgColor);
    }

    @Override
    public void function(Player player) {

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
