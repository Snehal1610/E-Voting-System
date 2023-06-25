/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure_evoting_0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *secureevoting;
 * @author welcome
 */
public class UpdateAdminProfile 
{
    public boolean doUpdate(String username,String password)
    {
        
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting", "root", "root");
            Statement st=conn.createStatement();
            
            String query="update admin_info set password='"+password+"' where user_name='"+username+"'";
            
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
