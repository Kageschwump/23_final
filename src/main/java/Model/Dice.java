package Model;

public class Dice {
    private int faceValue;
    private final int MAX=6;

    public Dice(int value){
        faceValue = value;
    }

    public int roll(){
        faceValue = (int)(Math.random() * MAX) + 1;
        return faceValue;
    }

    public void setFaceValue(int value) {
        faceValue = value;
    }

    public int getFaceValue(){
        return faceValue;
    }

    public String toString(){
        String result = "you rolled: " + faceValue;
        return result;
    }

}
