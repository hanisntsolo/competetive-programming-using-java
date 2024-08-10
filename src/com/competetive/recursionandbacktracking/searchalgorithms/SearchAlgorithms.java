package com.competetive.recursionandbacktracking.searchalgorithms;

public class SearchAlgorithms {
    protected int findRecursive(int[] arr, int item, int index) {
        if(index >= arr.length) return -1;

        if(arr[index] == item) return index;
        return findRecursive(arr, item, index + 1);
    }
    protected int binarySearch(int[] arr, int item, int left, int right) {
        if(right<left) return -1;
        int mid = (left + right) / 2;
        if(arr[mid] == item) return mid;
        return arr[mid] < item ? binarySearch(arr, item, mid + 1, right) : binarySearch(arr, item, left, mid - 1);
    }

}
