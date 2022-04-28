package com.codegym.model;

public class Declaration {
    private int id;
    private String name;
    private String birthday;
    private String sex;
    private String nationality;
    private String cardId;

    public Declaration() {
    }

    public Declaration(int id, String name, String birthday, String sex, String nationality, String cardId) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.nationality = nationality;
        this.cardId = cardId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
