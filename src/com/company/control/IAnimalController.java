package com.company.control;

import com.company.model.AnimalData;
import com.company.model.AnimalType;

/**
 * Created by Admin on 2017-03-19.
 */
public interface IAnimalController {

    public String addAnimal(AnimalData animalData, AnimalType type);

    public String overviewOfAnimals();

    public String showAnimal(AnimalType type);

    public String oldestAnimal();

    public boolean remove(String name);

    public String listAllName();

    public String saveAllAnimal();
}
