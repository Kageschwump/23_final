import Model.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest
{
    @Test
    public void testUpdate()
    {
        Player player = new Player(1,"HC",22,null,0);

        int balanceUpdate = 300;

        player.getAccount().updateScore(balanceUpdate);

        System.out.println(player.getAccount().getBalance());
        Assert.assertEquals(balanceUpdate,player.getAccount().getBalance());
    }
}
