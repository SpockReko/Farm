package com.company.control;


import com.company.model.AnimalData;
import com.company.model.AnimalType;
import com.company.model.Farm;
import com.company.model.IFarm;

/**
 * Created by Admin on 2017-03-08.
 *
 * This class is a controller for the model. Connects the view to the model.
 */
public class AnimalController implements IAnimalController {

    public IFarm farm = new Farm();

    @Override
    public String addAnimal(AnimalData animalData, AnimalType type) {
        return null;
    }

    public String overviewOfAnimals(){
        return farm.overview();
    }

    @Override
    public String showAnimal(AnimalType type) {
        return null;
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
