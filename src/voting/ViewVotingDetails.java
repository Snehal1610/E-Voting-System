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
import rcc.ReverseDecryptionHelper;


/**
 *
 * @author welcome
 */
public class ViewVotingDetails 
{
    public void getViewVoting()
    {
          String dkey="X134SY";
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureevoting","root","root");
            Statement st1=conn.createStatement();
            Statement st2=conn.createStatement();
            String query="select * from vote_info";
            ResultSet rs1=st1.executeQuery(query);
            ResultSet rs2=st2.executeQuery(query);
            
            
            ReverseDecryptionHelper rdh=new ReverseDecryptionHelper();
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            String data[][]=new String[row][8];
            int i=0;
            while(rs2.next())
            {
                String sr_no=rs2.getString(1);
                data[i][0]=sr_no;
                
                String aadharcard=rs2.getString(2);
                String aadharcardno=rdh.startDecryption(aadharcard, dkey);
                data[i][1]=aadharcardno;
                
                String voter_name=rs2.getString(3);
                 String votername=rdh.startDecryption(voter_name, dkey);
                data[i][2]=votername;
                
                String constituency=rs2.getString(4);
                String constituency1=rdh.startDecryption(constituency, dkey);
                data[i][3]=constituency1;
                
                String candidate_name=rs2.getString(5);
                String candidatename=rdh.startDecryption(candidate_name, dkey); 
                data[i][4]=candidatename;
                
                String party_name=rs2.getString(6);
                String partyname=rdh.startDecryption(party_name, dkey);
                data[i][5]=partyname;
                
                String date_time=rs2.getString(7);
                String datetime=rdh.startDecryption(date_time, dkey);
                data[i][6]=datetime;
                
                String hash_key=rs2.getString(8);
                data[i][7]=hash_key;
                
                
                   i++;
            }
            ViewVoteFrame.data=data;
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
    }
}
