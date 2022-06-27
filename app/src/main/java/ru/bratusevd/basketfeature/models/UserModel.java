package ru.bratusevd.basketfeature.models;

public class UserModel {
    private String surname;
    private String name;
    private String season;
    private int position;

    public UserModel(String surname, String name, String season, int position) {
        this.surname = surname;
        this.name = name;
        this.season = season;
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public int getPosition() {
        return position;
    }
}
