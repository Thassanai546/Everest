package Everest;

import java.util.Collections;
import java.util.Vector;

public class EverestGame {

    int[] faceValues = new int[3];  // values of the dice
    Vector diceValues = new Vector(); // vector of values that a user can select

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
        // A player will have to skip a turn if they roll and 
        // no values on their scorecard can be removed
        for(int x: p.getScoreCard()){
            if(diceValues.contains(x)){
                return true;
            }
        }
        return false;
    }

    public void getSums(){
        int sum;
        diceValues.clear(); // clear vector for new dice values
        // get possible sums from dice values
        for(int i=0;i<3;i++){
            for(int y=0;y<3;y++){
                sum = faceValues[i] + faceValues[y];
                if(i!=y && !diceValues.contains(sum)){
                    // i!=y as we cannot add dice to itself, we also remove duplicates here
                    diceValues.addElement(sum);
                }
            }
        }
        // the resulting sums are now in our vector, here we add the face values of the dice
        for(int x: faceValues){
            if(!diceValues.contains(x)) diceValues.addElement(x);
        }

        // the player cannot remove a value greater than 12
        if((faceValues[0] + faceValues[1] + faceValues[2]) <= 12){
            diceValues.addElement((faceValues[0] + faceValues[1] + faceValues[2]));
        }
        System.out.print("These are the values that you can eliminate: ");
        Collections.sort(diceValues); // sort from lowest to highest before outputting
        System.out.println(diceValues);
    }

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
        System.out.print(p.getName() + " got rid of " + choice + " their scorecard is now:" + p.printScoreCard() + "\n");

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
