package org.application.Function.Add;

import org.application.Gere_BD.prepare;
import org.application.ValidationInput.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class add {

    public static void ajouterRendezVous() throws SQLException {
        // Code pour ajouter un nouveau rendez-vous
        System.out.println("Ajouter un nouveau rendez-vous");

        Scanner scanner = new Scanner(System.in);

        String nom = validation.validateStringInput(scanner, "Saisir le nom : ", "^[a-zA-Z]+$");

        String prenom = validation.validateStringInput(scanner, "Saisir le prenom : ", "^[a-zA-Z]+$");

        String phoneNumber = validation.validatePhoneNumberInput(scanner, "Saisir le numéro de téléphone : ", "^\\d{10}$");

        String sexe = validation.validateGenderInput(scanner, "Saisir le sexe (homme ou femme) : ", "^(homme|femme)$");


        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();


        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStart = currentDate.format(formatter);

        String rendezVousDay = validation.validateDateInput(scanner, "Saisir la date du rendez-vous (yyyy-MM-dd) : ", "^\\d{4}-\\d{2}-\\d{2}$");


        insertNewRendezVous(nom, prenom, phoneNumber, cin, sexe, dateStart, rendezVousDay);
    }

    private static void insertNewRendezVous(String nom, String prenom, String tel, String cin, String sexe, String lieuNaissance, String rendezVousDay) throws SQLException {

       // Connection etat = prepare.getConnection() ;

        if (true)
        {
            String insertNewRendezVous = "" ;
          //  PreparedStatement ps = etat.prepareStatement(insertNewRendezVous) ;

            //int op = ps.executeUpdate() ;
           int op=88;

            if (op>0)
            {
                System.out.println("Add new RendezVous de patient : " +prenom);
                return;
            }
            else
            {
                System.err.println("Cannot add new RendezVous !");
                return;
            }

        }
        else
        {
            System.err.println("Connexion invalid with BD");
        }


    }





}
