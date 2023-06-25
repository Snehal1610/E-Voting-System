/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting;

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
public class Constituency_Selection 
{
    public ArrayList getDataRelatedConstituency(String constituency)
    {
        ArrayList data=new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();  
            
            String query="select * from candidate_info where constituency='"+constituency+"'";
            
            ResultSet rs=st.executeQuery(query);
            
              while(rs.next())
            {
                ArrayList in=new ArrayList();
                in.add(rs.getString(1));
                Blob b1 = rs.getBlob("symbol");
                byte barr1[]=b1.getBytes(1,(int)b1.length());
                in.add(barr1);
                data.add(in);
            }
            System.out.println("data is: "+data);
            conn.close();
            st.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
        return data;
    }
}
