/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;
import java.sql.*;
import java.util.Scanner;


public class Patient {
    private Connection connection;
    private Scanner scanner;
    
    public Patient(Connection connection , Scanner scanner)
    {
        this.connection = connection;
        this.scanner = scanner;
        
    }
    public void addPatient()
    {
        System.out.print("Enter your name");
        String name = scanner.next();
        System.out.print("Enter your Age");
        int age = scanner.nextInt();
         System.out.print("Enter your gender");
        String gender = scanner.next();
        
        try{
            String query = "INSERT INTO patients(name , age , gender) VALUES (? , ? , ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            int affectedRows = ps.executeUpdate();
            if(affectedRows>0)
            {
                System.out.println("Patient Added Succesfully");
            }
            else
            {
                System.out.println("Patient Added Succesfully");
            }
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void viewPatients()
    {
        String query = "Select * from patients";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("Patients");
            System.out.println("+-------------+---------+--------+--------+");
            System.out.println("| Patient ID |+|  Name |+| Age | + |Gender|");
            System.out.println("+-------------+---------+--------+--------+");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                System.out.printf("|%-12s|%-20s|%-10s|%-12s\n" , id , name , age , gender);
                System.out.println("+-------------+---------+--------+--------+");   
            }
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
        public boolean getPatientById(int id)
        {
            String query = "Select * from patients where id = ?";
            try
            {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
            }
            catch(SQLException e)
            {
            e.printStackTrace();
            }
        return false;
            
        }

    void viewPatient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
