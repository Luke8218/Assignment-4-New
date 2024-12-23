package com.lukecheskin.classes;

import java.util.ArrayList;

public class Collection {
    public String name;
    public ArrayList<LegoSet> sets;

    public Collection(String name) {
        this.name = name;
        this.sets = new ArrayList<LegoSet>();
    }
}
