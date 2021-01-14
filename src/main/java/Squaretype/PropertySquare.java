package Squaretype;

import Controller.GUIHandler;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;
import gui_main.GUI;

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
    private GUI_Street fieldType;
    private int housePrises;
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
    public void function(Player player, GUIHandler guiHandler) {
        fieldType.setCar(player.getGuiPlayer(),true);

        String selection;
        if (propertySquareNotOwned()) {
            selection = guiHandler.getGui().getUserSelection("vil du købe denne ejendom?", "ja", "nej");
            switch (selection){
                case ("ja"):
                    owner = player;
                    player.getAccount().addProperty(name,bgColor);
                    player.getAccount().updateScore(-price);
                    player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                    fieldType.setOwnableLabel(player.getName());
                    fieldType.setBorder(player.getGuiPlayer().getPrimaryColor());
                    break;
                case ("nej"):
                    break;
            }
        } else if (player != owner) {
            player.getAccount().updateScore(-price);
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            owner.getAccount().updateScore(price);
            owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
        } else if(checkPairs(player))
        {
            selection = guiHandler.getGui().getUserSelection("vil du købe et hus på denne ejendom?", "ja", "nej");
            switch (selection){
                case ("ja"):
                    purchaseHouse(guiHandler);
                    break;
                case ("nej"):
                    break;
            }
        }
    }

    public boolean propertySquareNotOwned() {
        if (owner == null) {
            return true;
        } else
            return false;
    }

    public void purchaseHouse(GUIHandler guiHandler)
    {
        if(houses < 5)
        {
            guiHandler.printMessage("Du har nu købt et hus");
            fieldType.setHouses(houses);
        } else {
            hotel = true;
            guiHandler.printMessage("Du har nu et hotel");
            fieldType.setHotel(hotel);
        }
    }

    public boolean checkPairs(Player player)
    {
        String[][] otherProperties = player.getAccount().getProperties();
        int numOfPairs = 0;

        for (int i = 0; i < otherProperties.length; i++) {
            if (otherProperties[i][1].equals(bgColor.toString())) {
                numOfPairs++;
            }
        }

        if(!bgColor.toString().equals("magenta")||!bgColor.toString().equals("blue"))
        {

            if (numOfPairs == 3) {
                return true;
            } else return false;
        }else
            {
                if (numOfPairs == 2) {
                    return true;
                } else return false;
            }
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


    public int getHouses() {
        return houses;
    }

    public boolean isHotel() {
        return hotel;
    }


}



