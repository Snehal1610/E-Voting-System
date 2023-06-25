/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managevoter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author welcome
 */
public class ViewVoterDetails 
{
    public void getViewVoter()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st1=conn.createStatement();
            Statement st2=conn.createStatement();
            String query="select * from voterinfo";
            ResultSet rs1=st1.executeQuery(query);
            ResultSet rs2=st2.executeQuery(query);
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            String data[][]=new String[row][10];
            int i=0;
            while(rs2.next())
            {
                String name=rs2.getString(1);
                data[i][0]=name;
                String nationality=rs2.getString(2);
                data[i][1]=nationality;
                String age=rs2.getString(3);
                data[i][2]=age;
                String sex=rs2.getString(4);
                data[i][3]=sex;
                String dob=rs2.getString(5);
                data[i][4]=dob;
                String adharno=rs2.getString(6);
                data[i][5]=adharno;
                String email=rs2.getString(7);
                data[i][6]=email;
                String mobile=rs2.getString(8);
                data[i][7]=mobile;
                String address=rs2.getString(9);
                data[i][8]=address;
                String state=rs2.getString(10);
                data[i][9]=state;
                
                   i++;
            }
            ViewVoterDetailsFrame.data=data;
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
    }
}
