import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Woodcuttingv3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        sc.nextLine();

        for (int x = 0; x < testCases; x++) {
            int customers = sc.nextInt();
            sc.nextLine();

            ArrayList<Long> cmwoodTU = new ArrayList<>();
            for (int y = 0; y < customers; y++) {
                int woodNum = sc.nextInt();

                int[] woodsz = new int[woodNum];
                for (int z = 0; z < woodNum; z++) {
                    int woodSize = sc.nextInt();

                    woodsz[z] = woodSize;
                }
                long woodTU = 0;
                for (long TU : woodsz) {
                    woodTU += TU;
                }
                cmwoodTU.add(woodTU);
                sc.nextLine();
            }
            Collections.sort(cmwoodTU);

            //System.out.println(cmwoodTU.get(0));

            ArrayList<Long> cmMinOrderTU = new ArrayList<>();
            long minTU = 0;
            for (int cmindex = 0; cmindex < customers; cmindex++) {
                minTU += cmwoodTU.get(cmindex);
                cmMinOrderTU.add(cmindex, minTU);
            }
            long totalcumulativeTU = 0;
            for (long TU : cmMinOrderTU) {
                totalcumulativeTU += TU;
            }

            // System.out.println(totalcumulativeTU);
            double minAvgTU = (double) totalcumulativeTU / (double) customers;

            System.out.printf("%.7f", minAvgTU);
            System.out.println();
        }
    }
}
