/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author welcome
 */
public class ViewCandidateInformation
{
    public void getViewCandidate()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st1=conn.createStatement();
            Statement st2=conn.createStatement();
            String query="select * from candidate_info";
            ResultSet rs1=st1.executeQuery(query);
            ResultSet rs2=st2.executeQuery(query);
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            String data[][]=new String[row][2];
            int i=0;
            while(rs2.next())
            {
                String name=rs2.getString(1);
                data[i][0]=name;
               
                String constituency=rs2.getString(7);
                data[i][1]=constituency;
                
                
                   i++;
            }
            ViewCandidateFrame.data=data;
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
    }
}
