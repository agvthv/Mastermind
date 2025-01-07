package mastermind.Player;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SINGLE")
public class SinglePlayer extends Player
{
        public SinglePlayer(String playerName, int playerScore){
            super(playerName, playerScore);
        }

}

