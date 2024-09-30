
package hospital;

import java.sql.*;
import java.util.Scanner;
public class HospitalManagementSystem
{
    private static final String url ="jdbc:mysql://localhost:3306/hospital";
    private static final String username ="root";
    private static final String password ="root";
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc= new Scanner(System.in);
        try{
            Connection con = DriverManager.getConnection(url , username , password);
            Patient patient = new Patient(con,sc );
            Doctors doctor = new Doctors(con);
            while(true)
            {
                System.out.println("||Hospital Management System||");
                System.out.println("1 . Add Patients");
                System.out.println("2 . View Patients");
                System.out.println("3 . Check Patients");
                System.out.println("4 . Book Appoitnment");
                System.out.println("5 . Exit");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                
                switch(choice)
                {
                    case 1 : patient.addPatient();
                         break;
                    case 2 : patient.viewPatients();
                           break;
                           
                    case 3 : doctor.viewDoctors();
                         break;
//                    case 4 : 
//                           break;
                           
                    case 5 :break;
                    default : System.out.println("Enter valid choice");
                           
                }
                
            }
            
        }
        catch(Exception e){
            
            
        }
    }
//    public static void bookAppointment(Patient patient , Doctor doctor , Connection con , Scanner sc)
//    {
//        System.out.println("Enter patient id");
//        int pid = sc.nextInt();
//        System.out.println("Enter Doctor id");
//        int did = sc.nextInt();
//        System.out.println("Enter appointment date (YYYY-MM-DD)");
//        String dates = sc.next();
//        if(patient.getPatientById(pid) && doctor.getDoctorById(did))
//            
//        {
//            if(checkDoctor(did , dates))
//            {
//                String query = "Insert into appointments(pid , did , dates) values( ? , ? , ?)";
//                try{
//                    
//                }catch(Ecxeption e)
//                {
//                    
//                }
//            }
//            else
//            {
//                System.out.println("Not Avaiable");
//            }
//        }
//        else
//        {
//            System.out.println("Doesnt exsist");
//        }
//        
//    }
}
