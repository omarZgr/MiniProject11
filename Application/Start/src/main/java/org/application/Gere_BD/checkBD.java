package org.application.Gere_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkBD {

    public static boolean check(String nom, String prenom, String cin, String rendezVousDay) throws SQLException {

        Connection etat = prepare.getConnection();

        if (true) {
            String query = "";
            PreparedStatement ps = etat.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return true ;
            else
            {
                return false;
            }

        }
        else
            System.err.println("Connexion invalid with BD");

        return false ;


    }



}
