//Very good question to see Priority Queue Implementation.
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
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Airport {

	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		int totalPeople = rd.nextInt();
		int totalPlanes = rd.nextInt();
		Queue<Integer> seatsInPlanesAesc = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return a <= b ? -1 : 1;
			}
		});
		Queue<Integer> seatsInPlanesDesc = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return a >= b ? -1 : 1;
			}
		});
		while(totalPlanes > 0) {
			int currSeats = rd.nextInt();
			seatsInPlanesAesc.offer(currSeats);
			seatsInPlanesDesc.offer(currSeats);
			totalPlanes-=1;
		}
		//Do your thing
		// System.out.println(seatsInPlanesAesc);
		// System.out.println(seatsInPlanesDesc);
		//Min revenue
		int ascPeople = totalPeople;
		int  minRevenue = 0;
		while(ascPeople > 0) {
			int currTotalSeats = seatsInPlanesAesc.poll();
			minRevenue += currTotalSeats;
			int remainingSeats = currTotalSeats - 1;
			if(remainingSeats > 0) {
				seatsInPlanesAesc.offer(remainingSeats);
			}
			ascPeople-=1;
		}	
		// System.out.println(minRevenue);
		//Max Revenue
		int dscPeople = totalPeople;
		int maxRevenue = 0;
		while(dscPeople > 0) {
			int currTotalSeats = seatsInPlanesDesc.poll();
			maxRevenue += currTotalSeats;
			int remainingSeats = currTotalSeats - 1;
			if(remainingSeats > 0) {
				seatsInPlanesDesc.offer(remainingSeats);
			}
			dscPeople-=1;
		}
		// System.out.println(maxRevenue);
		System.out.println(maxRevenue+" "+minRevenue);
	}
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
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

        public long nextLong() throws IOException
        {
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

        public double nextDouble() throws IOException
        {
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

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}