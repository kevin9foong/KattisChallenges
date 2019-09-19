/* Author:
Kevin Foong 20/09/2019 1.57am

Method:
collect variable input test cases n
use n to limit the number of cases

if else decision making statement to decide, with condition.
print
 */
import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;

public class Oddities {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n, x; //no of test cases, input integer
        do {
            n = sc.nextInt();
        } while (n < 1 || n > 20);

        for (int count = 1; count <= n; ) {
            x = sc.nextInt();
            if (x <= 10 && x >= -10) {
                count++;
                if (x % 2 == 0) {
                    out.println(x + " is even");
                } else {
                    out.println(x + " is odd");
                }
            }
        }
    }
}
