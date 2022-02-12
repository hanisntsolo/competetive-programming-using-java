package com.competetive.introduction;

import java.util.*;

//In the popular spreadsheets systems (for example, in Excel) the following numeration of columns is used. The first column has number A, the second — number B, etc. till column 26 that is marked by Z. Then there are two-letter numbers: column 27 has number AA, 28 — AB, column 52 is marked by AZ. After ZZ there follow three-letter numbers, etc.
//
//        The rows are marked by integer numbers starting with 1. The cell name is the concatenation of the column and the row numbers. For example, BC23 is the name for the cell that is in column 55, row 23.
//
//        Sometimes another numeration system is used: RXCY, where X and Y are integer numbers, showing the column and the row numbers respectfully. For instance, R23C55 is the cell from the previous example.
//
//        Your task is to write a program that reads the given sequence of cell coordinates and produce each item written according to the rules of another numeration system.
//
//        Input
//        The first line of the input contains integer number n (1 ≤ n ≤ 105), the number of coordinates in the test. Then there follow n lines, each of them contains coordinates. All the coordinates are correct, there are no cells with the column and/or the row numbers larger than 106 .
//
//        Output
//        Write n lines, each line should contain a cell coordinates in the other numeration system.
//
//        Examples
//        inputCopy
//        2
//        R23C55
//        BC23
//        outputCopy
//        BC23
//        R23C55
public class SpreadSheet {

    public static String convert(String coordinate) {
        Map<Integer,String> converter = new HashMap<>();
        String regex = "((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))";
        System.out.println(Arrays.asList(coordinate.split(regex)));
        List<String> list = Arrays.asList(coordinate.split(regex));
        if(list.size()>2) {
            for (int i = list.size(); i >0 ; i--) {

            }
            char factor = (char) (Integer.valueOf(list.get(3))/26);

        } else {
            String row = "R"+list.get(1);
            String[] col = list.get(0).split("");
            int factor = col[0].charAt(0) - 64;
            int colNumber = 0;
            for (int i = 1; i < col.length; i++) {
                System.out.println("i = " + i);
                System.out.println("col["+i+"].charAt(0) = " + (col[i].charAt(0) - 64));
                colNumber+=((26*factor)+(col[i].charAt(0) - 64));
                System.out.println("colNumber = " + colNumber);
            }
            return row+"C"+colNumber;
        }
        return coordinate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(convert(input[i]));
        }
        System.out.println("SpreadSheet.main");
    }
}

