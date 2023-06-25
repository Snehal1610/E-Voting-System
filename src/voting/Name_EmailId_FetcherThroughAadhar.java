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
public class Name_EmailId_FetcherThroughAadhar
{
    public ArrayList getDataRelatedAadhar(String aadharno)
    {
      ArrayList data=new ArrayList();
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();  
            
            String query="select * from voterinfo where adhar_number='"+aadharno+"'";
            
            ResultSet rs=st.executeQuery(query);
            
              while(rs.next())
            {
                data.add(rs.getString(1));
                data.add(rs.getString(7));
              
            }
          //  System.out.println("data is: "+data);
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
