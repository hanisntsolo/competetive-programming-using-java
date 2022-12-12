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
import java.util.Map;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.PriorityQueue;

public class HossamAndRange {

    static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		long time1 = System.currentTimeMillis();
		Reader rd = new Reader();
		ArrayList<Integer> list = new ArrayList<>();
		int len = rd.nextInt();
		while(len > 0) {
			list.add(rd.nextInt());
			len--;
		}
		int query = rd.nextInt();
		int ans = 0;	
		// System.out.println("Hey!");
		StringBuffer sb = new StringBuffer();
		while(query > 0) {
			int a = rd.nextInt();
			int b = rd.nextInt();
			int firstIndex = a ^ ans;
			int secondIndex = b ^ ans;
			// System.out.println("a=:"+a+"b=:"+b+"ans="+ans);
			// System.out.println("firstIndex=:"+firstIndex+"secondIndex=:"+secondIndex+"ans="+ans);
			firstIndex-=1;
			secondIndex-=1;
			// System.out.println("firstIndex=:"+firstIndex+"secondIndex=:"+secondIndex+"ans="+ans);
			//Select min number occuring odd number of times;
            HashMap<Integer, Integer> minOddMap = new HashMap<Integer, Integer>();
			// HashMap<Integer, Integer> minOddMap = new HashMap<Integer, Integer>( new Comparator<Entry<Integer, Integer>>(){
            //     @Override
            //     public int compare(Entry<Integer, Integer> a , Entry<Integer, Integer> b) {
            //         return a.getValue().compareTo(b.getValue());
            //     }
            // });
			// if(firstIndex!=secondIndex)
			for(int i = firstIndex; i <= secondIndex; i++) {
				// System.out.println(minOddMap);
				if(!minOddMap.containsKey(list.get(i))) {
					minOddMap.put(list.get(i), 1);
				} else {
					int val = minOddMap.get(list.get(i));
					minOddMap.put(list.get(i), val + 1);
				}
				firstIndex += 1;
			}
			// ArrayList<Integer> finalList = new ArrayList<Integer>(new Comparator<Integer>(){
			// 	public int compare(Integer a, Integer b) {
			// 		return a <= b ? -1 : 1;
			// 	}
			// });
			// ArrayList<Integer> finalList = new ArrayList<>();
            Queue<Integer> finalList = new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b) {
                    return a <= b ? -1 : 1;
                }
            });
			for(Map.Entry<Integer, Integer> mapEntry : minOddMap.entrySet()) {
				if(mapEntry.getValue() % 2 == 1) {
					finalList.offer(mapEntry.getKey());
				}
			}
			// Collections.sort(finalList);
			// System.out.println(minOddMap);
			// System.out.println(finalList);
			// System.out.println(finalList.get(0));
			if(finalList.size() > 0) {
				// sb.append(finalList.get(0));
                int firstNo = finalList.poll();
                out.print(firstNo + "\n");
				ans = firstNo;
			} else {
				// sb.append("0");
                out.print(0 + "\n");
				// System.out.println("reached till zero");
				ans = 0;
			}
			sb.append(System.getProperty("line.separator"));
			query-=1;
		}
		// System.out.println(sb);
        out.flush();
		long netTime = System.currentTimeMillis() - time1;
		// System.out.println(netTime);
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