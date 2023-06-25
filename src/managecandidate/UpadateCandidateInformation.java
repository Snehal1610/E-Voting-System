/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
/**
 *
 * @author welcome
 */
public class UpadateCandidateInformation
{
    public boolean doUpdateCandidate(String name,String age,String sex,String nationality,String qualification,String worth,String profession,String constituency,String symbolname,FileInputStream fis1,String partyname)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
          //  Statement st=conn.createStatement();
            
            
            PreparedStatement ps=conn.prepareStatement("update candidate_info set age=?,sex=?,nationality=?,qualification=?,worth=?,profession=?,constituency=?,symbol_name=?,symbol=?,party_name=? where candidate_name=?");
            
               ps.setString(1,name);  
               ps.setString(2,age);  
               ps.setString(3,sex);  
               ps.setString(4, nationality);
               ps.setString(5,qualification);  
               ps.setString(6,worth);  
               
               ps.setString(7,profession);  
               ps.setString(8,constituency);  
               ps.setString(9,symbolname); 
               
               
              
              
              
               
           
             
                    ps.setBinaryStream(10,fis1,fis1.available());
               
                      System.out.println("New image1 inserted ");           
             
             
              ps.setString(11,partyname); 
            int x=ps.executeUpdate();
            if(x>0)
                flag=true;
            else 
                flag=false;
            
            conn.close();
            ps.close();
        }
        catch(IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex)
        {
            System.out.println("Exception is: "+ex);
        }
        
//     
        return flag;
    }
}
