package Model;

import Squaretype.PropertySquare;

import java.awt.*;

public class Account {
    private int balance;
    private String[][] properties;
    private String[] shippingProp;
    private String[] breweryProp;
    private boolean jailfree;

    public Account(int balance){
        this.balance = balance;
        // 2d array med property navn og farve
        properties = new String[1][2];
        breweryProp = new String[1];
        shippingProp = new String[1];
    }

    public void addProperty(String propertyName, Color color)
    {
        if(properties.length == 1)
        {
            properties[0][0] = propertyName;
            properties[0][1] = color.toString();
        } else {
            String[][] arrayNew = new String[properties.length][2];
            for (int i = 0; i < properties.length; i++) {
                arrayNew[i][0] = properties[i][0];
                arrayNew[i][1] = properties[i][1];
            }
            arrayNew[arrayNew.length][0] = propertyName;
            arrayNew[arrayNew.length][1] = color.toString();
            properties = arrayNew;
        }
    }

    public void deleteProperty(String propertyName)
    {
        String[][] arrayNew = new String[properties.length - 1][2];
        for (int i = 0; i < properties.length; i++)
        {
            if(!properties[i][0].equals(propertyName))
            {
                arrayNew[i][0] = properties[i][0];
            }

        }
        properties = arrayNew;
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
        if(shippingProp.length == 1)
        {
            shippingProp[0] = propertyName;
        } else {
            String[] arrayNew = new String[shippingProp.length];
            for (int i = 0; i < shippingProp.length; i++) {
                arrayNew[i] = shippingProp[i];
            }
            arrayNew[arrayNew.length] = propertyName;
            shippingProp = arrayNew;
        }
    }

    public void addBrewery(String propertyName)
    {
        if(breweryProp.length == 1)
        {
            breweryProp[0] = propertyName;
        } else {
            String[] arrayNew = new String[breweryProp.length];
            for (int i = 0; i < breweryProp.length; i++) {
                arrayNew[i] = breweryProp[i];
            }
            arrayNew[arrayNew.length] = propertyName;
            breweryProp = arrayNew;
        }
    }

    public String[] getShippingProp()
    {
        return shippingProp;
    }

    public String[] getBreweryProp() {
        return breweryProp;
    }

}
