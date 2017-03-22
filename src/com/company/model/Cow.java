package com.company.model;

/**
 * Created by Admin on 2017-03-08.
 *
 * This model the information for a cow
 */

public class Cow implements Animal {

    private String type;
    private String name;
    private int age;
    private double weight;
    private double literOfMilk;


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

    @Override
    public String addAnimal(AnimalData animalData, AnimalType type) {
        if(type == AnimalType.COW){
            this.type = "cow";
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.literOfMilk = literOfMilk;
        }
        return name + " is added";
    }
}
