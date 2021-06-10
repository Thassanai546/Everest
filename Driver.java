package Everest;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int chosenValue;
        int proceed; // can player proceed
        int endGame = 0; // game ends when set to 1

        // initialize players
        Player p1 = new Player("Thass");
        Player p2 = new Player("Joe");

        // start game and set who goes first
        Player currentPlayer = p1;
        EverestGame myGame = new EverestGame();

        do{
            System.out.println("\nIt is currently " + currentPlayer.getName() + "'s turn."  + currentPlayer.printScoreCard());
            myGame.roll3();

            // if player can remove a value this round
            if(myGame.playRound(currentPlayer)){
                do{
                    System.out.println("Enter value to strike");
                    chosenValue = in.nextInt();
                    proceed = 0; // reset continue status

                    // if your chosenValue is in results or dice values
                    if(myGame.validChoice(chosenValue)){
                        myGame.strikeValue(currentPlayer,chosenValue); // update the scorecard
                        proceed = 1;
                    }else{
                        System.out.println("You cannot remove that value!");
                    }
                }while(proceed == 0);
            }else{
                System.out.println("Sorry! You cannot play any values this round!");
            }

            // check if anyone has won before proceeding to next round
            if(myGame.checkWin(currentPlayer) > 0){
                endGame = 1;
            }


            // temporary player swap
            if(currentPlayer == p1){
                currentPlayer = p2;
            }else{
                currentPlayer = p1;
            }

        }while(endGame == 0);

        System.out.println("Game has ended.");

    }
}
