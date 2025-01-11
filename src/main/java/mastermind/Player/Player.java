package mastermind.Player;

import java.util.Scanner;

public abstract class Player {

    private String playerName;

    public Player() {
        this.playerName= "";
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void createPlayer(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Player name: ");
        String name = userInput.nextLine();
        this.setPlayerName(name);
        System.out.println("\nPlayer created: " + this.getPlayerName());
        System.out.println("-".repeat(15)+ "\n");
    };
}
