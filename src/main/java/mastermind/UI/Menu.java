package mastermind.UI;

import mastermind.Game.MultiGame;
import mastermind.Game.SingleGame;

import java.util.Scanner;

public class Menu
{

    public void introduction(){
        System.out.println("**Welcome to Mastermind!**  \n" +
                "Put your wits to the test and crack the computer’s secret 4-number code (0–7) in just 10 tries!\n" +
                "Get clues after each guess to uncover how close you are.\n" +
                "Can you outsmart the computer and become the ultimate codebreaker?\n" +
                "Let’s play!\n");
        System.out.println("What option would you like?\n1) Single Player\n2) Multi-player");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        if (choice == 1){
            SingleGame singleGame = new SingleGame(this);
            singleGame.startGame();
        } else if (choice == 2) {
            MultiGame multiGame = new MultiGame(this);
            multiGame.startGame();
        } else{
            System.out.println("Uh-oh! That was an invalid response. Please try again!\n");
            introduction();
        }
    }

    public void closing(){
        System.out.println("Thank you for playing the game! What would you like to do next?\n\n1)Play again\n2)Exit");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        if (choice == 1){
            introduction();
        } else if (choice == 2) {
            System.out.println("Thank you for playing. See you again soon!");
        } else {
            System.out.println("Uh-oh! That was an invalid response. Please try again!\n");
            closing();
        }
    }

}
