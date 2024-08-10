package com.competetive.recursionandbacktracking.searchalgorithms;

public class Search {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 5, 6, 7, 8};
        SearchAlgorithms search = new SearchAlgorithms();
        System.out.println(search.findRecursive(arr, 5, 0));
        System.out.println(search.binarySearch(arr, 8, 0, arr.length - 1));
    }
}
