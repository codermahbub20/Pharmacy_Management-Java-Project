package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Tables {

    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();

            // Creating the 'appuser' table
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS appuser (appuser_pk INT AUTO_INCREMENT PRIMARY KEY, " +
                    "userRole VARCHAR(200), name VARCHAR(200), dob VARCHAR(200), mobileNumber VARCHAR(50), " +
                    "email VARCHAR(200), username VARCHAR(200), password VARCHAR(50), address VARCHAR(200))");

            // Inserting a sample record into the 'appuser' table
            stm.executeUpdate("INSERT INTO appuser (userRole, name, dob, mobileNumber, email, username, password, address) " +
                    "VALUES ('Admin', 'Admin', '20-02-2001', '01613805702', 'ahsanhaibrahat11@gmail.com', 'Ahsan', '123', 'Bangladesh')");

            // Creating the 'medicine' table
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS medicine (medicine_pk INT AUTO_INCREMENT PRIMARY KEY, " +
                    "uniqueID VARCHAR(200), name VARCHAR(200), companyName VARCHAR(200), quantity BIGINT, price BIGINT)");
           // stm.executeUpdate("create table bill (bill_pk int AUTO_INCREMENT primary key,billId varchar (200),billDate varchar(50),totalPaid BIGINT,generatedBy varchar(50))");

            JOptionPane.showMessageDialog(null, "Tables Created Successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
