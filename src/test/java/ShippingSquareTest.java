import Model.GameBoard;
import Model.GameSquare;
import Model.Player;
import Squaretype.ShippingSquare;
import org.junit.Assert;
import org.junit.Test;

public class ShippingSquareTest
{
    @Test
    public void multipleShippingSquaresRent()
    {
        GameBoard gameBoard = new GameBoard();
        gameBoard.createGameBoard();
        Player player = new Player(1,"HC",22,null,3000);

        String prop1 = "prop1";

        player.getAccount().addShipping(prop1);
        player.getAccount().addShipping(prop1);
        player.getAccount().addShipping(prop1);

        ShippingSquare shipping = (ShippingSquare) gameBoard.getSquares()[5];

        shipping.setOwner(player);

        player.getAccount().updateScore(-1 * shipping.priceForLanding());

        Assert.assertEquals(1000,player.getAccount().getBalance());
    }
}
