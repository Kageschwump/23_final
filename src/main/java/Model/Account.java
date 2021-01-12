package Model;

import Squaretype.PropertySquare;

public class Account {
    private int balance;
    private String[] properties;
    private boolean jailfree;

    public Account(int balance){
        this.balance = balance;
        properties = new String[1];
    }

    public void addProperty(String propertyName)
    {
        String[] arrayNew = new String[properties.length + 1];
        for (int i = 0; i < properties.length; i++)
        {
            arrayNew[i] = properties[i];
        }
        arrayNew[arrayNew.length] = propertyName;
        properties = arrayNew;
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


}
