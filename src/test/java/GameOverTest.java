import Controller.PlayerHandler;
import Model.Player;
import Model.RuleSet;
import org.junit.Assert;
import org.junit.Test;

public class GameOverTest
{
    @Test
    public void determineWinnerTest()
    {
        Player player = new Player(1,"HC",22,null,300);
        Player player1 = new Player(2,"Jan",22,null,300);
        RuleSet ruleSet = new RuleSet(null);
        PlayerHandler playerHandler = new PlayerHandler(2);
        playerHandler.getPlayers()[0] = player;
        playerHandler.getPlayers()[1] = player1;

        playerHandler.removePlayer(player);

        Assert.assertEquals("Jan",ruleSet.determineWinner(playerHandler.getPlayers()).getName());
    }
}
