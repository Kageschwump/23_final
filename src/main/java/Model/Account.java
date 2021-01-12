package Model;

import Squaretype.PropertySquare;

public class Account {
    private int balance;
    private String[] properties;
    private String[] shippingProp;
    private String[] breweryProp;
    private boolean jailfree;

    public Account(int balance){
        this.balance = balance;
        properties = new String[1];
        breweryProp = new String[1];
        shippingProp = new String[1];
    }

    public void addProperty(String propertyName)
    {
        if(properties.length == 1)
        {
            properties[0] = propertyName;
        } else {
            String[] arrayNew = new String[properties.length];
            for (int i = 0; i < properties.length; i++) {
                arrayNew[i] = properties[i];
            }
            arrayNew[arrayNew.length] = propertyName;
            properties = arrayNew;
        }
    }

    public void deleteProperty(String propertyName)
    {
        String[] arrayNew = new String[properties.length - 1];
        for (int i = 0; i < properties.length; i++)
        {
            if(!properties[i].equals(propertyName))
            {
                arrayNew[i] = properties[i];
            }

        }
        properties = arrayNew;
    }

    public String[] getProperties() {
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

}
