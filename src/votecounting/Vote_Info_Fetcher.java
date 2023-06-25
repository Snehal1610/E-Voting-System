/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votecounting;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 4250
 */
public class Vote_Info_Fetcher 
{
     public ArrayList getVoteData()
    {
       ArrayList mas=new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();  
            
            String query="select * from vote_info ";
            
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                ArrayList a1=new ArrayList();
                a1.add(rs.getString(1));
                a1.add(rs.getString(2));
                a1.add(rs.getString(3));
                a1.add(rs.getString(4));
                a1.add(rs.getString(5));
                a1.add(rs.getString(6));
                a1.add(rs.getString(7));
             //   a1.add(rs.getString(8));
                mas.add(a1);
            }
            System.out.println("mas is: "+mas);
            conn.close();
            st.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception is:"+ex);
        }
        return mas;
    }
}
