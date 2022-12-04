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
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
public class AmusingJoke {
	static int [] alphabets = new int[26];
	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		int test = 3;
		ArrayList<String> list = new ArrayList<>();
		while(test > 0) {
			list.add(rd.readLine());
			test--;
		}
		operate(list);
	}
	public static void operate(ArrayList<String> list) {
		updateList(list.get(0));
		// Arrays.stream(alphabets).forEach(System.out::print);
		// System.out.println();
		updateList(list.get(1));
		// Arrays.stream(alphabets).forEach(System.out::print);
		// System.out.println();
		checkPermutation(list.get(2));
		// Arrays.stream(alphabets).forEach(System.out::print);
		// System.out.println();
		result();
	}
	public static void updateList(String sb) {
		for(int i = 0; i < sb.length() - 1; i++) {
			int currentChar = sb.charAt(i);
			if(alphabets[currentChar - 65] == 0) {
				alphabets[currentChar - 65] = 1; 
			} else {
				alphabets[currentChar - 65] += 1;
			}
		}
	}
	public static void checkPermutation(String sb) {
		for(int i = 0; i < sb.length() - 1; i++) {
			int currentChar = sb.charAt(i);
			alphabets[currentChar - 65] -= 1;
		}
	}
	public static void result() {
		for(int num : alphabets) {
			if(num!=0) {
				System.out.println("NO");
				return;
			}
		}	
		System.out.println("YES");
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
            byte[] buf = new byte[101]; // line length
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
