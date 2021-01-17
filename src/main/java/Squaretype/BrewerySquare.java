package Squaretype;

import Controller.GUIHandler;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Shipping;

import java.awt.*;

public class BrewerySquare extends GameSquare {
    private String name;
    private String description = "Snup en sodavand!";
    private int rent;
    private int price;
    private Player owner;
    private Color bgColor = Color.pink;
    private Color fgColor = Color.black;
    private GUI_Brewery fieldType;

    public BrewerySquare(String name, int rent, int price){
        fieldType = new GUI_Brewery( "default", name ,"",description, Integer.toString(rent),bgColor,fgColor);
        this.name = name;
        this.rent = rent;
        this.price = price;
    }

    @Override
    public void function(Player player, GUIHandler guiHandler) {
        fieldType.setCar(player.getGuiPlayer(),true);

        String selection;
        if (propertySquareNotOwned() && player.getAccount().getBalance() > price) {
            selection = guiHandler.getGui().getUserSelection("vil du købe "+ name +"?", "ja", "nej");
            switch (selection){
                case ("ja"):
                    owner = player;
                    player.getAccount().addBrewery(name);
                    player.getAccount().updateScore(-price);
                    player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                    fieldType.setOwnableLabel(player.getName());
                    fieldType.setBorder(player.getGuiPlayer().getPrimaryColor());
                    break;
                case ("nej"):
                    break;
            }
        } else if (player != owner) {
            player.getAccount().updateScore(-1 * priceForLanding(player.getLastRoll()));
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            owner.getAccount().updateScore(priceForLanding(player.getLastRoll()));
            owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
        }
    }

    public boolean propertySquareNotOwned() {
        if (owner == null) {
            return true;
        } else
            return false;
    }

    public int priceForLanding(int diceEyes)
    {
        int priceToPay = 0;
        int numOfBrewery = 0;

        for(int i = 0; i < owner.getAccount().getBreweryProp().length; i++)
        {
            if(owner.getAccount().getBreweryProp()[i] != null)
            {
                numOfBrewery++;
            }
        }
        switch (numOfBrewery)
        {
            case 1:
                priceToPay = diceEyes * 100;
                break;
            case 2:
                priceToPay= diceEyes * 200;
                break;
        }
        return priceToPay;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public GUI_Field getGuiField() {
        return fieldType;
    }

    @Override
    public String getDesc() {
        return description;
    }

    @Override
    public Color getColor() {
        return bgColor;
    }

    public void removeOwner()
    {
        owner.getAccount().updateScore(price/2);
        owner = null;
    }

    public void setOwner(Player player)
    {
        owner = player;
    }
}
