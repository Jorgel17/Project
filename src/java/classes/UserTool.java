package Classes;

import java.io.PrintWriter;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author hallgeir
 */
public class UserTool {
    Connection conn;        // Must be defined here as class variables, get their value in the login method
    Statement stmt;
    
    PreparedStatement insertStudent; 
    
 public void skrivStudenter(PrintWriter out, Connection conn)
    { 
        String STUDENT  = "<li><a href='studentDetail?u_firstname=%s&u_lastname=%s'>%s %s</a></li>\n"; 
         
        PreparedStatement getStudents; 
         
        
        try {
            getStudents = conn.prepareStatement("select * from users");
            //getStudents.setString(1,"u_firstname");

            ResultSet rset = getStudents.executeQuery();

            // Step 4: Process the ResultSet by scrolling the cursor forward via next().
            //  For each row, retrieve the contents of the cells with getXxx(columnName).
            out.println("The records selected are:" +"<br>");
            int rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                try {
                    String firstName = rset.getString("u_firstname");
                    String lastName   = rset.getString("u_lastname");
                    //out.println(rowCount +": " + firstName + ", " + lastName +"<br>");
                    out.format(STUDENT,firstName,lastName, firstName,lastName);

                    ++rowCount;
                } catch (Exception exception) {
                    out.println("Unable to map row" + exception);
                }
            }  // end while
            out.println("Total number of records = " + rowCount);

            out.format(STUDENT,"","", "new","new");

        } // end try     
        catch (SQLException ex) {
            out.println("Ikke hentet fra DB " +ex);
        }
         /*try {
                getStudents = conn.prepareStatement("select * from users");
                //getStudents.setString(1,"u_firstname");
                
                ResultSet rset = getStudents.executeQuery();
 
                // Step 4: Process the ResultSet by scrolling the cursor forward via next().
                //  For each row, retrieve the contents of the cells with getXxx(columnName).
                out.println("The records selected are:" +"<br>");
                int rowCount = 0;
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    
                    String firstName = rset.getString("u_firstname");
                    String lastName   = rset.getString("u_lastname");
                    out.println(rowCount +": " + firstName + ", " + lastName +"<br>");
                    out.format(STUDENT,firstName,lastName, firstName,lastName);
                                      
                    out.println(rowCount);
                 }  // end while
                 out.println("Total number of records = " + rowCount);
                 
                  out.format(STUDENT,"","", "new","new");
                 
         } // end try     
         catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
         }*/
   }   

     
  
  
  
  public void newUser(String firstName, String lastName, PrintWriter out, Connection conn) {
        PreparedStatement newUser; 
        out.println("Inni newStudent");
         try {
             String ins ="insert into Project.users (u_firstname,u_lastname)  values (?, ?)";
          
             newUser = conn.prepareStatement(ins);
     
             newUser.setString(1,firstName);             
             newUser.setString(2,lastName);  
                
             out.println(newUser);
             newUser.executeUpdate();

             
      } // end try     
         catch (SQLException ex) {
                out.println("Ikke fått opprettet NY bruker " +ex);
         }
  }
  
  
  
  
}// slutt