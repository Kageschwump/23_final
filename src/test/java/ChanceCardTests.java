import Controller.ChancecardHandler;
import Model.ChanceCard;
import Model.Player;
import org.junit.Assert;
import org.junit.Test;

public class ChanceCardTests
{
    ChancecardHandler chancecardHandler =  new ChancecardHandler();

    @Test
    public void payCardFunktionTest()
    {
        Player player1 = new Player(1,"HC",22,null,3000);
        Player player2 = new Player(2,"Jan",22,null,3000);
        boolean condition = false;

        ChanceCard chanceCard = chancecardHandler.getCards()[9];

        chancecardHandler.getCards()[9].cardFunction(player1);
        chanceCard.cardFunction(player2);

        if(player2.getAccount().getBalance() == 2000 && player1.getAccount().getBalance() == 2000)
        {
            condition = true;
        }

        Assert.assertTrue(condition);
    }

    @Test
    public void priceCardFunktionTest()
    {
        Player player = new Player(1,"HC",22,null,3501);
        boolean condition = false;
        player.getAccount().addHouse(3);
        player.getAccount().addHotel();

        ChanceCard chanceCard = chancecardHandler.getCards()[0];

        chanceCard.cardFunction(player);

        if(player.getAccount().getBalance() == 1)
        {
            condition = true;
        }

        Assert.assertTrue(condition);
    }
}
