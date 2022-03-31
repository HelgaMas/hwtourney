package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "first", 10);
    Player player2 = new Player(2, "second", 20);
    Player player3 = new Player(3, "third", 30);
    Player player4 = new Player(4, "fourth", 10);

    @BeforeEach
    public void addAll() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void shouldWinFirst() {
        assertEquals(1, game.round(player3.getName(), player1.getName()));
    }

    @Test
    public void shouldWinSecond() {
        assertEquals(2, game.round(player4.getName(), player3.getName()));
    }

    @Test
    public void shouldDraw() {
        assertEquals(0, game.round(player4.getName(), player1.getName()));
    }

    @Test
    public void shouldCheckUnregisteredFirstPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Gamer", "first");
        });
    }

    @Test
    public void shouldCheckUnregisteredSecondPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("fourth", "ironman");
        });
    }

    @Test
    public void shouldCheckUnregisteredBothPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Gamer", "ironman");
        });
    }
}