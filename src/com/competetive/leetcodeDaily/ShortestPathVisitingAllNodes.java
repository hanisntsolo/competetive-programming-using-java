package com.competetive.leetcodeDaily;
import java.io.IOException;
//Static imports for less code
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
//Utilities
import java.util.HashMap;
import java.util.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//Static imports for less code
import static java.math.BigInteger.valueOf;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
//Utilities
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
public class ShortestPathVisitingAllNodes {
    public static int shortestPathLength(int[][] graph) {
        int length = graph.length;
        int fullBitMask = (1 << length) - 1;
        Queue<HashMap<Integer,Integer>> q = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            HashMap<Integer, Integer> list = new HashMap<>();
            list.put(i,1 << i);
            q.add(list);
            set.add(i+""+(1 << i));
        }
        System.out.println(q);
        System.out.println(set);
        int steps = 0;
        while(q.size() > 0) {
            Queue<HashMap<Integer, Integer>> nextQ = new ArrayDeque<>();
            while(q.size()>0) {
                HashMap<Integer, Integer> currHashMap = q.poll();
                Iterator<Integer> hashKeyIterator = currHashMap.keySet().iterator();
                int node = hashKeyIterator.next();
                Iterator<Integer> hashValIterator = currHashMap.values().iterator();
                int bitMask = hashValIterator.next();
                if(bitMask == fullBitMask) return steps;
                for( int neighbor : graph[node]) {
                    int newBitMask = bitMask |( 1 << neighbor);
                    if(!set.contains(neighbor+""+(1 << newBitMask))) {
                        HashMap<Integer, Integer> localMap = new HashMap<>();
                        localMap.put(neighbor, 1 << newBitMask);
                        nextQ.add(localMap);
                        set.add(neighbor+""+(1 << newBitMask));
                    }
                }
            }
            q = nextQ;
            steps++;
        }
        return steps;
    }
    public static void main(String[] args) throws IOException {
//        int[][] array = new int[][]{{1,2,3},{0},{0},{0}};
        int[][] array = new int[][]{{1},{0}};
        out.println(shortestPathLength(array));
    }
}
