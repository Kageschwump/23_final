package Model;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class Player {
    private int id;
    private int age;
    private String name;
    private Account account;
    private GUI_Car car;
    private GUI_Player player;
    private int placement;



    public Player(int id, String name, int age, GUI_Car car, int startBalance) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.player = new GUI_Player(name, startBalance, car);
        this.car = car;
        account = new Account(startBalance);
    }

    public String getName(){return name;}

    public int getAge() {
        return age;
    }

}
