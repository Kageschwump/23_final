package Squaretype;

import Controller.GUIHandler;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

import java.awt.*;

public class PropertySquare extends GameSquare {

    private String description;
    private Player owner;
    private String name;
    private int price;
    private int[] rent;
    private Color bgColor;
    private Color fgColor;
    private GUI_Street fieldType;
    private int housePrise;
    private int houses;



    public PropertySquare(String name, int price, int rent, String description, Color bgColor, Color fgColor,int housePrises, int rentHouse1, int rentHouse2, int rentHouse3, int rentHouse4, int rentHotel)
    {
        this.name = name;
        this.price = price;
        String priceString = Integer.toString(price, rent);
        this.description = description;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.housePrise = housePrises;
        this.rent = new int[]{rent, rentHouse1, rentHouse2, rentHouse3, rentHouse4, rentHotel};
        houses = 0;

        fieldType = new GUI_Street(name, priceString, description, priceString, bgColor, fgColor);
    }

    //Lav Player-klassen, og find ud af hvilken color der skal bruges i getColor super-klassen//

    @Override
    public void function(Player player, GUIHandler guiHandler) {
        fieldType.setCar(player.getGuiPlayer(),true);

        String selection;
        if (propertySquareNotOwned() && player.getAccount().getBalance() > price) {
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
        } else if(propertySquareNotOwned() && player.getAccount().getBalance()< price){
            guiHandler.printMessage("du har ikke nok penge til at købe " + name);
        } else if (player != owner) {
            player.getAccount().updateScore(-rent[houses]);
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            owner.getAccount().updateScore(rent[houses]);
            owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
        } else if(checkPairs(player) && houses != 5)
        {
            selection = guiHandler.getGui().getUserSelection("vil du købe et hus? " + housePrise + " kr", "ja", "nej");
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
            houses++;
            fieldType.setHouses(houses);
            owner.getAccount().updateScore(-1 * housePrise);
            owner.getAccount().addHouse();
            guiHandler.printMessage("Du har nu købt et hus");
        } else {
            fieldType.setHotel(true);
            owner.getAccount().updateScore(-1 * housePrise);
            owner.getAccount().addHotel();
            guiHandler.printMessage("Du har nu et hotel");
        }

    }

    public boolean checkPairs(Player player)
    {
        String[][] otherProperties = player.getAccount().getProperties();
        int numOfPairs = 0;

        for (int i = 0; i < otherProperties.length; i++) {
            if(otherProperties[i][1] == null)
            {
                break;
            } else if (otherProperties[i][1].equals(bgColor.toString())) {
                numOfPairs++;
            }
        }

        if(!bgColor.equals(Color.magenta)||!bgColor.equals(Color.blue))
        {

            if (numOfPairs >= 3) {
                rent[0] *= 2;
                return true;

            } else return false;
        }else
            {
                if (numOfPairs >= 2) {
                    rent[0] *= 2;
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

    public int[] getRent()
    {
        return rent;
    }
}



