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
public class SuperCentral {
	static class Point {
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return this.x;
		}
		public int getY() {
			return this.y;
		}
	}
	public static boolean isRightNeighbor(Point a, Point b) {
		if(a.getX() < b.getX() && a.getY() == b.getY())
			return true;
		return false;
	}
	public static boolean isLeftNeighbor(Point a ,Point b) {
		if(a.getX() > b.getX() && a.getY() == b.getY())
			return true;
		return false;
	}
	public static boolean isLowerNeighbor(Point a, Point b) {
		if(a.getY() > b.getY() && a.getX() == b.getX())
			return true;
		return false;
	}
	public static boolean isUpperNeighbor(Point a , Point b) {
		if(a.getY() < b.getY() && a.getX() == b.getX())
			return true;
		return false;
	}
	public static boolean isSuperCentral(Point a , Point b) {
		if(isRightNeighbor(a,b) || isLeftNeighbor(a,b)
		 || isUpperNeighbor(a,b) || isLowerNeighbor(a,b))
			return true;
		return false;
	}
	public static int totalSuperCentralPoints(ArrayList<Point> list) {
		int totalSuperCentralPoint = 0;
		for(int i = 0; i < list.size(); i++) {
			int localCount = 0;
			for(int j = 0; j < list.size(); j++) {
				if(i==j) continue;
				//Calculate superCentralPoints
				if(isSuperCentral(list.get(i), list.get(j))) {
					localCount+=1;
				}
			}
			if(localCount >3) {
				totalSuperCentralPoint+=1;
			}
		}
		return totalSuperCentralPoint;
	}
	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		ArrayList<Point> pointsList = new ArrayList<>();
		int points = rd.nextInt();
		while(points > 0) {
			Point p = new Point(rd.nextInt(), rd.nextInt());
			pointsList.add(p);
			points--;
		}
		System.out.println(totalSuperCentralPoints(pointsList));
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