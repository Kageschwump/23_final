package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Tax;

import java.awt.*;

public class ShippingSquare extends GameSquare {
    private String name = "";
    private String description = "bare kom du!";
    private Color bgColor = Color.pink;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;

    public ShippingSquare(String name, String rent){
        fieldType = new GUI_Shipping( "default", name ,"",description, rent,bgColor,fgColor);
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
        return null;
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
