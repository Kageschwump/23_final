import Model.GameBoard;
import Model.Player;
import Squaretype.BrewerySquare;
import org.junit.Assert;
import org.junit.Test;

public class BrewerySquareTest {

    @Test
    public void rentFromDiceEyes()
    {
        GameBoard gameBoard = new GameBoard();
        gameBoard.createGameBoard();

        Player player = new Player(1,"HC",22,null,3000);

        BrewerySquare brewerySquare = (BrewerySquare) gameBoard.getSquares()[12];

        player.getAccount().addBrewery("prop");

        brewerySquare.setOwner(player);
        player.setLastRoll(7);
        player.getAccount().updateScore(-brewerySquare.priceForLanding(player.getLastRoll()));

        Assert.assertEquals(2300,player.getAccount().getBalance());
    }
}
