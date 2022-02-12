package com.competetive.introduction;
//Input: g = [1,2,3], s = [3,3,3] size is the number of cookies i have.
//        Output: 1
//        Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//        And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
//        You need to output 1.
//Static imports for less code
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
//Utilities
import java.util.*;

public class Cookie {

    //helper to convert array to arraylist;
    public static LinkedList<Integer> convertArrayToLinkedList(int[] array) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int element : array) {
            list.add(element);
        }
        return list;
    }
    //Goal is simple take a cookie and check if any children can be made content with  it if yes update contentedChildren count.
    public static int totalContentChildren(int[] greed, int[] size) {
        LinkedList<Integer> cookieSize = convertArrayToLinkedList(size);
        LinkedList<Integer> cookieGreed = convertArrayToLinkedList(greed);
        Collections.sort(cookieSize);
        Collections.sort(cookieGreed);
        int totalContentChildren = 0,currentCookieGreed;
        while(cookieSize.size()!=0) {
            int currentCookieSize = cookieSize.poll();
            try{
                currentCookieGreed = cookieGreed.poll();
            } catch (NullPointerException e) {
                return totalContentChildren+1;
            }
            if(currentCookieGreed<=currentCookieSize) {
                totalContentChildren+=1;
            }
        }
        out.println("totalContentChildren = " + totalContentChildren);
        return totalContentChildren;
    }
    public static void main(String[] args) {
        out.println(totalContentChildren(new int[]{1,1,1,1,2,3},new int[]{1,1}));
        out.println(totalContentChildren(new int[]{1,2,3},new int[]{1,1}));
        out.println(totalContentChildren(new int[]{1,2,3},new int[]{1,1,3,3,3}));
    }
}
