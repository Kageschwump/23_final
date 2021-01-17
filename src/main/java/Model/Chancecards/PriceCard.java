package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;

public class PriceCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private int pricePrHouse;
    private int pricePrHotel;

    public PriceCard(String title, String subText, String description, int pricePrHouse, int pricePrHotel)
    {
        this.title = title;
        this.subText = subText;
        this.description = description;
        this.pricePrHouse = pricePrHouse;
        this.pricePrHotel = pricePrHotel;
    }

    @Override
    public void cardFunction(Player player) {
        int value;
        value = (pricePrHouse * player.getAccount().numOfHouses()) + (pricePrHotel * player.getAccount().numOfHotels());
        player.getAccount().updateScore(-value);
        player.getGuiPlayer().setBalance(player.getAccount().getBalance());
    }

    @Override
    public String getDesc() {
        return description;
    }
}
