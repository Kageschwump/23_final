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


    @Override
    public void function(Player player, GUIHandler guiHandler) {
        fieldType.setCar(player.getGuiPlayer(),true);
        String selection;
        if (propertySquareNotOwned() && player.getAccount().getBalance() > price) {
            selection = guiHandler.getGui().getUserSelection("Vil du købe " + getName() + "?", "Ja", "Nej");
                switch (selection){
                case ("Ja"):
                    owner = player;
                    player.getAccount().addProperty(name,bgColor);
                    player.getAccount().updateScore(-price);
                    player.getGuiPlayer().setBalance(player.getAccount().getBalance());
                    checkPairs(player);
                    fieldType.setOwnableLabel(player.getName());
                    fieldType.setBorder(player.getGuiPlayer().getPrimaryColor());
                    break;
                case ("Nej"):
                    break;
            }
        } else if (player != owner && owner != null) {
            player.getAccount().updateScore(-rent[houses]);
            player.getGuiPlayer().setBalance(player.getAccount().getBalance());
            owner.getAccount().updateScore(rent[houses]);
            owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
        } else if(checkPairs(player) && houses != 5 && player.getAccount().getBalance() > housePrise)
        {
            selection = guiHandler.getGui().getUserSelection("Vil du købe et hus på " + getName() + "?" + housePrise + " kr", "Ja", "Nej");
            switch (selection){
                case ("Ja"):
                    purchaseHouse(guiHandler);
                    break;
                case ("Nej"):
                    break;
            }
        }
        else{
            guiHandler.printMessage("Du har ikke nok penge til at købe denne ejendom");
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
            owner.getAccount().addHouse(1);
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

            if(otherProperties[i][1] == null){
                break;
            } else if (otherProperties[i][1].equals(bgColor.toString()))
            {
                numOfPairs++;
            }
        }
        if(!bgColor.toString().equals(Color.magenta.toString()) && !bgColor.toString().equals(Color.blue.toString()))
        {

            if (numOfPairs == 3) {
                rent[0] = rent[0] * 2;
                return true;
            } else return false;
        }else {
                if (numOfPairs == 2) {
                    rent[0] = rent[0] * 2;
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

    @Override
    public void removeOwner() {
        owner.getAccount().updateScore(price/2);
        owner.getAccount().updateScore((getHouses()*housePrise)/2);
        owner.getGuiPlayer().setBalance(owner.getAccount().getBalance());
        owner = null;
        houses = 0;
        fieldType.setHouses(houses);
        fieldType.setBorder(null);
    }

    public int getHouses()
    {
        return houses;
    }

    public int[] getRent()
    {
        return rent;
    }

    public int getHousePrise(){
        return housePrise;
    }
}



