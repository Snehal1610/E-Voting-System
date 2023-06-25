/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rcc;

/**
 *
 * @author Dilip
 */
public class ReverseEncryption {

    public String getReverseEn(String str, String key) {
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {

            char ch = key.charAt(i);
            int alpha = (int) ch;
            sum = sum + alpha;

        }
        // System.out.println("SUM IS E  "+sum);
        int value = sum % 10;

        String res = "";

        char ch[] = str.toCharArray();

        String pp = "";

        for (int i = 0; i < ch.length; i++) {

            char c = ch[i];
            int y = c;

            int a = y;
           // if (a < 161)
            {

                int f = a + value;  //171   162

                char chh = (char) f;

                String pr = Character.toString(chh);
                pp = pp + pr;
            }

        }

        res = pp;

        return res;
    }

}
