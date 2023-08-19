import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

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
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.math.BigInteger;


public class HossamAndCombinatorics {

	/*														ॐ
													 ||	तत् त्वम् असि ||
    */
	
	/* COMMIT TO MEMORY WHILE USING JAVA IN COMPETETIVE PROGRAMMING */

	//# Notes: to keep in mind while coding - the program must run in max 1 sec.
    // and 1 sec is equivalent to 10^8 instruction at most.
    //## make sure to utilize fastI/O - Readers implementation and PrintWriters implemenatation
    // is already present;

    //## Always try to use BigInteger class while writing contests.

    //## While comparing wrapper class objects please use equals method 
    // or write your own implementation of the equals method.
    
    //## When writing comparator and using in sorting the values make sure you do not
    // break the general contract of writing a comparator.


//Priority Queue
/* 
 *
 *
 */
	
static class IncComp implements Comparator<Integer> {
    @Override
    public int compare(Integer a , Integer b) {
        return a < b ? -1 : a > b ? 1 : 0;
    }
}
static class DescComp implements Comparator<Integer> {
    @Override
    public int compare(Integer a , Integer b) {
        return a < b ? 1 : a > b ? -1 : 0;
    }
}
static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        long test = rd.nextLong();
        while(test > 0) {
            //Write code here;
        	int tn = rd.nextInt();
        	int bf = tn;
        	ArrayList<Integer> list = new ArrayList<>();	
        	while(tn > 0) {
        		list.add(rd.nextInt());
        		tn--;
        	}
        		Collections.sort(list, new IncComp()); // nlogn
        		Map<Integer, Integer> map = new TreeMap<>(); // nlogn
        		for(int a : list) {
        			if(map.get(a) == null) {
        				map.put(a, 1);
        			} else {
        				map.put(a, map.get(a) + 1);
        			}
        		}										//order n
        		BigInteger first = BigInteger.valueOf(map.get(list.get(0)));
        		BigInteger second = BigInteger.valueOf(map.get(list.get(list.size() - 1)));
        		// out.print( first + "\n");
        		// out.print( second + "\n");
        		if(list.get(0).equals(list.get(bf - 1))) {
        			out.print( BigInteger.valueOf(bf).multiply(BigInteger.valueOf(bf - 1)) + "\n");
        		} else {
        			out.print( first.multiply(second).multiply(BigInteger.valueOf(2)) + "\n");
        		}
            test--;
        }
        out.flush(); // to flush the output
    }

static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(
                new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[101]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) {
                    break;
                } else {
                    continue;
                }
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt - 1);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0,
                BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }

}
}