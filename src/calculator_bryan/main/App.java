/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator_bryan.main;

import static calculator_bryan.main.CalculatorForm.pembagian;
import static calculator_bryan.main.CalculatorForm.pengurangan;
import static calculator_bryan.main.CalculatorForm.penjumlahan;
import static calculator_bryan.main.CalculatorForm.perkalian;


import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author asus
 */
public class App {
    public static void main(String[] args) {
        CalculatorForm kf = new CalculatorForm();
        kf.setLocationRelativeTo(null);
        kf.setVisible(true);
    }
    
    public static void tbl_calculator (Double angka1, Double angka2, String operator, Double hasil) {
     Connection connect;
     PreparedStatement pst;
     
     String url = "jdbc:mysql://localhost:3306/calculator";
     String username = "root";
     String password = "";
     String query ="INSERT INTO tbl_calculator (angka1, angka2, operator, hasil) values (?, ?, ?, ?)";
    
    try{
    connect = DriverManager.getConnection(url, username, password);
    pst = connect.prepareStatement(query);
    pst.setDouble(1, angka1);
    pst.setDouble(2, angka2);
    pst.setString(3, operator);
    pst.setDouble(4,hasil);
    pst.executeUpdate();
    pst.close();
    } catch (SQLException ex) {
            System.out.println("insert gagal:" + ex);
        }
    }

    public static Double hitung (Double angka1, Double angka2, String operator) {
        Double hasil = null;
        
         if (operator.equals("+")) {
            hasil = penjumlahan(angka1, angka2);
        } else if (operator.equals("-")) {
            hasil = pengurangan(angka1, angka2);
        } else if (operator.equals("*")) {
            hasil = perkalian(angka1, angka2);
        } else if (operator.equals("/")) {
            hasil = pembagian(angka1, angka2);
        }
         
         return hasil;
    }
}

