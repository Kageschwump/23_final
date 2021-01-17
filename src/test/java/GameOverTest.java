import Controller.PlayerHandler;
import Model.Player;
import org.junit.Assert;
import org.junit.Test;

public class GameOverTest
{
    @Test
    public void deletePlayer()
    {
        Player player = new Player(1,"HC",22,null,300);
        Player player1 = new Player(2,"Jan",22,null,300);

        PlayerHandler playerHandler = new PlayerHandler(2);
        playerHandler.getPlayers()[0] = player;
        playerHandler.getPlayers()[1] = player1;

        playerHandler.removePlayer(player);

        Assert.assertEquals(1,playerHandler.getPlayers().length);
        Assert.assertEquals("Jan",playerHandler.getPlayers()[0].getName());
    }
}
