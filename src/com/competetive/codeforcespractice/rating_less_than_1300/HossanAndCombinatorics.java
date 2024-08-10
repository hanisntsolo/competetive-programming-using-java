//import java.io.DataInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//
////Static imports for less code
//import static java.math.BigInteger.valueOf;
//import static java.lang.Math.max;
//import static java.lang.Math.min;
//import static java.lang.Math.abs;
//import static java.lang.System.out;
////Utilities
//import java.util.Scanner;
//import java.util.Collections;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.HashMap;
//import java.util.AbstractMap;
//import java.util.Date;
//import java.util.Comparator;
//import java.util.Collections;
//import java.util.Arrays;
//import java.util.Queue;
//import java.util.PriorityQueue;
//
//
//public class HossanAndCombinatorics {
//// Notes: to keep in mind while coding - the program must run in max 1 sec.
//    //  and 1 sec is equivalent to 10^8 instruction at most.
//    // make sure to utilize fastI/O - Readers implementation and PrintWriters implemenatation
//    // is already present;
//
////Priority Queue
///*
// *
// *
// */
//static class IncComp implements Comparator<Integer> {
//    @Override
//    public int compare(Integer a , Integer b) {
//        return a <= b ? -1 : 1;
//    }
//}
//static class DescComp implements Comparator<Integer> {
//    @Override
//    public int compare(Integer a , Integer b) {
//        return a >= b ? -1 : 1;
//    }
//}
//
////Make sure the arraylist is sorted
//private static binarySearch(ArrayList<>)
//
//static PrintWriter out = new PrintWriter(System.out);
//
//    public static void main(String[] args) throws IOException {
//        Reader rd = new Reader();
//        long test = rd.nextLong();
//        while(test > 0) {
//            //Write code here;
//        	int nums = rd.nextInt();
//        	int currMin = Integer.MAX_VALUE;
//        	int currMax = Integer.MIN_VALUE;
//	        ArrayList<Integer> list = new ArrayList<>();
//        	while(nums> 0) {
//	        	int currNum = rd.nextInt();
//	        	if(currNum > currMax) {
//	        		currMax = currNum;
//	        	}
//	        	if(currNum < currMin) {
//	        		currMin = currNum;
//	        	}
//	        	list.add(currNum);
//        		nums--;
//        	}
//        	int count = 0;
//        	int maxAbsDiff = currMax - currMin;
//        	// Collections.sort(list, new IncComp());
//        	int totalMins = 0;
//        	int totalMax = 0;
//        	for(int i = 0 ; i< list.size(); i++) {
//        		if(currMin == list.get(i)) {
//        			totalMax++;
//        		} else if(currMax == list.get(i)) {
//        			totalMins++;
//        		}
//        	}
//        	count = 2 * (totalMins + totalMax);
//        	out.print(count+"\n");
//            test--;
//        }
//
//        out.flush(); // to flush the output
//    }
//
//static class Reader {
//    final private int BUFFER_SIZE = 1 << 16;
//    private DataInputStream din;
//    private byte[] buffer;
//    private int bufferPointer, bytesRead;
//
//    public Reader() {
//        din = new DataInputStream(System.in);
//        buffer = new byte[BUFFER_SIZE];
//        bufferPointer = bytesRead = 0;
//    }
//
//    public Reader(String file_name) throws IOException {
//        din = new DataInputStream(
//                new FileInputStream(file_name));
//        buffer = new byte[BUFFER_SIZE];
//        bufferPointer = bytesRead = 0;
//    }
//
//    public String readLine() throws IOException {
//        byte[] buf = new byte[101]; // line length
//        int cnt = 0, c;
//        while ((c = read()) != -1) {
//            if (c == '\n') {
//                if (cnt != 0) {
//                    break;
//                } else {
//                    continue;
//                }
//            }
//            buf[cnt++] = (byte) c;
//        }
//        return new String(buf, 0, cnt - 1);
//    }
//
//    public int nextInt() throws IOException {
//        int ret = 0;
//        byte c = read();
//        while (c <= ' ') {
//            c = read();
//        }
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//        do {
//            ret = ret * 10 + c - '0';
//        } while ((c = read()) >= '0' && c <= '9');
//
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    public long nextLong() throws IOException {
//        long ret = 0;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//        do {
//            ret = ret * 10 + c - '0';
//        } while ((c = read()) >= '0' && c <= '9');
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    public double nextDouble() throws IOException {
//        double ret = 0, div = 1;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//
//        do {
//            ret = ret * 10 + c - '0';
//        } while ((c = read()) >= '0' && c <= '9');
//
//        if (c == '.') {
//            while ((c = read()) >= '0' && c <= '9') {
//                ret += (c - '0') / (div *= 10);
//            }
//        }
//
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    private void fillBuffer() throws IOException {
//        bytesRead = din.read(buffer, bufferPointer = 0,
//                BUFFER_SIZE);
//        if (bytesRead == -1)
//            buffer[0] = -1;
//    }
//
//    private byte read() throws IOException {
//        if (bufferPointer == bytesRead)
//            fillBuffer();
//        return buffer[bufferPointer++];
//    }
//
//    public void close() throws IOException {
//        if (din == null)
//            return;
//        din.close();
//    }
//
//}
//}