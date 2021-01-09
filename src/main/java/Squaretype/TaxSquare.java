package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;

import java.awt.*;

public class TaxSquare extends GameSquare {
    private String name = "Skat";
    private String description = "Husk at betale skat!";
    private Color bgColor = Color.white;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;

    public void Taxsquare()
    {

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
