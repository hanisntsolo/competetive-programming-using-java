package com.competetive.introduction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Introduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double len = sc.nextInt();
        double breadth = sc.nextInt();
        double tile = sc.nextInt();
        long newTileLength = (long)Math.ceil(len/tile);
        long newTileBreadth = (long)Math.ceil(breadth/tile);
        System.out.println(newTileLength*newTileBreadth);
    }
}
