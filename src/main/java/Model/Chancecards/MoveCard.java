package Model.Chancecards;

import Model.ChanceCard;
import Model.Player;

public class MoveCard extends ChanceCard {

    private String title;
    private String subText;
    private String description;
    private boolean moveToAdress;
    private int placement;

    public MoveCard(String title, String subText, String description,boolean moveToAdress, int placement)
    {
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
            } else
            {
                addedPlacement = placement - player.getPlacement();
            }
            player.updatePlacement(addedPlacement);

            if(player.getPlacement() == -1){
                player.setPlacement(39);
            }

        } else
            {
                player.updatePlacement(placement);
                if(player.getPlacement() == -1){
                    player.setPlacement(39);
                }
            }
    }

    @Override
    public String getDesc() {
        return description;
    }
}
