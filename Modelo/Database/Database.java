/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Student
 */
public class Database {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/vehiclerentalsystem";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    
    static public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
