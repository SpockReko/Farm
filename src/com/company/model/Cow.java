package com.company.model;

/**
 * Created by Admin on 2017-03-08.
 *
 * This model the information for a cow
 */

public class Cow implements Animal {

    private final String type;

    private final String name;
    private final int age;
    private final double weight;
    private double literOfMilk;
    public Cow(String name, int age, double weight, double literOfMilk) {
        this.type = "cow";
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.literOfMilk = literOfMilk;
    }

    @Override
    public String toString() {
        return "Name " + name +
                ", Age " + age +
                ", Weight " + weight +
                ", literOfMilk " + literOfMilk +
                "\n";
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getInfo() {
        return "cow " +
                name + " " +
                age + " " +
                weight + " " +
                literOfMilk;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
