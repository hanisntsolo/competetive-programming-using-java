package com.competetive.recursionandbacktracking.recursiontypes;

public class MemoryManagement {
    public void func1() {
        int dd = 9;
        func2(9);
    }
    public void func2(int i) {
        float f = 30f;
        func3();
    }
    public void func3() {
        var houseRef = new TowerOfHanoi();
        houseRef.solve(2, 'A','B','C');
    }

}
/**
 * STACK :                          HEAP
 * func3() -> houseRef              TowerOfHanoi
 * func2() -> f,i
 * func1() -> dd
 */