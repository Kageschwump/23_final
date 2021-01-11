package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class MoveCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private Color bgColor;
    private Color fgColor;
    private boolean moveToAdress;
    private int placement;
    private GUI_Chance guiChance;

    public MoveCard(String title, String subText, String description,boolean moveToAdress, int placement)
    {
        this.guiChance = new GUI_Chance(title,subText,description,bgColor,fgColor);
        this.title = title;
        this.subText = subText;
        this.description = description;
        this.moveToAdress = moveToAdress;
        this.placement = placement;
    }

    @Override
    public void cardFunction(Player player) {

        int addedPlacement;

        if(moveToAdress)
        {

            if(player.getPlacement() > placement)
            {
                addedPlacement = (40 - player.getPlacement()) + placement;
                player.updatePlacement(addedPlacement);
            } else
            {
                addedPlacement = placement - player.getPlacement();
                player.updatePlacement(addedPlacement);
            }

        } else
            {
                player.updatePlacement(placement);
            }
    }

    @Override
    public String getDesc() {
        return null;
    }
}
