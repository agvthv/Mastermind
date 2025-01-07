package mastermind.UI;

import java.util.Scanner;

public class Menu
{
    public void introduction(){
        System.out.println("Welcome to Mastermind");
        System.out.println("What option would you like?\n1) Single Player\n2) Multi-player");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        if (choice == 1){
            singleGame();
        } else if (choice == 2) {
            multiplayer();
        } else{
            System.out.println("Uh-oh! That was an invalid response. Please try again!\n");
            introduction();
        }
    }

    public void closing(){
        System.out.println("Thank you for playing the game! What would you like to do next?\n 1)Play again\n2)View Scoreboard\n3)Exit");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        if (choice == 1){
            introduction();
        } else if (choice == 2) {
            System.out.println("Here is the scoreboard for the week!");
        } else if (choice == 3) {
            System.out.println("Thank you for playing. See you again soon");
        } else {
            System.out.println("Uh-oh! That was an invalid response. Please try again!\n)");
            closing();
        }
    }
    public void singleGame(){

    }

    public void multiplayer(){

    }


}
