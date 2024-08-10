package com.competetive.recursionandbacktracking.recursiontypes;

public class TowerOfHanoi {

    /**
     * Pseudo Code :
     * if(n == 0)
     *      move disk from source to dest
     *      return;
     * hanoi(disk - 1, source, dest, middle);
     * move disk from source to dest
     * hanoi(disk - 1, middle, source, dest);
     *
     * @param disk
     * @param source
     * @param middle
     * @param destination
     */

    public void solve(int disk, char source, char middle, char destination) {
        if(disk == 0) { // Base case something to do with the smallest plate.
            System.out.println("Move Disk :" + disk + " from " + source + " to destination : " + destination );
            return;
        }
        solve(disk - 1, source, destination , middle); // n - 1 disks to middle using source and destination logs
        System.out.println("Move Disk :" + disk + " from " + source + " to destination : " + destination );
        solve(disk - 1, middle, source, destination); // n - 1 disks to destination using middle and source logs.
    }

}
