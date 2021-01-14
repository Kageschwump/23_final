package Squaretype;

import Controller.GUIHandler;
import Model.ChanceCard;
import Model.Chancecards.*;
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

    public ChanceCardSquare()
    {
        fieldType = new GUI_Chance(name, subText, description, bgColor, fgColor);
    }

    @Override
    public void function(Player player, GUIHandler guiHandler) {
        if(super.getChancecardHandler().getCards() == null)
        {
            super.getChancecardHandler().createCards();
        }
        fieldType.setCar(player.getGuiPlayer(),true);

        ChanceCard chanceCard = super.getChancecardHandler().drawCard();
        guiHandler.printMessage(player.getName() + " træk et kort! " + chanceCard.getDesc());
        guiHandler.getGui().setChanceCard(chanceCard.getDesc());
        chanceCard.cardFunction(player);
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
