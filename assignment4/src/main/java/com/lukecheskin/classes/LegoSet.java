package com.lukecheskin.classes;

import java.util.ArrayList;

public class LegoSet {
    public String setNumber;
    public String name;
    public int pieces;
    public float price;
    public Status status;
    public String theme;
    public ArrayList<Minifigure> minifigures;

    public LegoSet(String setNumber, String name, int pieces, float price, Status status, String theme) {
        this.setNumber = setNumber;
        this.name = name;
        this.pieces = pieces;
        this.price = price;
        this.status = status;
        this.theme = theme;
    }

    public ArrayList<Minifigure> getMinifigures() {
        return minifigures;
    }

    public void setMinifigures(ArrayList<Minifigure> minifigures) {
        this.minifigures = minifigures;
    }
}