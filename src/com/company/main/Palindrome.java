package com.company.main;

/**
 * Created by Admin on 2017-03-13.
 */
public class Palindrome {

    public boolean wordIsPalindrome(String text){

        char[] textArray = text.toCharArray();
        String reverse = "";

        for (int i = 0; i < textArray.length; i++) {
            reverse = textArray[i] + reverse;
        }

        if(text.equals(reverse)){
            return true;
        }else{
            return false;
        }
    }
}
