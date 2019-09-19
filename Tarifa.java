/* Author:
Kevin Foong

Method:
Define the variables.
find and add the remainders every month
display the remainders + X.

 */
import java.util.Scanner;
import static java.lang.System.out;

public class Tarifa {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int X, N, P;// X data per month, N no of months, P data consumed per month
        int monthCount = 1; //month count to limit data to the specific month number.

        do { out.print("data per month under plan, X: ");
        X = sc.nextInt(); } while (X > 100 || X < 1);//collect and limit input X

        int R = X * monthCount; //remaining data at N=1, placed below X as X needs to be initialized.

        do { out.print("no of months plan is used for, N: ");
        N = sc.nextInt(); } while (N > 100 || N < 1);//collect and limit input N

        for (monthCount = 1; monthCount <= N;) {//collect monthly value of P that is appropriate
            out.print("data consumed each month: ");
             P = sc.nextInt();
                if ( P <= R ) {//p has to be greater than or equal to remaining data, verify if P is appropriate.
                    R -= P;//total remaining data - total consumed data (of the month) + next month data.
                    R += X;//R at current month + 1 month. since adding X includes the next month
                    monthCount++;//after remaining data reflects & P is appropriate, next month comes.
                }
                else { out.println("Error. Data consumed exceeds available data remaining.");
                } }
        out.print("data remaining after N+1 months: ");
        out.println(R);
        sc.close();
        }
    }
