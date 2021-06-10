package Everest;

import java.util.Random;

public class Dice {

    //variables
    private int value;

    //constructor
    public Dice() {
        roll();
    }

    //getters and setter
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    //misc methods
    public void roll() {
        Random rand=new Random();	//we want a random number between 1 and 6.
        value = rand.nextInt((6-1)+1)+1;
    }
}
