package Model;

public abstract class ChanceCard {

    private String chance = "Chance kort!";

    public abstract void cardFunction(Player player);

    public abstract String getDesc();

}
