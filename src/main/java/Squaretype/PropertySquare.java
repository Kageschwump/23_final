package Squaretype;

import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;

import java.awt.*;

public class PropertySquare extends GameSquare {
    private int price;
    private String description;
    private boolean owned;
    private Player owner;
    private String name;
    private int rent;
    private Color bgColor;
    private Color fgColor;
    private GUI_Ownable fieldType;
    private int houses;
    private boolean hotel;


    public PropertySquare(String name, int price, int rent, String description, Color bgColor, Color fgColor) {
        this.name = name;
        this.price = price;
        String priceString = Integer.toString(price, rent);
        this.description = description;
        this.bgColor = bgColor;
        this.fgColor = fgColor;

        fieldType = new GUI_Street(name, priceString, description, priceString, bgColor, fgColor);
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
        return fgColor;
    }


    public int getHouses() {
        return houses;
    }

    public boolean isHotel() {
        return hotel;
    }


}



