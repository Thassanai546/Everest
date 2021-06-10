package Everest;

import java.util.Collections;
import java.util.Vector;

public class EverestGame {

    int[] faceValues = new int[3];  // values of the dice
    Vector diceValues = new Vector(); // initial capacity = 10

    public boolean find(int[] arr, int target){
        // if value exists in array return true else return false
        for (int x: arr) {
            if (x == target) {
                return true; // breaks loop
            }
        }
        return false;
    }

    public boolean validChoice(int choice){
        // did the user enter a playable value?
        if(diceValues.contains(choice)){
            return true;
        }else{
            return false;
        }
    }

    public void roll3(){
        Dice d = new Dice();
        //roll 3 dice
        System.out.print("3 dice were rolled, with the following values: ");
        for(int i=0;i<3;i++){
            d.roll();
            faceValues[i] = d.getValue();
            System.out.print(faceValues[i] + " ");
        }
        System.out.println();
        getSums();
    }

    public boolean playRound(Player p){
        for(int x: p.getScoreCard()){
            if(diceValues.contains(x)){
                return true;
            }
        }
        return false;
    }

    public void getSums(){
        int sum;
        // get possible sums from dice values
        for(int i=0;i<3;i++){
            for(int y=0;y<3;y++){
                sum = faceValues[i] + faceValues[y];
                if(i!=y && !diceValues.contains(sum)){
                    //cannot add dice to itself + removing duplicates
                    diceValues.addElement(sum);
                }
            }
        }
        for(int x: faceValues){
            if(!diceValues.contains(x)) diceValues.addElement(x);
        }

        if((faceValues[0] + faceValues[1] + faceValues[2]) < 12){
            diceValues.addElement((faceValues[0] + faceValues[1] + faceValues[2]));
        }
        System.out.print("These are the values that you can eliminate: ");
        Collections.sort(diceValues);
        System.out.println(diceValues);
    } // end method

    public void strikeValue(Player p, int choice){

        // strike value off player scorecard.
        int[] scoreCard = p.getScoreCard();
        for(int i=0;i< scoreCard.length;i++){
            if(scoreCard[i] == choice){
                scoreCard[i] = 0;
                break;
            }
        }
        p.setScoreCard(scoreCard);
        System.out.println(p.getName() + " got rid of " + choice + " their scorecard is now :");
        System.out.println(p.printScoreCard());
    }

    public int checkWin(Player p){
        int endGame = 0;
        int[] playersCard = p.getScoreCard();
        for(int x:playersCard){
            // a scorecard with all 0s is a win
            if(x == 0){
                endGame = 1;
            }else{
                endGame = 0;
                break; // handle last value on scorecard
            }
        }
        return endGame;
    }

}
