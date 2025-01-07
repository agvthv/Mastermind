package mastermind.Player;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MULTI")
public class MultiPlayer extends Player
{
    String playerName2;
    public MultiPlayer(String playerName, int playerScore, String playerName2)
    {
        super(playerName, playerScore);
        this.playerName2 = playerName2;
    }

    public String getPlayerName2()
    {
        return playerName2;
    }

    public void setPlayerName2(String playerName2)
    {
        this.playerName2 = playerName2;
    }
}
