package Squaretype;

import Model.ChanceCard;
import Model.Chancecards.JailCard;
import Controller.ChancecardHandler;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;

import java.awt.*;

public class ChanceCardSquare extends GameSquare {

    private String name = "?";
    private String subText = "Chancen";
    private String description = "Prøv lykken, tag et kort";
    private Color bgColor = Color.orange;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;
    ChancecardHandler chancecardHandler;

    public ChanceCardSquare(ChancecardHandler chanceCardHandler)
    {
        fieldType = new GUI_Chance(name,subText,description,bgColor,fgColor);
        this.chancecardHandler = chanceCardHandler;
    }
    private ChanceCard[] cards;

    public void createCards()
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
