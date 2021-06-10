package Everest;

import java.util.Scanner;

public class Driver {

    // How to play:
    // https://www.youtube.com/watch?v=fQM7Ad78baQ

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int endGame = 0; // 1 = game has ended
        int choice = 0;
        int cont = 0;   // 1 = can continue

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
                    choice = in.nextInt();
                    cont = 0; // reset continue status

                    // if your choice is in results or dice values
                    if(myGame.validChoice(choice)){
                        myGame.strikeValue(currentPlayer,choice); // update the scorecard
                        cont = 1;
                    }else{
                        System.out.println("You cannot remove that value!");
                    }
                }while(cont == 0);
            }else{
                System.out.println("Not playable");
            }


            // temporary player swap

            if(currentPlayer == p1){
                currentPlayer = p2;
            }else{
                currentPlayer = p1;
            }

        }while(endGame == 0);

    }
}
