/* Author: Kevin Foong 23 Sept 2019

Method:
1. set input(only 1 input req) ..
2. declare and initialize variables ..//edit: simply subtract 65 from java unicode char value.
3. split in half(find within horizon), sum ..
4. rotate solution: %26
5. merge(sum/2 of each merging character)
6. print solution(should have half the number of char)
7. set rules

 */
import static java.lang.System.out;
import java.util.Scanner;

public class DRM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//create instance of Scanner

        String inputmessage = sc.next(); //input method

        if (inputmessage.length() <= 15000 && inputmessage == inputmessage.toUpperCase() && inputmessage.length()%2 == 0) {//conditions/rules set
            int cnum = inputmessage.length();//to determine no. of char in String

            //step 1: split
            String split1 = inputmessage.substring(0, cnum / 2);
            int sumS1 = 0;//sum of values in split1

            for (int charnum = 0; charnum < cnum / 2; charnum++) {
                sumS1 += split1.charAt(charnum) - 65;//minus 65 as in API, A is 65 and so on to normalise to 0.
            }
            //out.println(sumS1);//test statements
            //out.println(split1);

            String split2 = inputmessage.substring(cnum / 2, cnum);
            int sumS2 = 0; //sum of values in split2
            for (int charnum = 0; charnum < cnum / 2; charnum++) {
                sumS2 += split2.charAt(charnum) - 65;
            }
            //out.println(sumS2);
            //out.println(split2);

            //step 2: rotate & merge
            for (int charnum = 0; charnum < cnum / 2; charnum++) {
                int rotatecharvalS1 = ((split1.charAt(charnum) - 65 + sumS1) % 26);//rotates and finds val of char in API for String split1
                int rotatecharvalS2 = ((split2.charAt(charnum) - 65 + sumS2) % 26); //for String split2
                int mergeval = ((rotatecharvalS1 + rotatecharvalS2) % 26) + 65;
                char mergechar = (char) mergeval;
                out.print(mergechar);

            }
        }
        sc.close();//good practice to close Scanner instance.
    }
}


