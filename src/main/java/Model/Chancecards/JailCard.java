package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;
import gui_fields.GUI_Chance;

public class JailCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private boolean jailfree;
    private GUI_Chance guiChance;

    public JailCard(String title, String subText, String description, boolean jailfree)
    {
        this.title = title;
        this.subText = subText;
        this.description = description;
        this.jailfree = jailfree;
    }

    @Override
    public void cardFunction(Player player) {

        if(jailfree)
        {
            player.getAccount().setJailfree(true);
        } else
            {
                player.setPlacement(10);
                player.setPrison(true);
            }

    }

    @Override
    public String getDesc() {
       return description;
    }

    public GUI_Chance getGuiChance() {
        return guiChance;
    }
}
