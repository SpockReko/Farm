package com.company.view;

import com.company.control.AnimalController;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Admin on 2017-03-08.
 * This class is responsible to handle the input and output to the user
 */
public class ShowFarm {

    private AnimalController animalControl = new AnimalController();
    private Scanner scanner = new Scanner(System.in);
    private List<String> animalTypes = new LinkedList<>();

    private String command = "";
    private String result = "";
    private String name;
    private int age;
    private double weight;

    public ShowFarm(){
        initializeValues();
    }

    private void initializeValues() {
        animalTypes.add("cow");
        animalTypes.add("sheep");
        animalTypes.add("dog");
    }

    public void start() {

        greeting();
        firstStep();
        help();

        while (!command.equals("Q")) {

            action();
            command = scanner.next().toUpperCase();

            switch (command) {
                case "A":
                    storeProcedure();
                    break;
                case "V":
                    System.out.println(animalControl.overviewOfAnimals());
                    break;
                case "C":
                    System.out.println(animalControl.showAllCows());
                    break;
                case "S":
                    System.out.println(animalControl.showAllSheep());
                    break;
                case "D":
                    System.out.println(animalControl.showAllDogs());
                    break;
                case "O":
                    System.out.println(animalControl.oldestAnimal());
                    break;
                case "H":
                    help();
                    break;
                case "R":
                    removeAnimal();
                    break;
                default:
                    System.out.println("Didn't catch that, try one more time.");
            }
        }

    }

    /**
     * Saves the data you have given to next time!
     */

    public void save(){
        try{
            FileWriter fw = new FileWriter("save.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(animalControl.saveAllAnimal());

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  Load from file that you previously saved.
     */
    public void load(){

        try {

            FileReader fr = new FileReader("save.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while((str = br.readLine()) != null) {
                String[] splitStr = str.split(" ");

                if(splitStr[0].equals("cow"))
                        animalControl.StoreCow(splitStr[1],
                            Integer.parseInt(splitStr[2]),
                            Double.parseDouble(splitStr[3]),
                            Double.parseDouble(splitStr[4]));

                if(splitStr[0].equals("sheep"))
                        animalControl.StoreSheep(splitStr[1],
                            Integer.parseInt(splitStr[2]),
                            Double.parseDouble(splitStr[3]),
                            Double.parseDouble(splitStr[4]),
                            splitStr[5]);

                if(splitStr[0].equals("dog"))
                        animalControl.StoreDog(splitStr[1],
                            Integer.parseInt(splitStr[2]),
                            Double.parseDouble(splitStr[3]),
                            splitStr[4]);
            }

            br.close();

        }catch (IOException e){

            System.out.println("File not found");

        }

    }

    /**
     * Remove a animal by giving the animals name.
     */
    private void removeAnimal() {
        System.out.println(animalControl.listAllName());
        System.out.print("\nWho do you want to remove > ");
        System.out.println(animalControl.remove(scanner.next()));
    }

    /**
     *  Give some helping text about the commands.
     */
    private void help() {
        System.out.println("\nYou can do following things: ");
        System.out.print("\nStore a Animal (A)\nRemove a Animal (R)\nGet a View over your farm (V)\n" +
                "Get info about your Cows (C)\nInfo about Sheep (S)\nInfo about Dogs (D)\nOr which animal is oldest (O)\n" +
                "\nYou can always quit (Q)\nOr write (H) for help\n");

    }

    private void action() {
        System.out.print("\nWhat do you want to do now: ");
    }

    private void greeting() {
        System.out.println("HI and welcome to your farm\n");
    }

    /**
     * the first steps in the program
     */
    private void firstStep() {
        if (animalControl.overviewOfAnimals().equals("")) {
            System.out.println("Right now your farm is empty\n");

            // Different actions: Store Animal
            storeProcedure();
        }else{
            System.out.println(animalControl.overviewOfAnimals());
        }
    }

    /**
     * Add data to your register
     */
    private void storeProcedure() {
        System.out.println("Start store animals by writing" + printAnimal() +"\n");
        System.out.print("What do you want to store: ");
        command = scanner.next();
        if(command.toLowerCase().equals("cow")) {
            storeCow();
        }else if(command.toLowerCase().equals("sheep")){
            storeSheep();
        }else if(command.toLowerCase().equals("dog")){
            storeDog();
        }else{
            System.out.println("\nDiden't");
        }
    }

    /**
     *  Saves information about a dog
     */
    private void storeDog() {
        storeAnimal();
        System.out.print("\nAnd the label of food: ");
        String label = scanner.next();
        boolean done = false;
        while (!done) {
        result = animalControl.StoreDog(name, age, weight, label);
            done = isDone(done);
        }
        System.out.print("\n" + result);
    }


    /**
     *  Saves information about a sheep
     */
    private void storeSheep() {
        storeAnimal();
        System.out.print("\nAmount of wool(kg): ");
        double kgOfWool = scanner.nextDouble();
        System.out.print("\nAnd the colour of wool: ");
        String color = scanner.next();
        boolean done = false;
        while (!done) {
            result = animalControl.StoreSheep(name, age, weight, kgOfWool, color);
            done = isDone(done);
        }
        System.out.print("\n" + result);
    }


    /**
     *  Saves information about a cow
     */
    private void storeCow() {
        storeAnimal();
        System.out.print("\nAmount of milk(liters): ");
        double literOfMilk = scanner.nextDouble();
        boolean done = false;
        while (!done) {
            result = animalControl.StoreCow(name, age, weight, literOfMilk);
            done = isDone(done);
        }
        System.out.print("\n" + result);
    }

    /**
     * No animal with the same name can be saved
     * @param done
     * @return
     */
    private boolean isDone(boolean done) {
        if (result.equals("Error name")) {
            System.out.println("The name already exist\n\nShows a new name\n\n");
            System.out.print("\nName: ");
            name = scanner.next();

        } else {
            done = true;
        }
        return done;
    }

    /**
     * The information all animals need before it get stored
     */
    private void storeAnimal() {
        System.out.print("\nYou choose to add a " + command.toLowerCase());
        System.out.print("\nName: ");
        name = scanner.next();
        System.out.print("\nAge: ");
        age = scanner.nextInt();
        System.out.print("\nWeight: ");
        if(scanner.hasNextDouble())
            weight = scanner.nextDouble();
        else if(scanner.hasNextInt())
            weight = (double) scanner.nextInt();
    }

    /**
     * One method that writes the kind of animal you can store at the moment.
     *
     * @return
     */
    private String printAnimal(){
        String result = "";
        for(int i = 0; i< animalTypes.size(); i++){
            if(i == 0){
                result = result + " " + animalTypes.get(i);
            }else if(!(i == animalTypes.size()-1)){
                result = result + ", " + animalTypes.get(i);
            }else{
                result = result + " or " + animalTypes.get(i) + ".";
            }
        }
        return result;
    }

}
