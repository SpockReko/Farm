package com.company.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 2017-03-19.
 */
public class AnimalData {

    private final List<Object> value = new LinkedList<>();


    public AnimalData(String name, int age, double weight, double literOfMilk){
        value.add(name);
        value.add(age);
        value.add(weight);
        value.add(literOfMilk);
    }

    public AnimalData(String name, int age, double weight, double kgOfWool, String color) {
        value.add(name);
        value.add(age);
        value.add(weight);
        value.add(kgOfWool);
        value.add(color);
    }

    public AnimalData(String name, int age, double weight, String label) {
        value.add(name);
        value.add(age);
        value.add(weight);
        value.add(label);
    }
}
