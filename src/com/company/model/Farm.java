package com.company.model;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 2017-03-08.
 *
 * The Farm Class holds the animals and get information and calculates the age
 */
public class Farm {

    public List<Animal> animalList = new LinkedList<>();


    public String addCow(String name, int age, double weight, double literOfMilk) {
        Animal cow = new Cow(name, age, weight, literOfMilk);
        return addAnimal(name, cow);
    }

    public String addSheep(String name, int age, double weight, double kgOfWool, String color) {
        Animal sheep = new Sheep(name, age, weight, kgOfWool, color);
        return addAnimal(name, sheep);
    }

    public String addDog(String name, int age, double weight, String label) {
        Animal dog = new Dog(name, age, weight, label);
        return addAnimal(name, dog);
    }

    public String overview() {

        Cow cow = new Cow(null,0,0,0);
        Sheep sheep = new Sheep(null,0,0,0,null);
        Dog dog = new Dog(null,0,0,null);
        int nrOfCows = 0;
        int nrOfSheep = 0;
        int nrOfDogs = 0;

        for (Animal a: animalList) {
            if(a.getClass().equals(cow.getClass()))
                nrOfCows++;
            else if(a.getClass().equals(sheep.getClass()))
                    nrOfSheep++;
            else if(a.getClass().equals(dog.getClass()))
                    nrOfDogs++;
        }

        return "Your farm has\n" +
                nrOfCows + " Cow(s)" +
                ", " + nrOfSheep + " Sheep" +
                " and " + nrOfDogs + " Dog(s)";

    }

    public String showCow() {
        String result = "\n";
        for (Animal a: animalList){
            if(a.getType().equals("cow"))
                result = result + "\n" + a.toString();
        }
        return result;
    }

    public String showSheep() {
        String result = "\n";
        for (Animal a: animalList){
            if(a.getType().equals("sheep"))
                result = result + "\n" + a.toString();
        }
        return result;
    }

    public String showDogs() {
        String result = "\n";
        for (Animal a: animalList){
            if(a.getType().equals("dog"))
                result = result +  a.toString();
        }
        return result;
    }

    public String showOldest() {
        int highestAge = 0;
        Animal oldestAnimal = animalList.get(0);
        for (Animal indexAnimal: animalList){
            if(highestAge < indexAnimal.getAge()) {
                highestAge = indexAnimal.getAge();
                oldestAnimal = indexAnimal;
            }
        }
        return "Oldest animal is: " + oldestAnimal.toString();

    }

    private String addAnimal(String name, Animal givenAnimal) {
        for (Animal indexAnimal: animalList) {
            if(indexAnimal.getName().equals(givenAnimal.getName())){
                return "Sorry: There already an animal named " + name;
            }
        }
        animalList.add(givenAnimal);
        return "Now is " + name + "added to your farm";
    }

    public boolean remove(String name) {
        for (Animal indexAnimal: animalList) {
            if(indexAnimal.getName().equals(name))
                return animalList.remove(indexAnimal);
        }
        return false;
    }

    public String listAllName() {
        String result = "Name : Type\n\n";
        for (Animal indexAnimal: animalList) {
            result = result + indexAnimal.getName() + " : " + indexAnimal.getType() + "\n";
        }
        return result;
    }

    public String showAllAnimal() {
        String result = "";
        for (Animal a: animalList) {
            result = result + a.getInfo() + "\n";
        }
        return result;
    }
}
