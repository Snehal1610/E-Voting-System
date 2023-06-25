/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author welcome
 */
public class Vote_Insertion 
{
    public boolean isInsert(String srno, String aadharcard, String votername, String constituency, String candidatename, String partyname, String datetime, String hashkey)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement(); 
            
            String query="Insert into vote_info values('"+srno+"','"+aadharcard+"','"+votername+"','"+constituency+"','"+candidatename+"','"+partyname+"','"+datetime+"','"+hashkey+"')";
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else 
                flag=false;
            
            conn.close();
            st.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
        return flag;
    }
}
