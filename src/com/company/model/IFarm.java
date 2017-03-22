package com.company.model;

/**
 * Created by Admin on 2017-03-19.
 */
public interface IFarm {

    public String addAnimal(AnimalData animalData,AnimalType type);

    public String overview();

    public String showAnimal(AnimalType type);

    public String showOldest();

    public boolean remove(String name);

    public String listAllName();

    public String showAllAnimal();
}
