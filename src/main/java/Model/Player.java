package Model;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class Player {
    private int id;
    private int age;
    private String name;
    private Account account;
    private boolean prison;
    private GUI_Car car;
    private GUI_Player player;
    private int placement;



    public Player(int id, String name, int age, GUI_Car car, int startBalance) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.player = new GUI_Player(name, startBalance, car);
        this.car = car;
        prison = false;
        account = new Account(startBalance);
    }

    public void updatePlacement(int newPlacement) {
        int rest;

        if(placement+newPlacement >= 40){
            rest = placement + newPlacement - 40;

            setPlacement(rest);
            account.updateScore(4000);
            player.setBalance(account.getBalance());
        }
        else
            placement += newPlacement;
    }

    public void setPlacement(int placement)
    {
        this.placement = placement;
    }

    public int getPlacement(){
        return placement;
    }

    public GUI_Player getGuiPlayer(){return player;}

    public String getName(){return name;}

    public int getAge() {
        return age;
    }

    public Account getAccount() {
        return account;
    }

    public boolean isPrison() {
        return prison;
    }

    public void setPrison(boolean prison) {
        this.prison = prison;
    }


}
