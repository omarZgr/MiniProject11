package org.application.Function007.ListePatients;

import org.application.Function.Add.RenderVous;
import org.application.Function007.AddPatient.Patient;
import org.application.Gere_BD.prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListePatients {

    public static void ListePatients() throws SQLException
    {

        // Code pour afficher tous les patients ;

        ArrayList<Patient> liste =  prepareListe() ;

        displayRendezVousTable(liste) ;
    }

    private static ArrayList<Patient> prepareListe() throws SQLException
    {

        ArrayList<Patient> data = new ArrayList<>() ;


        Connection etat = prepare.getConnection() ;

        if (true) {
            String cmd = "Select * from patient";
            PreparedStatement ps = etat.prepareStatement(cmd);

            ResultSet rs = ps.executeQuery() ;

            String nom,prenom,tel,cin,dateNaissance,dateCreate,sexe,etat001  ;

            while (rs.next())
            {
                nom = rs.getString("nom") ;
                prenom = rs.getString("prenom") ;
                tel = rs.getString("tel") ;
                cin = rs.getString("cin") ;
                sexe = rs.getString("sexe") ;
                etat001 = rs.getString("etat") ;
                dateNaissance = String.valueOf(rs.getDate("dateNaissance"));
                dateCreate = String.valueOf(rs.getDate("dateCreate"));

                data.add(new Patient(nom,prenom,tel,cin,sexe,dateNaissance,dateCreate,etat001)) ;
            }
            return data ;

        }

        return data ;
    }

    public static void displayRendezVousTable(ArrayList<Patient> data) {
        // Define the column headers
        String[] headers = {"Nom", "Prénom", "Téléphone", "CIN", "Sexe", "Date de Naissence", "Date de Dignostic","Etat"};

        // Determine the maximum length of each column to calculate the width of each column
        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = headers[i].length();
        }
        for (Patient rdv : data) {
            colWidths[0] = Math.max(colWidths[0], rdv.getNom().length());
            colWidths[1] = Math.max(colWidths[1], rdv.getPrenom().length());
            colWidths[2] = Math.max(colWidths[2], rdv.getTel().length());
            colWidths[3] = Math.max(colWidths[3], rdv.getCIN().length());
            colWidths[4] = Math.max(colWidths[4], rdv.getSexe().length());
            colWidths[5] = Math.max(colWidths[5], rdv.getDateNaissence().length());
            colWidths[6] = Math.max(colWidths[6], rdv.getDateCreate().length());
            colWidths[7] = Math.max(colWidths[7], rdv.getEtat().length());
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
        for (Patient rdv : data) {
            Object[] rowData = {rdv.getNom(), rdv.getPrenom(), rdv.getTel(), rdv.getCIN(), rdv.getSexe(), rdv.getDateNaissence(), rdv.getDateCreate(),rdv.getEtat()};
            System.out.format(rowFormat.toString(), rowData);
        }
    }
}
