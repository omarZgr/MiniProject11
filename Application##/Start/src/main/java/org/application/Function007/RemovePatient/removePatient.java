package org.application.Function007.RemovePatient;

import org.application.Gere_BD.prepare;
import org.application.ValidationInput.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class removePatient {

    public static void removePatient() throws SQLException {

        // Code pour removePatient

        Scanner scanner = new Scanner(System.in);


        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();

        int id =  checkCIN(cin) ;

        if (id!=-1)
            removePatient(id) ;
        else
            System.err.println("Patient don't exist in basDone");


    }


    private static void removePatient(int id) throws SQLException {

        Connection connection = prepare.getConnection() ;

        String update = "UPDATE patient set etat=false where idPatient=? ";
        PreparedStatement ps = connection.prepareStatement(update) ;
        ps.setInt(1,id);

        int op = ps.executeUpdate() ;

        if (op>0)
            System.out.println("Remove user is suces");
        else
            System.err.println("Remove user is Not suces");


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
