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
        Player player1 = new Player(2,"Jan",22,null,3000);
        BrewerySquare brewerySquare = (BrewerySquare) gameBoard.getSquares()[12];

        brewerySquare.setOwner(player);
        player1.setLastRoll(7);
        player1.getAccount().updateScore(-brewerySquare.priceForLanding(player1.getLastRoll()));

        Assert.assertEquals(2300,player1.getAccount().getBalance());
    }
}
