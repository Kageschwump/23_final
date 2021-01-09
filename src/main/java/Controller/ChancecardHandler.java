package Controller;

import Model.ChanceCard;
import Model.GameBoard;
import Model.Player;
import Model.RuleSet;

public class ChancecardHandler
{

    private ChanceCard[] cards;
    private GameBoard gameBoard;
    private RuleSet ruleSet;


    public void createCards()
    {

    }

    public void drawCard(Player player)
    {
        int randomCard = (int) (Math.random() * 3);

        cards[randomCard].cardFunction(player);
    }

}
