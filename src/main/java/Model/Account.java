package Model;

import java.awt.*;

public class Account {
    private int balance;
    private String[][] properties;
    private String[] shippingProp;
    private String[] breweryProp;
    private int houses;
    private int hotel;
    private boolean jailfree;

    public Account(int balance){
        this.balance = balance;
        // 2d array med property navn og farve
        properties = new String[24][2];
        breweryProp = new String[1];
        shippingProp = new String[1];
    }

    public void addProperty(String propertyName, Color color)
    {
        for(int i = 0; i < properties.length; i++) {
            if (properties[i][0] == null)
            {
                properties[i][0] = propertyName;
                properties[i][1] = color.toString();
                break;
            }
        }
    }

    public void deleteProperty(String propertyName)
    {
        String[][] newPropArray = new String[24][2];
        int counter = 0;
        for(int i = 0; i < properties.length; i++) {
       //     if (properties[i][0] != null || properties[i][0] != propertyName)
       //     {

       //     }
            if(properties[i][0] == propertyName){
                newPropArray[counter][0] = null;
                newPropArray[counter][1] = null;
                counter++;
            }
            else{
                newPropArray[counter][0] = properties[i][0];
                newPropArray[counter][1] = properties[i][1];
                counter++;
            }
            properties = newPropArray;
        }
    }

    public String[][] getProperties() {
        return properties;
    }

    public void updateScore(int balanceUpdate){
        balance += balanceUpdate;
    }

    public int getBalance(){return balance;}

    public void setJailfree(boolean jailfree) {
        this.jailfree = jailfree;
    }

    public boolean isJailfree() {
        return jailfree;
    }

    public void addShipping(String propertyName)
    {
        for(int i = 0; i < shippingProp.length; i++) {
            if (shippingProp[i] == null)
            {
                shippingProp[i] = propertyName;
                break;
            }
        }
    }

    public void addBrewery(String propertyName)
    {
        for(int i = 0; i < breweryProp.length; i++) {
            if (breweryProp[i] == null)
            {
                breweryProp[i] = propertyName;
                break;
            }
        }
    }

    public String[] getShippingProp()
    {
        return shippingProp;
    }

    public String[] getBreweryProp() {
        return breweryProp;
    }

    public void addHouse()
    {
        houses++;
    }

    public void addHotel()
    {
        hotel++;
    }

    public int numOfHouses()
    {
        return houses;
    }

    public int numOfHotels()
    {
        return hotel;
    }

    public int amountOfProperties()
    {
        int counter = 0;
        for(int i = 0; i < properties.length; i++)
        {
            if(properties[i][0] != null)
            {
                counter++;
            }
        }

        return counter;
    }

}
