
package userreg_otp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.*;
import java.util.*;




 public class CurrentDate
 {
public String getDate()
{

 Calendar cal = Calendar.getInstance();
  					
 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");


 String p=dateFormat.format(cal.getTime());

// System.out.println("time is "+p);
  				
return p;

}

 }