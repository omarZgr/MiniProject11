package org.application.Function;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import org.application.Function.Add.add;
import org.application.Function.Affiher_RendezVous.afficher_rendezvous;
import org.application.Function.Modifiy.modifiy ;
import org.application.Function.Remove.remove;
import org.application.Function.Search.search;


/*

        MENU

        1) - Ajouter un patient
        2) - Modifier les informations d'un patient
        3) - Supprimer un patient
        4) - Ajouter un nouveau diagnostic
        5) - Afficher la liste des patients
        6) - Afficher la liste des diagnostics
        7) - Effectuer un paiement
        8) - Quitter
*
*
* */

public class Menu {

    public static void AfficherMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Afficher le titre du menu
        System.out.println("######### Menu ######### \n");

        // Afficher les options numérotées

        System.out.println("1) - Ajouter un patient");
        System.out.println("2) - Modifier les informations d'un patient");
        System.out.println("3) - Supprimer un patient");
        System.out.println("4) - Ajouter un nouveau diagnostic");
        System.out.println("5) - Afficher la liste des patients");
        System.out.println("6) - Afficher la liste des diagnostics");
        System.out.println("7) - Effectuer un paiement");
        System.out.println("8) - Quitter");

        // Demander à l'utilisateur de saisir une option
        System.out.print("Entrez le numéro de l'option souhaitée : ");

        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Veuillez entrer un input valide");
            scanner.next(); // clear the invalid input from the scanner
            return;
        }

        // Vérifier si l'option est valide
        if (choice < 1 || choice > 8) {
            System.err.println("Veuillez entrer un numéro d'option valide (1-6)");
            return;
        }

        // Exécuter la fonction correspondante à l'option choisie
        switch (choice) {
            case 1:
                // Ajouter un patient
                break;
            case 2:
                // Modifier les informations d'un patient
                break;
            case 3:
                //  Supprimer un patient
                break;
            case 4:
                // Ajouter un nouveau diagnostic
                break;
            case 5:
                // Afficher la liste des patients
                break;
            case 6:
                // Afficher la liste des diagnostics
                break;
            case 7:
                // Effectuer un paiement
                break;
            case 8:
                //  Quitter
                exitProgrmae() ;
                break;

            default:
                System.out.println("Option invalide");
        }
    }


    public static void initailize() throws SQLException {

        while (true)
        {
            Menu.AfficherMenu();

        }

    }

    private static void exitProgrmae() {

        System.err.println("Le programme va maintenant s'arrêter...");
        System.exit(0);

    }






}
