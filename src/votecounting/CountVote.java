/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votecounting;

import java.util.ArrayList;
import java.util.HashSet;
import rcc.ReverseDecryptionHelper;

/**
 *
 * @author welcome
 */
public class CountVote
{
    
    public void getVoteCount(ArrayList partyname,ArrayList masdata,String con)
    {
      String dkey="X134SY";
      ArrayList freq=new ArrayList();
       ReverseDecryptionHelper rdh=new ReverseDecryptionHelper();
        for (int i = 0; i < partyname.size(); i++)
        {
            String pname=(String)partyname.get(i);
            int count=0;
            ArrayList temp=new ArrayList();
            temp.add(pname);
            
            for (int j = 0; j < masdata.size(); j++)
            {
                ArrayList row=(ArrayList)masdata.get(j);
                String enccons=(String)row.get(3);
                String plaincon= rdh.startDecryption(enccons, dkey);
                if(plaincon.equals(con))
                {
                    String encpart=(String)row.get(5);
                String plainparty= rdh.startDecryption(encpart, dkey);
                if(plainparty.equals(pname))
                    count++;
                }
                
                
            }
            temp.add((Integer.toString(count)));
            freq.add(temp);
        }
      
        
        System.out.println("Frequency of Vote count is "+freq);
//         
            int rowcount=freq.size();
            String votecount[][]=new String[rowcount][2];
            int j=0;
            for (int i = 0; i < freq.size(); i++) 
            {
                ArrayList row1=(ArrayList)freq.get(i);
                String party_name=(String)row1.get(0);
               
                votecount[j][0]=party_name;
               String count=(String)row1.get(1);
             
                votecount[j][1]=count;
                j++;
            }
            
            Vote_Count_Frame.votecount=votecount;
    }
}
