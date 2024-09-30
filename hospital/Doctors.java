/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Doctors {
    
    private Connection connection;
//    private Scanner scanner;
    
    public Doctors(Connection connection)
    {
        this.connection = connection;
//        this.scanner = scanner;
        
    }
    
            
    
    public void viewDoctors()
    {
        String query = "Select * from doctors";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("Doctors");
            System.out.println("+-------------+---------+--------------+");
            System.out.println("| Doctor ID |+|  Name |+|Specialisation|");
            System.out.println("+-------------+--------+---------------+");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String special = rs.getString("specialisation");
                System.out.printf("|%-18s|%-20s|%-12s\n",id , name , special);
                System.out.println("+-------------+---------+--------+--------+");   
            }
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
        public boolean getDoctorById(int id)
        {
            String query = "Select * from doctors where id = ?";
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
        
}
    

