/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class CandidateInformationFetcher 
{
    public ArrayList getCandidateData(String name)
    {
       ArrayList a1=new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();  
            
            String query="select * from candidate_info where candidate_name='"+name+"'";
            
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                a1.add(rs.getString(2));
                a1.add(rs.getString(3));
                a1.add(rs.getString(4));
                a1.add(rs.getString(5));
                a1.add(rs.getString(6));
                a1.add(rs.getString(7));
                a1.add(rs.getString(8));
                a1.add(rs.getString(9));
                Blob b1 = rs.getBlob("symbol");
                byte barr1[]=b1.getBytes(1,(int)b1.length());
                a1.add(barr1);
                a1.add(rs.getString(11));
                
            }
            System.out.println("a1 is: "+a1);
            conn.close();
            st.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception is:"+ex);
        }
        return a1;
    }
}
