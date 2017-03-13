package com.company.main;

import com.company.view.ShowFarm;

import java.util.Scanner;

/**
 * Created by Admin on 2017-03-08.
 */
public class Main {

    private static String command = "";
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {


        while(!command.equals("Q")) {

            System.out.print("\nAction menu: \n\nPalindrome (P) \nFarm (F) \nQuit (Q)\n\ncommand>");

            command = s.next().toUpperCase();
            switch (command) {
                case "P":
                    palindrome();
                    break;
                case "F":
                    farm();
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Didn't catch that, can you try one more time.");
                    break;
            }

        }
    }

    private static void farm() {
        ShowFarm showfarm = new ShowFarm();
        showfarm.load();
        showfarm.start();
        showfarm.save();
    }

    private static void palindrome() {
        Palindrome p = new Palindrome();
        System.out.print("\nWrite a word > ");
        String text = s.next();

        if(p.wordIsPalindrome(text))
            System.out.println(text + " is a palindrome\n");
        else{
            System.out.println(text + " is not a palindrome\n");
        }
    }
}
