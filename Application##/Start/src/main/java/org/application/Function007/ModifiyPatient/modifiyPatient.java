package org.application.Function007.ModifiyPatient;

import org.application.Gere_BD.prepare;
import org.application.ValidationInput.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class modifiyPatient {

    public static void modifiyrPatient() throws SQLException {

        // Code pour modifiyrPatient

        Scanner scanner = new Scanner(System.in);


        System.out.println("Saisir le CIN : ");
        String cin = scanner.nextLine();

        int id =  checkCIN(cin) ;

        if (id!=-1)
           getNewInfo(id) ;
        else
            System.err.println("Patient don't exist in basDone");


    }

    private static void getNewInfo(int id) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String phoneNumber = validation.validatePhoneNumberInput(scanner, "Update numéro de téléphone : ", "^\\d{10}$");

        updateData(id,phoneNumber) ;

    }

    private static void updateData(int id, String phoneNumber) throws SQLException {

        Connection connection = prepare.getConnection() ;

        String update = "UPDATE patient set tel=? where idPatient=? ";
        PreparedStatement ps = connection.prepareStatement(update) ;
        ps.setString(1,phoneNumber);
        ps.setInt(2,id);

        int op = ps.executeUpdate() ;

        if (op>0)
            System.out.println("Update tele is suces");
        else
            System.err.println("Update tele is Not suces");


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
