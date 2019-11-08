/* Warning: this answer is incomplete and works till test case 11. */

import java.util.LinkedList;
import java.util.Scanner;

public class CarVet {
    private static Scanner sc = new Scanner(System.in);
    private static int[][] parkingLot;
    private static int lengthM;
    private static int widthN;
    private static int row;
    private static int col;
    private static int emptyRow;
    private static int emptyCol;
    private static boolean isTop;
    private static boolean isLeft;
//    private static int count = 0;
    private static boolean[][] exHole;
    private static LinkedList<Integer> res = new LinkedList<>();

    public static void createLot() {//takes in all the input
        lengthM = sc.nextInt();
        widthN = sc.nextInt();

        parkingLot = new int[lengthM][widthN];
        exHole = new boolean[lengthM][widthN];

        for (int m = 0; m < lengthM; m++) {
            sc.nextLine();
            for (int n = 0; n < widthN; n++) {
                parkingLot[m][n] = sc.nextInt();
                exHole[m][n] = false;
            }
        }
        sc.nextLine();
        row = sc.nextInt();
        col = sc.nextInt();

    }

    public static void findEmpty() {
        for (int m = 0; m < lengthM; m++) {
            for (int n = 0; n < widthN; n++) {
                if (parkingLot[m][n] == -1) {
                    emptyRow = m;
                    emptyCol = n;
                }
            }
        }
    }

    public static boolean carIsVert() {//vert returns true, horizontal returns false
        //check vert
        if (emptyRow + 2 < lengthM && parkingLot[emptyRow + 1][emptyCol] != -2) {
            if (parkingLot[emptyRow + 1][emptyCol] == parkingLot[emptyRow + 2][emptyCol]) {
                isTop = false;
                if (emptyRow - 2 >= 0 && parkingLot[emptyRow - 1][emptyCol] != -2) {
                    if (parkingLot[emptyRow - 1][emptyCol] == parkingLot[emptyRow - 2][emptyCol]) {
                        isTop = true;
                    }
                }
                return true;
            }
        }
            if (emptyRow - 2 >= 0 && parkingLot[emptyRow - 1][emptyCol] != -2) {
                if (parkingLot[emptyRow - 1][emptyCol] == parkingLot[emptyRow - 2][emptyCol]) {
                    isTop = true;
                    return true;
                }
            }
            return false;
        }

        public static boolean carIsHorizontal(){
//        System.out.println(emptyRow);
            if (emptyCol + 2 < widthN && parkingLot[emptyRow][emptyCol + 1] != -2) {
                if (parkingLot[emptyRow][emptyCol + 1] == parkingLot[emptyRow][emptyCol + 2]) {
                    isLeft = false;
                    if (emptyCol - 2 >= 0 && parkingLot[emptyRow][emptyCol - 1] != -2) {
                        if (parkingLot[emptyRow][emptyCol - 1] == parkingLot[emptyRow][emptyCol - 2]) {
                            isLeft = true;
                        }
                    }
                    return true;
                }
            }
            if (emptyCol - 2 >= 0 && parkingLot[emptyRow][emptyCol - 1] != -2) {
                if (parkingLot[emptyRow][emptyCol - 1] == parkingLot[emptyRow][emptyCol - 2]) {
                    isLeft = true;
                    return true;
                }
            }
            return false;
        }

    public static void update2D(int x) {
        int row = emptyRow;
        int col = emptyCol;
        int rowplus = row + 2;
        int rowminus = row - 2;
        int colplus = col + 2;
        int colminus = col - 2;
        int temp = 0;
        switch (x) {
            case 1:
                temp = parkingLot[rowminus][col];
                parkingLot[row][col] = temp;
                parkingLot[rowminus][col] = -1;
                exHole[rowminus][col] = true;
                break;
            case 2:
                temp = parkingLot[rowplus][col];
                parkingLot[row][col] = temp;
                parkingLot[rowplus][col] = -1;
                exHole[rowplus][col] = true;
                break;
            case 3:
                temp = parkingLot[row][colminus];
                parkingLot[row][col] = temp;
                parkingLot[row][colminus] = -1;
                exHole[row][colminus] = true;
                break;
            case 4:
                temp = parkingLot[row][colplus];
                parkingLot[row][col] = temp;
                parkingLot[row][colplus] = -1;
                exHole [row][colplus] = true;
                break;
        }
    }

    public static void main(String[] args) {
        createLot();
        findEmpty();
        boolean cont = true;
        int movedCar = -4;
//        int prevMovedCar = -3;

        while (cont) {
            boolean check5=false, check6=false, check7=false, check8=false;
            try {
                check5 = !exHole[emptyRow - 2][emptyCol];}catch (ArrayIndexOutOfBoundsException e){}
            try {
                check6 = !exHole[emptyRow + 2][emptyCol];}catch (ArrayIndexOutOfBoundsException e){}
            try {
                check7 = !exHole[emptyRow][emptyCol - 2];}catch (ArrayIndexOutOfBoundsException e){}
            try {
                check8 = !exHole[emptyRow][emptyCol + 2];}catch (ArrayIndexOutOfBoundsException e){}

//            System.out.println(emptyRow + " " + emptyCol);
//            System.out.println(prevMovedCar);
//            System.out.println("isleft? " + isLeft);
            boolean moved = false;
            if (row > lengthM || row - 1 < 0 || col > widthN || col - 1 < 0) {
//                System.out.println("case 1");
                cont = false;
            } else if (parkingLot[row - 1][col - 1] == -2) {
//                System.out.println("case 2");
                cont = false;
            } else if (parkingLot[row - 1][col - 1] == -1) {
//                System.out.println("case 3");
                break;
            } else {
                if (carIsVert()) {
                    if (isTop && check5) {
//                        System.out.println("case 5");
                        movedCar = parkingLot[emptyRow - 2][emptyCol];
                            update2D(1);
                            moved = true;
                            res.add(movedCar);
                            findEmpty();
                        }
                    else if (check6){
//                        System.out.println("case 6");
                        movedCar = parkingLot[emptyRow + 2][emptyCol];
                            update2D(2);
                            moved = true;
                            res.add(movedCar);
                            findEmpty();
                        }
                    }
                if (carIsHorizontal()) {
                    if (isLeft && check7) {
//                        System.out.println("case 7");
                        movedCar = parkingLot[emptyRow][emptyCol - 2];
                            update2D(3);
                            moved = true;
                            res.add(movedCar);
                            findEmpty();
                        }
                    else if (check8){
//                        System.out.println("case 8");
                        movedCar = parkingLot[emptyRow][emptyCol + 2];
                            update2D(4);
                            moved = true;
                            res.add(movedCar);
                            findEmpty();
                        }
                    }
                }
                if (moved == false) {
//                    System.out.println("case 9");
                    cont = false;
                }
//            prevMovedCar = movedCar;
        }
        for (int [] x: parkingLot) {
            System.out.println();
            for (int y : x) {
                System.out.print(y + " ");
            }
        }
        System.out.println("The answer is: ");

        if (cont == false) {
            System.out.println("impossible");
        }
        else {
            for (Integer results : res) {
                System.out.print(results + (results == res.getLast() ? "" : " "));
            }
        }
    }
}


