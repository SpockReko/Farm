package com.company.control;


import com.company.model.Farm;

/**
 * Created by Admin on 2017-03-08.
 *
 * This class is a controller for the model. Connects the view to the model.
 *
 * Förbättringar:
 * TODO: Gör ett interface som delar av viewn med controllern.
 */
public class AnimalController {

    public Farm farm = new Farm();


    public String StoreCow(String name, int age, double weight, double literOfMilk) {
        return farm.addCow(name, age, weight, literOfMilk);
    }

    public String StoreSheep(String name, int age, double weight, double kgOfWool, String color) {
        return farm.addSheep(name, age, weight, kgOfWool, color);
    }

    public String StoreDog(String name, int age, double weight, String label) {
        return farm.addDog(name, age, weight, label);
    }

    public String overviewOfAnimals(){
        return farm.overview();
    }

    public String showAllCows(){
        return farm.showCow();
    }

    public String showAllSheep(){
        return farm.showSheep();
    }

    public String showAllDogs(){
        return farm.showDogs();
    }

    public String oldestAnimal(){
        return farm.showOldest();
    }

    public boolean remove(String name) {
        return farm.remove(name);
    }

    public String listAllName() {
        return farm.listAllName();
    }

    public String saveAllAnimal() {
        return farm.showAllAnimal();
    }
}
