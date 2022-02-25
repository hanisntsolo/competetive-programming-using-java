package com.competetive.cses;
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
import java.util.*;

public class Permutations {
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

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int number = sc.nextInt();
        if(number == 1) {
            out.println(1);
        }
        else if(number<=3 && number>1) {
            out.println("NO SOLUTION");
        } else {
            StringBuilder oddBuff = new StringBuilder();
            StringBuilder eveBuff = new StringBuilder();
            ArrayList<Integer> odd = new ArrayList<>();
            ArrayList<Integer> eve = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = number; i > 0; i--) {
                if((i&1) == 0) {
//                    eve +=" "+i;
//                    eve.append(eve+" "+i);
                    eve.add(i);
                    eveBuff.append(i).append(" ");
                } else {
//                    odd = odd+" "+i;
//                    odd.append(odd+" "+i);
                    odd.add(i);
                    oddBuff.append(i).append(" ");
                }
                list.add(i);
            }
//            out.println(oddBuff.toString()+eveBuff.toString());
//            out.println(eve.toString().concat(odd.toString()));
            out.println(list.toString());
        }
    }
}
//                                        7
//1 -> NO SOLUTION
//2 -> NO SOLUTION
//3 -> NO SOLUTION
//4  ->  NO SOLUTION
//5  -> 1 3 5 2 4 -> 1 3 5 2 4
//6 -> 1 2 3 4 5 6 -> 1 3 2 4 5 6 -> 1 3 5 4 2 6 -> 1 3 5 2 4 6
//7 -> 1 2 3 4 5 6 7 -> 1 3 2 4 5 6 7 -> 1 3 5 4 2 6 7 -> 1 3 5 2 4 6 7
//                           2 6 3 7 5 4 1
//                   5 1 4 8 6 2 3 7
