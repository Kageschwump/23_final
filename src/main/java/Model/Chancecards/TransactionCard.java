package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;

public class TransactionCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;

    public TransactionCard(String title, String subText, String description, int price)
    {
        this.title = title;
        this.subText = subText;
        this.description = description;
    }

    @Override
    public void cardFunction(Player player) {

    }

    @Override
    public String getDesc() {
        return description;
    }
}
