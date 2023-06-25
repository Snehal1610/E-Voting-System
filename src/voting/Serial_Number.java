/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting;

import java.util.ArrayList;
import rcc.ReverseDecryptionHelper;

/**
 *
 * @author welcome
 */
public class Serial_Number 
{
     public String getSerialNumber()
    {
         String dkey="X134SY";
       int sid=0;
        ArrayList serialNum=new Serial_Number_Fetcher().getSerialID();
        System.out.println("Serial Number is:"+serialNum);
        
        if (serialNum.size()==0)
        {
            sid=0;
        }
        else
        {
            String big=(String)serialNum.get(0);
            //String big1=new ReverseDecryptionHelper().startDecryption(big, dkey);
            System.out.println("Initial Sr number is : "+big);
            int bg=Integer.parseInt(big);
            
            for (int i = 0; i < serialNum.size(); i++) 
            {
                String si=(String)serialNum.get(i);
             //   String sri=new ReverseDecryptionHelper().startDecryption(si, dkey);
                 int s=Integer.parseInt(si);
                
                
                if(s>=bg)
                {
                    bg=s;
                }
          
            }
               sid=bg;
              
        }
        String srno=Integer.toString(sid);
        System.out.println("Biggest Serial Number is: "+sid);
        return srno;
    }
}
