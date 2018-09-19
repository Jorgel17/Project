package writers;

import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hallgeir
 */
public class UserWriter {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
 public void skrivStudentForm(int snr, String firstName, String lastName, PrintWriter out)
    {
        
        skrivHtmlHeader(out, "UiA-Studenter");
        out.println("<h1> Student </h1>");
        out.println("<h1> En Student </h1>");
        
        String DIV ="<div class = '%s'>";
        String FORMs  = "<form action = '%s'  method = POST>";  
        String INP = "<input type='%s' & name='%s' & value='%s'>" +"<br>"; 
        String INPSUB = "<input type='%s' & name='%s' & value='%s'>" +"  ";
        
        out.format(FORMs, "AddUser"); 
               
        // -------------- SNR  ------------------------------ 

        // -------------- SNR  ------------------------------ 
        out.format(DIV, "ledetekst");
        out.println ("Fornavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "firstName", firstName);
        out.println("</div>"); 
        
           
        // --------------Etternavn ------------------------------- 
        out.format(DIV, "ledetekst");
        out.println ("Etternavn: " +"</div>");
        
        out.format(DIV, "inn");
        out.format(INP, "text", "lastName", lastName);
        out.println("</div>"); 
        
        // -------------- Operatorer -------------------------------
        
         out.format(DIV, "inn");
         
        out.format(INPSUB, "Submit", "valg", "Oppdater");   // type navn ledetekst
        out.format(INPSUB, "Submit","valg", "Ny");
        out.format(INPSUB,"Submit", "valg", "Clear");

        out.println("</div>");
        
        out.println(" <br>");        
        out.println("</form>");  
        out.println("");  
        out.println("</div>");  
    }
    
    public void skrivHtmlHeader(PrintWriter out,  String tittel)
 {
      out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>" +tittel +"</title>");  
       out.println("<meta charset=\"UTF-8\">");    
       out.println("<link rel=\"stylesheet\" href=\"css.css\">");
            
       out.println("</head>");
 }
}