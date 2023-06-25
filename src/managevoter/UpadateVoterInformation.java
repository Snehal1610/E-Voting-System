/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managevoter;

import managecandidate.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author welcome
 */
public class UpadateVoterInformation
{
    public boolean doUpdateVoter(String name,String nationality,String age,String sex,String dob,String adharno,String email,String mobile,String address,String state)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st=conn.createStatement();
            
            String query="update voterinfo set nationality='"+nationality+"',age='"+age+"',sex='"+sex+"',dob='"+dob+"',adhar_number='"+adharno+"',email_id='"+email+"',mobile_number='"+mobile+"',permanent_address='"+address+"', state='"+state+"' where name='"+name+"'";
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else 
                flag=false;
            
//            conn.close();
//            st.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
        return flag;
    }
}
