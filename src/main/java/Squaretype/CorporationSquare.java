package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;

import java.awt.*;

public class CorporationSquare extends GameSquare {

    private String name = "Virksomhed";
    private String description = "Snup en sodavand!";
    private Color bgColor = Color.orange;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;

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
