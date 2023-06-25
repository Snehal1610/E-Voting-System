

package userreg_otp;
import java.util.ArrayList;


public class OTPGenSupporter
{
    
    public String getKey()
    {
        ArrayList param=new ArrayList();
         String value=new CurrentDate().getDate();
        
    
        value=value.trim();
        value=value.replace(" " ,"");
        value=value.replace(":","");
        value=value.replace("-","");
    
        
        param.add(value);
        int sum=0;
        for(int i=0;i<value.length();i++)
        {
            char ch=(char)value.charAt(i);
            int alpha=(int)ch;
            sum=sum+alpha;
            
             //   System.out.println(alpha);
            
        }
       // System.out.println("Sum is " +sum);
      //  int kid=sum%7;
//        System.out.println("KID is " +kid);
        param.add(Integer.toString(sum));

       String k= new OTPGen().getOTP(param);
        
        return(k);
    }
    
}
