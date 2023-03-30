package org.application.Function.Affiher_RendezVous;

import org.application.Function.Add.RenderVous;
import org.application.Gere_BD.prepare;

import java.sql.*;
import java.util.ArrayList;

public class afficher_rendezvous {

    public static void afficherTousRendezVous() throws SQLException {
        // Code pour afficher tous les patients
        System.out.println("Afficher tous les patients");

       ArrayList<RenderVous> liste =  prepareListe() ;

        displayRendezVousTable(liste) ;
    }

    private static ArrayList<RenderVous> prepareListe() throws SQLException {

        ArrayList<RenderVous> data = new ArrayList<>() ;


        Connection etat = prepare.getConnection() ;

        if (true) {
            String ModifiyNewRendezVous = "";
            PreparedStatement ps = etat.prepareStatement(ModifiyNewRendezVous);

            ResultSet rs = ps.executeQuery() ;

            String nom,prenom,tel,cin,dateLancer,dateRendezVous,sexe ;

            while (rs.next())
            {
                nom = rs.getString(1) ;
                prenom = rs.getString(2) ;
                tel = rs.getString(3) ;
                cin = rs.getString(4) ;
                sexe = rs.getString(5) ;
                dateLancer = String.valueOf(rs.getDate(6));
                dateRendezVous = String.valueOf(rs.getDate(7));

                data.add(new RenderVous(nom,prenom,tel,cin,sexe,dateLancer,dateRendezVous)) ;
            }
            return data ;

        }

        return data ;
    }

    public static void displayRendezVousTable(ArrayList<RenderVous> data) {
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
