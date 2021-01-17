package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;

public class PayCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private int price;

    public PayCard(String title, String subText, String description, int price)
    {
        this.title = title;
        this.subText = subText;
        this.description = description;
        this.price = price;
    }

    @Override
    public void cardFunction(Player player) {
        player.getAccount().updateScore(price);
        player.getGuiPlayer().setBalance(player.getAccount().getBalance());
    }

    @Override
    public String getDesc() {
        return description;
    }
}
