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

           1) Ajouter un nouveau rendez-vous
           2) Mettre à jour les informations d'un rendez-vous
           3) Supprimer un rendez-vous
           4) Search rendez-vous
           5) Afficher tous les rendez-vous
           6) Exit
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
        System.out.println("1) Ajouter un nouveau rendez-vous");
        System.out.println("2) Mettre à jour les informations d'un rendez-vous");
        System.out.println("3) Supprimer un rendez-vous");
        System.out.println("4) Search rendez-vous");
        System.out.println("5) Afficher tous les rendez-vous");
        System.out.println("6) Exit");

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
        if (choice < 1 || choice > 6) {
            System.err.println("Veuillez entrer un numéro d'option valide (1-6)");
            return;
        }

        // Exécuter la fonction correspondante à l'option choisie
        switch (choice) {
            case 1:
                add.ajouterRendezVous();
                break;
            case 2:
                modifiy.mettreAJourRendezVous();
                break;
            case 3:
                remove.supprimerRendezVous();
                break;
            case 4:
                search.afficherTousRendezVous();
                break;
            case 5:
                afficher_rendezvous.afficherTousRendezVous();
                break;
            case 6:
                exitProgrmae();
                break;
            default:
                System.out.println("Option invalide");
        }
    }


    public static void initailize() throws SQLException {

        while (true)
        {
            clearScreen01();
            Menu.AfficherMenu();
            clearScreen01();
        }

    }

    private static void exitProgrmae() {

        System.err.println("Le programme va maintenant s'arrêter...");
        System.exit(0);

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void clearScreen01() {

        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }





}
