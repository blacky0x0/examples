package com.example;

public class Artist {

    public static void main(String[] args) {
        System.out.println("heeeeeelllloooooooo");
    }

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
