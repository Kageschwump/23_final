package Model;

public class ShuffleCup {
    private Dice dice1;
    private Dice dice2;
    private int value;

    public ShuffleCup(){
        Dice dice1 = new Dice(3);
        Dice dice2 = new Dice(3);
        this.dice1 = dice1;
        this.dice2 = dice2;
    }

    public int roll(){
        dice1.setFaceValue(dice1.roll());
        dice2.setFaceValue(dice2.roll());
        value = dice1.getFaceValue() + dice2.getFaceValue();
        return value;
    }

    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    public int getValue(){
        return value;
    }

}
