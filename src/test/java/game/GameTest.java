package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player player1 = new Player(1, "Oxana", 100);
        Player player2 = new Player(1, "Alexey", 150);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Alexey", "Oxana");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player player1 = new Player(1, "Oxana", 100);
        Player player2 = new Player(1, "Alexey", 150);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Oxana", "Alexey");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {
        Player player1 = new Player(1, "Oxana", 100);
        Player player2 = new Player(1, "Alexey", 100);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Oxana", "Alexey");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player player1 = new Player(1, "Oxana", 100);
        Player player2 = new Player(1, "Alexey", 150);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Alexey", "Andrey")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player player1 = new Player(1, "Oxana", 100);
        Player player2 = new Player(1, "Alexey", 150);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Andrey", "Alexey")
        );
    }

    @Test
    public void testWhenPlayersNotExist() {
        Player player1 = new Player(1, "Oxana", 100);
        Player player2 = new Player(1, "Alexey", 150);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Andrey", "Alex")
        );

    }
}
