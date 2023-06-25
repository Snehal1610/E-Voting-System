/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userreg_otp;

import java.util.ArrayList;

public class OTPGen {

    String key = "";

    public String getOTP(ArrayList param) {

//       ArrayList param=new ArrayList();
//       param=new KeyHelper().getKeyID();
        String textLine = (String) param.get(0);

        // System.out.println("text "+textLine);
        MD5 m = new MD5();
        textLine = m.MDfive(textLine);

        String KID = (String) param.get(1);

        textLine = textLine.replaceAll(" ", "");
        //textLine = textLine.replaceAll(" ", ".");

        // System.out.println(textLine);
        char charRandom[] = textLine.toCharArray();
        int userNo = Integer.parseInt(KID) % 7;
        if (userNo == 0) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 1;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                    charRandom = rotate(charRandom);

                } else {
                    i = 0;
                }

            }
        }
        if (userNo == 1) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 2;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                    charRandom = rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
        if (userNo == 2) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 3;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                    charRandom = rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
        if (userNo == 3) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 4;
                if (i < textLine.length()) {

                    key = key + charRandom[i];
                    charRandom = rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
        if (userNo == 4) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 5;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                    charRandom = rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
        if (userNo == 5) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 6;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                    charRandom = rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
        if (userNo == 6) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 7;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                    charRandom = rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }

        key = key.toUpperCase();
        return (key);

    }

    /*    public static void main(String[] args)

     {
        // TODO code application logic here
      RandomChar rc= new RandomChar();
        System.out.println(rc.key);
    }*/

    public char[] rotate(char Array[]) {
        char temp;

        temp = Array[Array.length - 1];
        Array[Array.length - 1] = Array[0];
        for (int i = 0; i < Array.length - 1; i++) {
            Array[i] = Array[i + 1];

        }
        Array[Array.length - 2] = temp;
        return Array;
    }

}
