package mastermind.Player;

import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "player_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "Scoreboard")
public abstract class Player
{
    @Id
    @Column(nullable = false, unique = true)
    private String playerName;

    @Column(nullable = false)
    private int playerScore;

    public Player(String getName, int playerScore)
    {
        this.playerName = getName;
        this.playerScore = 0;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String getPlayerName)
    {
        this.playerName = playerName;
    }

    public int getPlayerScore()
    {
        return playerScore;
    }

    public void recordName(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is your name?: ");
        String playerName = userInput.nextLine();

    }

}
