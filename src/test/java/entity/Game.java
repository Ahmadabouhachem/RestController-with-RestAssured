package entity;

import java.util.Arrays;

public class Game {

    private int gameId;

    private int[] numberOfHours;

    public Game() {
    }

    public Game(int gameId, int[] numberOfHours) {
        this.gameId = gameId;
        this.numberOfHours = numberOfHours;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int[] getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int[] numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", numberOfHours=" + Arrays.toString(numberOfHours) +
                '}';
    }
}