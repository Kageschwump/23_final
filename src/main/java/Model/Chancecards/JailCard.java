package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;

import java.awt.*;

public class JailCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private Color bgColor;
    private Color fgColor;

    @Override
    public void cardFunction(Player player) {


    }

    @Override
    public String getDesc() {
       return description;
    }
}
