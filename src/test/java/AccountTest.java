import Model.Player;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class AccountTest
{
    @Test
    public void propArrayTest()
    {
        Player player1 = new Player(1,"HC",22,null,3000);
        Color propColor = Color.black;
        String propName = "Lyse Stagen";

        player1.getAccount().addProperty(propName,propColor);
        String[] dude = new String[1];

        Assert.assertEquals("black", player1.getAccount().getProperties()[0][1]);
    }
}
