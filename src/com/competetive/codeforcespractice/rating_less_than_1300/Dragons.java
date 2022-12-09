//Accepted This was very good question....

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
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Comparator;
import java.util.Collections;
public class Dragons {
	
	static class Dragon {
		
		int strength;
		int bonusPoints;

		public Dragon(int s, int b) {
			this.strength = s;
			this.bonusPoints = b;
		}
		public String toString() {
			return "Dragon Strenth="+ strength+" BonusPoints="+bonusPoints;
		}
	}

	public static void main(String[] args) throws IOException {
		Reader rd = new Reader();
		int currentStrength = rd.nextInt();
		int totalDragons = rd.nextInt();
		ArrayList<Dragon> dragonList = new ArrayList<>();
		while(totalDragons > 0) {
			dragonList.add(new Dragon(rd.nextInt(), rd.nextInt()));
			totalDragons--;
		}
		//First running comparator;
		Comparator<Dragon> dragonComparator = new Comparator<Dragon>() {
			@Override
			public int compare(Dragon d1, Dragon d2) {
				if(d1.strength < d2.strength) {
					return -1;
				}
				if(d1.strength > d2.strength) {
					return 1;
				}
				return 0;
			}
		};
		Collections.sort(dragonList, dragonComparator);
		// System.out.println(dragonList);
		int index = 0;
		while(index < dragonList.size()) {
			Dragon currDragon = dragonList.get(index);
			if(currentStrength>currDragon.strength) {
				currentStrength += currDragon.bonusPoints;
			} else {
				System.out.println("NO");
				System.exit(0);
				break;//if cannot defeat the next dragon
			}
			index++;
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