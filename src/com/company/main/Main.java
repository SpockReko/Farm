package com.company.main;

import com.company.view.ShowFarm;

import java.util.Scanner;

/**
 * Created by Admin on 2017-03-08.
 */
public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.print("Palindrome (P) \nFarm (F) \nQuit (Q)\n\ncommand>");
        String command = "";

        while(command.equals("Q"));

        Scanner s = new Scanner(System.in);
        command = s.next();
        switch (command){
            case "P":
                palindrome();
                break;
            case "F":
                farm();
                break;
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
        Scanner s = new Scanner(System.in);
        System.out.print("Write a word > ");
        String text = s.next();

        if(p.wordIsPalindrome(text))
            System.out.println(text + " is a palindrome\n");
        else{
            System.out.println(text + " is not a palindrome\n");
        }
    }
}
