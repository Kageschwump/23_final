package Squaretype;

import Controller.GUIHandler;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Tax;

import java.awt.*;

public class ShippingSquare extends GameSquare {
    private String name = "";
    private String description = "Kom bare du!";
    private String subName;
    private int rent;
    private int price;
    private boolean owned;
    private Player owner;
    private Color bgColor = Color.pink;
    private Color fgColor = Color.black;
    private GUI_Shipping fieldType;

    public ShippingSquare(String name, String subName,int rent, int price){
        fieldType = new GUI_Shipping( "default", name ,subName,description, Integer.toString(rent),bgColor,fgColor);
        this.name = name;
        this.rent = rent;
        this.price = price;
    }

    @Override
    public void function(Player player, GUIHandler guiHandler) {
        fieldType.setCar(player.getGuiPlayer(),true);

        String selection;
        if (propertySquareNotOwned() && player.getAccount().getBalance() > price) {
            selection = guiHandler.getGui().getUserSelection("Vil du købe " + name + "?", "ja", "nej");
            switch (selection){
                case ("ja"):
                    owner = player;
                    player.getAccount().addShipping(name);
                    player.getAccount().updateScore(-price);
                    player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                    fieldType.setOwnableLabel(player.getName());
                    fieldType.setBorder(player.getGuiPlayer().getPrimaryColor());
                    break;
                case ("nej"):
                    break;
            }
        } else if (player != owner) {
            player.getAccount().updateScore(-1 * priceForLanding());
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            owner.getAccount().updateScore(priceForLanding());
            owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
        }
    }

    public int priceForLanding()
    {
        int priceToPay = 0;
        int numOfShipping = 0;

        for(int i = 0; i < owner.getAccount().getShippingProp().length; i++)
        {
            if(owner.getAccount().getShippingProp()[i] != null)
            {
                numOfShipping++;
            }
        }

        switch (numOfShipping)
        {
            case 1:
                priceToPay = 500;
                break;
            case 2:
                priceToPay = 1000;
                break;
            case 3:
                priceToPay = 2000;
                break;
            case 4:
                priceToPay = 4000;
                break;
        }
        return priceToPay;
    }

    public boolean propertySquareNotOwned() {
        if (owner == null) {
            return true;
        } else
            return false;
    }

    @Override
    public String getName() {
        return name;
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

    @Override
    public void removeOwner() {
        owner.getAccount().updateScore(price/2);
        owner = null;
    }
    public void setOwner(Player player)
    {
        owner = player;
    }
}
