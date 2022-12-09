//Accepted
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
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Comparator;

public class BicycleChain {

	static class Gear {

		int front;
		int rear;	
		public Gear(int f, int r) {
			this.front = f;
			this.rear = r;
		}
		public int gearRatio() {
			return this.rear / this.front;
		}
		public boolean isIntegral() {
			if(this.rear % this.front == 0)
				return true;
			return false;
		}
		public String toString() {
			return "[Gear] front =" + this.front + "rear =" + this.rear;
		}
	}

	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		int frontStarCount = rd.nextInt();
		ArrayList<Integer> frontStars = new ArrayList<>();
		while(frontStarCount > 0) {
			frontStars.add(rd.nextInt());
			frontStarCount--;
		}
		int rearStarCount = rd.nextInt();
		ArrayList<Integer> rearStars = new ArrayList<>();
		while(rearStarCount > 0) {
			rearStars.add(rd.nextInt());
			rearStarCount--;
		}
		ArrayList<Integer> ratios = new ArrayList<>();
		for(int i = 0; i < frontStars.size(); i++) {
			for(int j=0; j < rearStars.size(); j++) {
				// System.out.println(frontStars.get(i)+" "+ rearStars.get(j));
				Gear gear = new Gear(frontStars.get(i), rearStars.get(j));
				// System.out.println(gear.toString());
				if(gear.isIntegral())
					ratios.add(gear.gearRatio());
			}
		}
		Collections.sort(ratios);
		int index = ratios.size() - 1;
		int ratioNeeded = ratios.get(index);
		int count = 1;
		index-=1;
		while(index >= 0) {
			if(ratios.get(index) == ratioNeeded) {
				count++;
			} else {
				break;
			}
			index--;
		}
		// System.out.println(ratios);
		// System.out.println(frontStars);
		// System.out.println(rearStars);
		System.out.println(count);
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