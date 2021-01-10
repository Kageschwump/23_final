package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;

import java.awt.*;

public class PropertySquare extends GameSquare {
    private int id;
    private int price;
    private String description;
    private boolean owned;
    private Player owner = null;
    private String name;
    private int rent;


    private Color color1;
    private Color color2;
    private GUI_Ownable fieldType;

    public PropertySquare(String name, int price, int rent, String description, Color color1, Color color2) {
        this.name = name;
        this.price = price;
        String priceString = Integer.toString(price, rent);
        this.description = description;
        this.color1 = color1;
        this.color2 = color2;

        fieldType = new GUI_Street(name, priceString, description, priceString, color1, color2);
    }

    //Lav Player-klassen, og find ud af hvilken color der skal bruges i getColor super-klassen//

    @Override
    public void function(Player player) {
        if (propertySquareNotOwned()) {
            owner = player;
            player.getAccount().updateScore(-price);
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            fieldType.setOwnableLabel(player.getName());
            fieldType.setBorder(player.getGuiPlayer().getPrimaryColor());
        } else if (player != owner) {
            player.getAccount().updateScore(-price);
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            owner.getAccount().updateScore(price);
            owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
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
        return color2;
    }

}



