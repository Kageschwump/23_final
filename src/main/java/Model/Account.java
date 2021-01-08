package Model;

import Squaretype.PropertySquare;

public class Account {
    private int balance;
    private PropertySquare Property;

    public Account(int balance){
        this.balance = balance;
    }

    public void updateScore(int balanceUpdate){
        balance += balanceUpdate;
    }

    public int getBalance(){return balance;}

}
