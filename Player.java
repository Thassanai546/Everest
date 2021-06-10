package Everest;

import java.util.Arrays;

public class Player {
    private String name;
    private int[] scoreCard = {1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11,12};

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(int[] scoreCard) {
        this.scoreCard = scoreCard;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", scoreCard=" + Arrays.toString(scoreCard) +
                '}';
    }

    public String printScoreCard(){
        // prints a nice looking scorecard similar to a real scorecard from the game
        String formattedCard = "\n==========================\n";
        for(int x:this.scoreCard){
            formattedCard += x + " ";
            if(x == 12){
                formattedCard += "\n";
            }
        }
        formattedCard += "==========================";
        return formattedCard;
    }

}
