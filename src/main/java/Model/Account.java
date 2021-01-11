package Model;

import Squaretype.PropertySquare;

public class Account {
    private int balance;
    private PropertySquare[] properties;
    private boolean jailfree;

    public Account(int balance){
        this.balance = balance;
        properties = new PropertySquare[1];
    }

    public void addProperty(PropertySquare property)
    {
        PropertySquare[] arrayNew = new PropertySquare[properties.length + 1];
        for (int i = 0; i < properties.length; i++)
        {
            arrayNew[i] = properties[i];
        }
        properties = arrayNew;
    }

    public void deleteProperty(PropertySquare property)
    {
        PropertySquare[] arrayNew = new PropertySquare[properties.length - 1];
        for (int i = 0; i < properties.length; i++)
        {
            if(!properties[i].getName().equals(property.getName()))
            {
                arrayNew[i] = properties[i];
            }

        }
        properties = arrayNew;
    }

    public PropertySquare readProperty(String name)
    {
        PropertySquare property = null;
        for (int i = 0; i < properties.length; i++)
        {
            if(name.equals(properties[i].getName())) {
                property = properties[i];
                break;
            }
        }
        return property;
    }

    public PropertySquare[] getProperties() {
        return properties;
    }

    public void updateScore(int balanceUpdate){
        balance += balanceUpdate;
    }

    public int getBalance(){return balance;}

    public void setJailfree(boolean jailfree) {
        this.jailfree = jailfree;
    }

}
