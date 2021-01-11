package Squaretype;

import Model.ChanceCard;
import Model.Chancecards.JailCard;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;

import java.awt.*;

public class ChanceCardSquare extends GameSquare {

    private String name = "?";
    private String subText = "Chancen";
    private String description = "Prøv lykken, tag et kort";
    private Color bgColor = Color.orange;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;
    private ChanceCard[] chanceCards = new ChanceCard[46];

    public ChanceCardSquare()
    {

    }

    public void createChanceCards()
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
