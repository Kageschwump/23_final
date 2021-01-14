package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class PayCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private Color bgColor;
    private Color fgColor;
    private GUI_Chance guiChance;
    private int price;

    public PayCard(String title, String subText, String description, int price)
    {
        this.guiChance = new GUI_Chance(title,subText,description,bgColor,fgColor);
        this.title = title;
        this.subText = subText;
        this.description = description;
        this.price = price;
    }

    @Override
    public void cardFunction(Player player) {
        player.getAccount().updateScore(price);
    }

    @Override
    public String getDesc() {
        return description;
    }
}
