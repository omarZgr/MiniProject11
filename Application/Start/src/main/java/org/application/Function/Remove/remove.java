package org.application.Function.Remove;

import org.application.Gere_BD.checkBD;
import org.application.Gere_BD.prepare;
import org.application.ValidationInput.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class remove {



    public static void supprimerRendezVous() throws SQLException {
        // Code pour supprimer un rendez-vous
        System.out.println("Supprimer un rendez-vous");

        Scanner scanner = new Scanner(System.in);

        String nom = validation.validateStringInput(scanner, "Saisir le nom : ", "^[a-zA-Z]+$");

        String prenom = validation.validateStringInput(scanner, "Saisir le prenom : ", "^[a-zA-Z]+$");

        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();

        String rendezVousDay = validation.validateDateInput(scanner, "Saisir la date du rendez-vous (yyyy-MM-dd) : ", "^\\d{4}-\\d{2}-\\d{2}$");


        if (checkBD.check(nom, prenom, cin, rendezVousDay))
            RemovewRendezVous(nom, prenom, cin, rendezVousDay) ;
        else
            System.err.println("RendezVous introuvable");


    }

    private static void RemovewRendezVous(String nom, String prenom,  String cin, String rendezVousDay) throws SQLException {

        Connection etat = prepare.getConnection() ;

        if (true)
        {
            String ModifiyNewRendezVous = "" ;
            PreparedStatement ps = etat.prepareStatement(ModifiyNewRendezVous) ;

            int op = ps.executeUpdate() ;

            if (op>0)
            {
                System.out.println("Remove RendezVous de patient : " +prenom);
                return;
            }
            else
            {
                System.err.println("Cannot Remove RendezVous !");
                return;
            }

        }
        else
        {
            System.err.println("Connexion invalid with BD");
        }


    }


}
