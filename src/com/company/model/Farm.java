package com.company.model;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 2017-03-08.
 *
 * The Farm Class holds the animals and get information and calculates the age
 */
public class Farm implements IFarm {

    public List<Animal> animalList = new LinkedList<>();

    private Animal animal;

    @Override
    public String addAnimal(AnimalData animalData, AnimalType type) {
        return animal.addAnimal(animalData, type);
    }

    /**
     * Formats and send back the overview of the stored animals.
     * @return
     */
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

    @Override
    public String showAnimal(AnimalType type) {
        return "showAnimal in farm is not implemented";
    }

    /**
     * Next three methods sends back the information about all cows, sheep or dogs.
     * @return
     */

    /**
     * Sends back the information about the oldest animal
     * @return
     */
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


    /**
     * Removes the animal with the given name.
     * @param name
     * @return
     */
    public boolean remove(String name) {
        for (Animal indexAnimal: animalList) {
            if(indexAnimal.getName().equals(name))
                return animalList.remove(indexAnimal);
        }
        return false;
    }

    /**
     * sends back a list with all the names in the register
     * @return
     */
    @Override
    public String listAllName() {
        String result = "Name : Type\n\n";
        for (Animal indexAnimal: animalList) {
            result = result + indexAnimal.getName() + " : " + indexAnimal.getType() + "\n";
        }
        return result;
    }

    /**
     * Sends back animal info to get saved in a text file to next time you start the program.
     * @return
     */
    @Override
    public String showAllAnimal() {
        String result = "";
        for (Animal a: animalList) {
            result = result + a.getInfo() + "\n";
        }
        return result;
    }
}
