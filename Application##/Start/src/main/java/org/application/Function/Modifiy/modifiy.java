package org.application.Function.Modifiy;

import org.application.Gere_BD.prepare;
import org.application.Gere_BD.checkBD;
import org.application.ValidationInput.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class modifiy {

    public static void mettreAJourRendezVous() throws SQLException {
        // Code pour mettre à jour les informations d'un rendez-vous
        System.out.println("Mettre à jour les informations d'un rendez-vous");
        Scanner scanner = new Scanner(System.in);

        String nom = validation.validateStringInput(scanner, "Saisir le nom : ", "^[a-zA-Z]+$");

        String prenom = validation.validateStringInput(scanner, "Saisir le prenom : ", "^[a-zA-Z]+$");

        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();

        String rendezVousDay = validation.validateDateInput(scanner, "Saisir la date du rendez-vous (yyyy-MM-dd) : ", "^\\d{4}-\\d{2}-\\d{2}$");


        if (checkBD.check(nom, prenom, cin, rendezVousDay))
            ModifiytRendezVous(nom, prenom, cin, rendezVousDay) ;
        else
            System.err.println("RendezVous introuvable");


    }

    private static void ModifiytRendezVous(String nom, String prenom,  String cin, String rendezVousDay) throws SQLException {

         Connection etat = prepare.getConnection() ;

        if (true)
        {
            String ModifiyNewRendezVous = "" ;
              PreparedStatement ps = etat.prepareStatement(ModifiyNewRendezVous) ;

            int op = ps.executeUpdate() ;

            if (op>0)
            {
                System.out.println("Modifiy RendezVous de patient : " +prenom);
                return;
            }
            else
            {
                System.err.println("Cannot Modifiy RendezVous !");
                return;
            }

        }
        else
        {
            System.err.println("Connexion invalid with BD");
        }


    }


}
