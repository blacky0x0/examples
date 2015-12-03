package com.blacky.examples;

public class Artist {

    private String fullName = "";
    private String from = "";

    public Artist(String fullName, String from) {
        this.fullName = fullName;
        this.from = from;
    }

    public boolean isFrom(String anotherPlace) {
        return from.equalsIgnoreCase(anotherPlace);
    }

    @Override
    public String toString() {
        return fullName;
    }
}
