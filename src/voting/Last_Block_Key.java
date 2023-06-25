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

/**
 *
 * @author 4250
 */
public class Last_Block_Key 
{
    public String getBlockHeadKey()
    {
      String blockhead="";
        String bigsrno=new Serial_Number().getSerialNumber();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();  
            
            String query="select * from vote_info where sr_no='"+bigsrno+"' ";
             ResultSet rs=st.executeQuery(query);
             if(rs.next())
             {
                blockhead=rs.getString(8);
             }
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
        System.out.println("Block Head key: "+blockhead);
        return blockhead;
    }
}
