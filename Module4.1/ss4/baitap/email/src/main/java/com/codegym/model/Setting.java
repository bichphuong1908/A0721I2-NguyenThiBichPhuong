package com.codegym.model;

public class Setting {
    private int id;
    private String languages;
    private int page;
    private boolean spams;
    private String signature;

    public Setting() {
    }

    public Setting(int id, String languages, int page, boolean spams, String signature) {
        this.id = id;
        this.languages = languages;
        this.page = page;
        this.spams = spams;
        this.signature = signature;
    }

    public Setting(String english, int i, boolean b, String thor) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
