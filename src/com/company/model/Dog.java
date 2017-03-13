package com.company.model;

/**
 * Created by Admin on 2017-03-08.
 *
 * This model the information for a Dog
 */
public class Dog implements Animal{

    private final String type;

    private final String name;
    private final int age;
    private final double weight;
    private final String label;
    public Dog(String name, int age, double weight, String label) {
        this.type = "dog";
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.label = label;
    }

    @Override
    public String toString() {
        return  "Name " + name +
                ", Age " + age +
                ", Weight " + weight +
                ", Label " + label + "\n";
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getInfo() {
        return "dog " +
                name + " " +
                age + " " +
                weight + " " +
                label;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
