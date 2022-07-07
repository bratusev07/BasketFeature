package ru.bratusevd.basketfeature.models;

public class PlayerModel {
    private String playerName;
    private String number;

    public PlayerModel(String playerName, String number) {
        this.playerName = playerName;
        this.number = number;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getNumber() {
        return number;
    }
}