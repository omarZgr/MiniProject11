package org.application;

import org.application.Function007.Menu;
import org.application.Gere_BD.prepare;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        checkBD() ;
        while (true)
        Menu.AfficherMenu();

    }

    private static void checkBD()  {

        try {
            Connection etat = prepare.getConnection() ;
            System.out.println("Welcome to App");
        }
        catch (Exception e)
        {
            System.err.println("Error connecting to database: " + e.getMessage());
            System.exit(0);

        }



    }


}