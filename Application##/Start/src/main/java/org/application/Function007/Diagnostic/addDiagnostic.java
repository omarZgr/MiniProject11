package org.application.Function007.Diagnostic;

import org.application.Gere_BD.prepare;
import org.application.ValidationInput.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class addDiagnostic {

    static Scanner scanner = new Scanner(System.in);

    public static void addDiagnostic() throws SQLException {

        // Code pour removePatient



        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();


        int id =  checkCIN(cin) ;

        if (id!=-1)
            createNouvelleDiagnostic(id) ;
        else
            System.err.println("Patient don't exist in basDone");


    }

    private static void createNouvelleDiagnostic(int id) throws SQLException {


        System.out.println("Saisir Description : ");
        String description = scanner.nextLine();


        Connection connection = prepare.getConnection() ;

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = currentDate.format(formatter);

        String  insertNewDiagnostic = "INSERT INTO diagnostic(idPatient,dateRendezVous,description) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(insertNewDiagnostic) ;

        ps.setInt(1,id);
        ps.setString(2,date);
        ps.setString(3,description);

        int op = ps.executeUpdate() ;

        if (op>0)
            System.out.println("add Diagnostic is suces");
        else
            System.err.println("add Diagnostic is Not suces");


    }

    private static int checkCIN(String cin) throws SQLException {

        Connection connection = prepare.getConnection() ;

        String query = "Select idPatient from patient where cin=? ";
        PreparedStatement ps = connection.prepareStatement(query) ;
        ps.setString(1,cin);

        ResultSet rs = ps.executeQuery() ;
        if (rs.next())
            return rs.getInt(1) ;

        return -1 ;
    }
}
