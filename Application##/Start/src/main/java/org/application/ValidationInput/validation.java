package org.application.ValidationInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class validation {


    public static String validateStringInput(Scanner scanner, String prompt, String regex) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println(prompt);
            input = scanner.nextLine();

            if (input.matches(regex)) {
                validInput = true;
            } else {
                System.err.println("Veuillez entrer une valeur valide.");
            }
        }

        return input;
    }

    public static String validateDateInput(Scanner scanner, String prompt, String regex) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println(prompt);
            input = scanner.nextLine();

            if (input.matches(regex)) {
                try {
                    LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    validInput = true;
                } catch (DateTimeParseException e) {
                    System.err.println("Veuillez entrer une date valide (yyyy-MM-dd).");
                }
            } else {
                System.err.println("Veuillez entrer une date valide (yyyy-MM-dd).");
            }
        }

        return input;
    }

    public static String validatePhoneNumberInput(Scanner scanner, String prompt, String regex) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println(prompt);
            input = scanner.nextLine();

            if (input.matches(regex)) {
                validInput = true;
            } else {
                System.err.println("Veuillez entrer un numéro de téléphone valide.");
            }
        }

        return input;
    }

    public static String validateGenderInput(Scanner scanner, String prompt, String regex) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println(prompt);
            input = scanner.nextLine();

            if (input.matches(regex)) {
                validInput = true;
            } else {
                System.err.println("Veuillez entrer une valeur valide (homme ou femme).");
            }
        }

        return input;
    }

}
