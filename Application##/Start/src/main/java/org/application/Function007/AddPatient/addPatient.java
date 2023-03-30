package org.application.Function007.AddPatient;

import org.application.Gere_BD.prepare;
import org.application.ValidationInput.validation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.Connection;


public class addPatient {

    public static void ajouterPatient() throws SQLException {

        // Code pour ajouterPatient

        Scanner scanner = new Scanner(System.in);

        String nom = validation.validateStringInput(scanner, "Saisir le nom : ", "^[a-zA-Z]+$");

        String prenom = validation.validateStringInput(scanner, "Saisir le prenom : ", "^[a-zA-Z]+$");

        String phoneNumber = validation.validatePhoneNumberInput(scanner, "Saisir le numéro de téléphone : ", "^\\d{10}$");

        String sexe = validation.validateGenderInput(scanner, "Saisir le sexe (homme ou femme) : ", "^(homme|femme)$");


        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();


        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateCreate = currentDate.format(formatter);

        String dateNaissence = validation.validateDateInput(scanner, "Saisir la date du Naissance (yyyy-MM-dd) : ", "^\\d{4}-\\d{2}-\\d{2}$");


        insertNewPatient(nom, prenom, phoneNumber, cin, sexe, dateNaissence, dateCreate);

    }

    private static void insertNewPatient(String nom, String prenom, String phoneNumber, String cin, String sexe, String dateNaissence, String dateCreate)  {

       Connection connection = prepare.getConnection() ;


      try {

                String insertNewPatient;
                insertNewPatient = "INSERT INTO patient(nom, prenom, tel, cin, dateNaissance, dateCreate, sexe, etat) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
                PreparedStatement ps = connection.prepareStatement(insertNewPatient);

                ps.setString(1, nom);
                ps.setString(2, prenom);
                ps.setString(3, phoneNumber);
                ps.setString(4, cin);
                ps.setDate(5, java.sql.Date.valueOf(dateNaissence));
                ps.setDate(6, java.sql.Date.valueOf(dateCreate));
                ps.setString(7, sexe);
                ps.setBoolean(8, true);

                int op = ps.executeUpdate();


                if (op > 0) {
                    System.out.println("New patient added successfully .");
                }

            }
            catch (SQLException  e)
            {
                System.err.println("Error: " + e.getMessage());
            }







    }






}
