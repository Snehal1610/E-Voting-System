/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author welcome
 */
public class AddCandidateInfo 
{
    public boolean doAddCandidate(String name,String age,String sex,String nationality,String qualification,String worth,String profession,String constituency,String symbolname,String path,String partyname)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();
             
            
          //  String query="insert into candidate_info values ('"+name+"','"+age+"','"+sex+"','"+qualification+"','"+worth+"','"+profession+"','"+symbolname+"','"+partyname+"')";
           
            
            PreparedStatement ps=conn.prepareStatement("insert into candidate_info values(?,?,?,?,?,?,?,?,?,?,?) ");
             ps.setString(1,name);  
               ps.setString(2,age);  
               ps.setString(3,sex); 
               ps.setString(4,nationality);
               ps.setString(5,qualification);  
               ps.setString(6,worth);  
               
               ps.setString(7,profession);  
               ps.setString(8,constituency); 
               ps.setString(9, symbolname);
             if(path==null)
          {
               String str = "symbol";
              byte[] content = str.getBytes();
              Blob blob = ps.getConnection().createBlob();
              blob.setBytes(1, content);
              ps.setBlob(10, blob);
          }
          else
          {
              FileInputStream fis=new FileInputStream(path);
               ps.setBinaryStream(10,fis,fis.available());
          }
             ps.setString(11,partyname); 
              int x=ps.executeUpdate();
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
