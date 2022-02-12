package com.competetive.introduction;

import java.util.Arrays;
import java.util.Scanner;

class Coordinate {
    private double x;
    private double y;
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public static double distance(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.abs(Math.pow(a.getX()-b.getX(),2)-Math.pow(a.getY()-b.getY(),2)));
    }
}

public class AncientArena {

    public static double calculateMinArea(Coordinate a, Coordinate b, Coordinate c) {
        double disA = Coordinate.distance(a, b);
        double disB = Coordinate.distance(b, c);
        double disC = Coordinate.distance(c, a);
        double semiPerimeter = (disA + disB + disC)/2;
        double areaOfTriangle = Math.sqrt(semiPerimeter*(semiPerimeter-disA)*(semiPerimeter-disB)*(semiPerimeter-disC));
        return areaOfTriangle;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] coordinates = new String[3];
        for (int i = 0; i < 3; i++) {
            coordinates[i] = sc.nextLine();
        }
        System.out.println("Arrays.asList(coordinates = " + Arrays.asList(coordinates));
        Coordinate[] coordinates1 = new Coordinate[coordinates.length];
        for (int i = 0; i < 3; i++) {
            String x = coordinates[i].split(" ")[0];
            String y = coordinates[i].split(" ")[1];
            coordinates1[i] = new Coordinate(Double.parseDouble(String.format("%.6f",Double.parseDouble(x))), Double.parseDouble(String.format("%.6f",Double.parseDouble(y))));
        }
        for (Coordinate cood: coordinates1 
             ) {
            System.out.println("cood.getX()+\":\"+cood.getY() = " + String.format("%.6f",cood.getX())+":"+String.format("%.6f",cood.getY()));
        }
        double result = calculateMinArea(coordinates1[0],coordinates1[1],coordinates1[2]);
        System.out.println("String.format(\"%.6f\",result) = " + String.format("%.6f",result));
    }
}
