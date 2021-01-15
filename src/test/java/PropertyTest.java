import Controller.GUIHandler;
import Controller.GameHandler;
import Model.GameBoard;

import Model.Player;
import Squaretype.PropertySquare;
import org.junit.Assert;
import org.junit.Test;
import java.awt.*;

public class PropertyTest
{

    @Test
    public void testRentIfAllPairsOwned()
    {
        GameBoard gameBoard = new GameBoard();

        Player player = new Player(1,"HC",22,null,3000);
        Color color = Color.orange;
        String propName1 = "Roskildevej";
        String propName2 = "Valby Langgade";
        String propName3 = "Allégade";
        PropertySquare propertySquare = (PropertySquare) gameBoard.getSquares()[8];
        int rentBefore = propertySquare.getRent()[0];

        player.getAccount().addProperty(propName1,color);
        player.getAccount().addProperty(propName2,color);
        player.getAccount().addProperty(propName3,color);

        propertySquare.checkPairs(player);

        int rentAfter = propertySquare.getRent()[0];

        Assert.assertEquals(2700,rentAfter);
    }
}
