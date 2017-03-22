package com.company.main;

/**
 * Created by Admin on 2017-03-13.
 *
 */
public class Palindrome {

    public boolean wordIsPalindrome(String text){

        char[] textArray = text.toCharArray();
        String reverse = reverse(textArray);

        if(text.equals(reverse)){
            return true;
        }else{
            return false;
        }
    }

    private String reverse(char[] textArray) {
        String result = "";
        for (int i = 0; i < textArray.length; i++) {
            result = textArray[i] + result;
        }
        return result;
    }
}
