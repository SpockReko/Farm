package com.company.model;

/**
 * Created by Admin on 2017-03-08.
 *
 * This model the information for a Sheep
 */
public class Sheep implements Animal {

    private final String type;

    private final String name;
    private final int age;
    private final double weight;
    private final double kgOfWool;
    private final String color;
    public Sheep(String name, int age, double weight, double kgOfWool, String color) {
        this.type = "sheep";
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.kgOfWool = kgOfWool;
        this.color = color;
    }

    @Override
    public String toString() {
        return  "Name " + name +
                ", Age " + age +
                ", Weight " + weight +
                ", KgOfWool " + kgOfWool +
                ", Color " + color;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getInfo() {
        return "sheep " +
                name + " " +
                age + " " +
                weight + " " +
                kgOfWool + " " +
                color + "\n";
    }

    public String getType() {
        return type;
    }

    public String getName(){
        return name;
    }
}
