package ru.bratusevd.basketfeature.models;

public class GameModel {
    private String gameName;
    private String scores;

    public GameModel(String gameName, String scores) {
        this.gameName = gameName;
        this.scores = scores;
    }

    public String getGameName() {
        return gameName;
    }

    public String getScores() {
        return scores;
    }
}
