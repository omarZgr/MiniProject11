package org.application.Function.Search;

import org.application.Function.Add.RenderVous;
import org.application.Gere_BD.checkBD;
import org.application.Gere_BD.prepare;
import org.application.ValidationInput.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class search {

    public static void afficherTousRendezVous() throws SQLException {
        // Code pour afficher tous les patients
        System.out.println("Search un RendezVous");
        Scanner scanner = new Scanner(System.in);

        String nom = validation.validateStringInput(scanner, "Saisir le nom : ", "^[a-zA-Z]+$");

        String prenom = validation.validateStringInput(scanner, "Saisir le prenom : ", "^[a-zA-Z]+$");

        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();

        String rendezVousDay = validation.validateDateInput(scanner, "Saisir la date du rendez-vous (yyyy-MM-dd) : ", "^\\d{4}-\\d{2}-\\d{2}$");


        if (checkBD.check(nom, prenom, cin, rendezVousDay))
        {
           ArrayList<RenderVous> list =  getALLDATA(nom, prenom, cin, rendezVousDay) ;
            displayRendezVousTable(list) ;
        }
        else
            System.err.println("RendezVous introuvable");

    }

    private static ArrayList<RenderVous> getALLDATA(String nomInput, String prenomInput, String cinInput, String rendezVousDayInput) throws SQLException {
        Connection etat = prepare.getConnection() ;

        if (true) {
            String query = "";
            PreparedStatement ps = etat.prepareStatement(query);

            String nom, prenom, tel, cin, dateLancer, dateRendezVous, sexe;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nom = rs.getString(1);
                prenom = rs.getString(2);
                tel = rs.getString(3);
                cin = rs.getString(4);
                sexe = rs.getString(5);
                dateLancer = String.valueOf(rs.getDate(6));
                dateRendezVous = String.valueOf(rs.getDate(7));

                return new ArrayList<>((Collection) new RenderVous(nom,prenom,tel,cin,sexe,dateLancer,dateRendezVous)) ;

            }

        }

        return null ;
    }

    private static void displayRendezVousTable(ArrayList<RenderVous> data) {
        // Define the column headers
        String[] headers = {"Nom", "Prénom", "Téléphone", "CIN", "Sexe", "Date de lancement", "Date de rendez-vous"};

        // Determine the maximum length of each column to calculate the width of each column
        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = headers[i].length();
        }
        for (RenderVous rdv : data) {
            colWidths[0] = Math.max(colWidths[0], rdv.getNom().length());
            colWidths[1] = Math.max(colWidths[1], rdv.getPrenom().length());
            colWidths[2] = Math.max(colWidths[2], rdv.getTel().length());
            colWidths[3] = Math.max(colWidths[3], rdv.getCIN().length());
            colWidths[4] = Math.max(colWidths[4], rdv.getSexe().length());
            colWidths[5] = Math.max(colWidths[5], rdv.getLancer().length());
            colWidths[6] = Math.max(colWidths[6], rdv.getRendezVousDay().length());
        }

        // Construct the format string for each row
        StringBuilder rowFormat = new StringBuilder();
        for (int width : colWidths) {
            rowFormat.append("| %-" + width + "s ");
        }
        rowFormat.append("|\n");

        // Print the headers
        System.out.format(rowFormat.toString(), (Object[]) headers);

        // Print the separator line
        for (int width : colWidths) {
            System.out.print("+");
            for (int i = 0; i < width + 2; i++) {
                System.out.print("-");
            }
        }
        System.out.println("+");

        // Print the data
        for (RenderVous rdv : data) {
            Object[] rowData = {rdv.getNom(), rdv.getPrenom(), rdv.getTel(), rdv.getCIN(), rdv.getSexe(), rdv.getLancer(), rdv.getRendezVousDay()};
            System.out.format(rowFormat.toString(), rowData);
        }
    }




}
