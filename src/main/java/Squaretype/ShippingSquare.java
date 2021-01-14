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
    private String description = "bare kom du!";
    private int rent;
    private int price;
    private boolean owned;
    private Player owner;
    private Color bgColor = Color.pink;
    private Color fgColor = Color.black;
    private GUI_Shipping fieldType;

    public ShippingSquare(String name, int rent, int price){
        fieldType = new GUI_Shipping( "default", name ,"",description, Integer.toString(rent),bgColor,fgColor);
        this.name = name;
        this.rent = rent;
        this.price = price;
    }

    @Override
    public void function(Player player, GUIHandler guiHandler) {
        fieldType.setCar(player.getGuiPlayer(),true);

        String selection;
        if (propertySquareNotOwned()) {
            selection = guiHandler.getGui().getUserSelection("vil du købe denne ejendom?", "ja", "nej");
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
            player.getAccount().updateScore(-rent);
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            owner.getAccount().updateScore(rent);
            owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
        }
    }

    public void priceForLanding(Player player)
    {
        int givenPrice;
        int numOfShipping = player.getAccount().getShippingProp().length;
        switch (Integer.toString(numOfShipping))
        {
            case "1":
                player.getAccount().updateScore(-500);
                owner.getAccount().updateScore(+500);
                player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                owner.getGuiPlayer().setBalance(player.getAccount().getBalance());
                break;
            case "2":
                player.getAccount().updateScore(-1000);
                owner.getAccount().updateScore(+1000);
                player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                owner.getGuiPlayer().setBalance(player.getAccount().getBalance());
                break;
            case "3":
                player.getAccount().updateScore(-2000);
                owner.getAccount().updateScore(+2000);
                player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                owner.getGuiPlayer().setBalance(player.getAccount().getBalance());
                break;
            case "4":
                player.getAccount().updateScore(-4000);
                owner.getAccount().updateScore(+4000);
                player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                owner.getGuiPlayer().setBalance(player.getAccount().getBalance());
                break;
        }
    }

    public boolean propertySquareNotOwned() {
        if (owner == null) {
            return true;
        } else
            return false;
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
}
