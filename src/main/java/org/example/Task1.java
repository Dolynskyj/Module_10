package org.example;

import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    private static final String PHONE_NUMBERS = "src/main/resources/PhoneNumbers.txt";
    public static void main(String[] args) {
        printValiteNumbers();
    }
    private static void printValiteNumbers(){
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(PHONE_NUMBERS)) {
            int c;
            while ((c = reader.read()) != -1) {
                result.append((char) c);
            }
        }
        catch (IOException e) {
        }
        String[] numbers = result.toString().split("\n");
        for (String numberPhone : numbers){
            if (validityNumber(numberPhone)){
                System.out.println(numberPhone);
            }
        }
    }

    private static boolean validityNumber(String number){
        if (number.charAt(0) == '(' &&
                number.charAt(4) == ')' &&
                number.charAt(5) == ' ' &&
                number.charAt(9) == '-'){
            return true;
        } else if (number.charAt(3) == '-' &&
                number.charAt(7) == '-'){
            return true;
        }else {return false;}
    }
}
