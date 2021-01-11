package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;
import gui_fields.GUI_Chance;

import java.awt.*;

public class PriceCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private Color bgColor;
    private Color fgColor;
    private GUI_Chance guiChance;
    private int pricePrHouse;
    private int pricePrHotel;

    public PriceCard(String title, String subText, String description, int pricePrHouse, int pricePrHotel)
    {
        this.guiChance = new GUI_Chance(title,subText,description,bgColor,fgColor);
        this.title = title;
        this.subText = subText;
        this.description = description;
        this.pricePrHouse = pricePrHouse;
        this.pricePrHotel = pricePrHotel;
    }

    @Override
    public void cardFunction(Player player) {
        int numOfHouses = 0;
        int numOfHotels = 0;
        int value;

        for (int i = 0; i < player.getAccount().getProperties().length; i++)
        {
            numOfHouses += player.getAccount().getProperties()[i].getHouses();

            if(player.getAccount().getProperties()[i].isHotel())
            {
                numOfHotels++;
            }
        }

        value = (pricePrHouse * numOfHouses) + (pricePrHotel * numOfHotels);
        player.getAccount().updateScore((-1) * value);
    }

    @Override
    public String getDesc() {
        return null;
    }
}
