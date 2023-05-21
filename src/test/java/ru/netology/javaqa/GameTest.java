package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWin() {
        Player jorik = new Player(1, "Олег", 80);
        Player diego = new Player(2, "Ирина", 150);
        Game game = new Game();

        game.register(jorik);
        game.register(diego);
        int actual = game.round("Ирина", "Олег");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void firstPlayerLose() {
        Player jorik = new Player(1, "Олег", 200);
        Player diego = new Player(2, "Ирина", 50);
        Game game = new Game();

        game.register(jorik);
        game.register(diego);
        int actual = game.round("Ирина", "Олег");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void nobodyWins() {
        Player jorik = new Player(1, "Олег", 200);
        Player diego = new Player(2, "Ирина", 200);
        Game game = new Game();

        game.register(jorik);
        game.register(diego);
        int actual = game.round("Ирина", "Олег");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void notRegExceptionsTestIfFirst() {
        Player jorik = new Player(1, "Олег", 200);
        Player diego = new Player(2, "Ирина", 200);
        Game game = new Game();

        game.register(jorik);
        game.register(diego);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Виктор", "Олег"));

    }

    @Test
    public void notRegExceptionsTestIfSecond() {
        Player jorik = new Player(1, "Олег", 200);
        Player diego = new Player(2, "Ирина", 200);
        Game game = new Game();

        game.register(jorik);
        game.register(diego);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ирина", "Петр"));

    }

    @Test
    public void notRegExceptionsTestIfBoth() {
        Player jorik = new Player(1, "Олег", 200);
        Player diego = new Player(2, "Ирина", 200);
        Game game = new Game();

        game.register(jorik);
        game.register(diego);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Виктор", "Петр"));

    }
}