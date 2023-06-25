/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class PartyNameFetcher 
{
    public String getPartyName(String candidatename)
    {
        String partyname="";
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();  
            String query="select * from candidate_info where candidate_name='"+candidatename+"'";
             ResultSet rs=st.executeQuery(query);
             while(rs.next())
             {
                partyname=rs.getString(11);
             }
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
        System.out.println("Party Name is: "+partyname);
        return partyname;
    }
}
