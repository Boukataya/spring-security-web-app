package com.capgemini;

import java.util.Scanner;

public class RomanNumbersConverter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = input.nextLine();

        int result = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            char ch = romanNumeral.charAt(i);
            if (ch == 'M') {
                result += 1000;
            } else if (ch == 'D') {
                result += 500;
            } else if (ch == 'C') {
                result += 100;
            } else if (ch == 'L') {
                result += 50;
            } else if (ch == 'X') {
                result += 10;
            } else if (ch == 'V') {
                result += 5;
            } else if (ch == 'I') {
                result += 1;
            }
        }

        System.out.println("The integer value is: " + result);
    }

}
