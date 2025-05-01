package tp0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackJackTest {

    @Test
    public void bothPlayersBelow21() {
        BlackJack game = new BlackJack();
        Assertions.assertEquals(19, game.play(19, 17));
    }

    @Test
    public void onePlayerExceeds21() {
        BlackJack game = new BlackJack();
        Assertions.assertEquals(18, game.play(25, 18));
    }

    @Test
    public void bothPlayersExceed21() {
        BlackJack game = new BlackJack();
        Assertions.assertEquals(0, game.play(22, 23));
    }
}
