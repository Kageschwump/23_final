package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class TransactionCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private Color bgColor;
    private Color fgColor;
    private GUI_Chance guiChance;

    public TransactionCard(String title, String subText, String description, int price)
    {
        this.guiChance = new GUI_Chance(title,subText,description,bgColor,fgColor);
        this.title = title;
        this.subText = subText;
        this.description = description;
    }

    @Override
    public void cardFunction(Player player) {


    }

    @Override
    public String getDesc() {
        return null;
    }
}
