/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votecounting;

import java.util.ArrayList;
import voting.MD5Hash;

/**
 *
 * @author welcome
 */
public class Sorting_BlockKey_Generation 
{
    public String getBlockKey(ArrayList masterdata)
    {
        String blockheadkey="";
         for (int i = 0; i < masterdata.size()-1; i++) 
        {
           
            for (int j = i+1; j < masterdata.size(); j++)
            {
                ArrayList row1=(ArrayList)masterdata.get(i);
            String srno1=(String)row1.get(0);
            int sr_no1=Integer.parseInt(srno1);
            
                ArrayList row2=(ArrayList)masterdata.get(j);
                String srno2=(String)row2.get(0);
                int sr_no2=Integer.parseInt(srno2);
                System.out.println("sr_no1: "+sr_no1);
                 System.out.println("sr_no2: "+sr_no2);
                
                if(sr_no1 > sr_no2)
                {
                    
                    masterdata.set(i, row2);
                    masterdata.set(j, row1);
                }
//                System.out.println("Instance Sorted ");
//                  for (int k = 0; k < masterdata.size(); k++) 
//                  {
//                        ArrayList temp=(ArrayList)masterdata.get(k);
//                        System.out.println(temp);
//                        
//                    
//                }
            }
//            System.out.println(" -------------------------------------------------------------------------\n ");     
        }
        
      System.out.println("Master data:"+masterdata);
        for (int i = 0; i < masterdata.size(); i++) 
        {
            ArrayList row1=(ArrayList)masterdata.get(i);
            String srno=(String)row1.get(0);
            String aadharcard=(String)row1.get(1);
            String votername=(String)row1.get(2);
            String constituency=(String)row1.get(3);
            String candidatename=(String)row1.get(4);
            String partyname=(String)row1.get(5);
            String datetime=(String)row1.get(6);
          
            
            System.out.println(srno+", "+aadharcard+" , "+votername+" , "+constituency+" , "+candidatename+" , "+partyname+" , "+datetime);
            
            String Data=srno+aadharcard+votername+constituency+candidatename+partyname+datetime;
              String text=Data + blockheadkey;
              
             String hash = new MD5Hash().MDfive(text);
             char ch1=hash.charAt(0);
             char ch2=hash.charAt(5);
             char ch3=hash.charAt(11);
             char ch4=hash.charAt(14);
             char ch5=hash.charAt(23);
             char ch6=hash.charAt(26);
            
              blockheadkey=Character.toString(ch1)+Character.toString(ch2)+Character.toString(ch3)+Character.toString(ch4)+Character.toString(ch5)+Character.toString(ch6);
            
           
             
             
        }
        //System.out.println("Block Head Key: "+blockheadkey);
        return blockheadkey;
    }
}
