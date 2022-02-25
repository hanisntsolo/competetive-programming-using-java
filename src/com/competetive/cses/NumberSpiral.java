package com.competetive.cses;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//Static imports for less code
import static java.lang.Math.*;
import static java.math.BigInteger.valueOf;
import static java.lang.System.out;
//Utilities
import java.math.BigInteger;
import java.util.*;

public class NumberSpiral {
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
//        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int[][] coordinates = new int[tests][2];
        for (int i = 0; i < tests; i++) {
//            coordinates[i][0] = sc.nextInt();
//            coordinates[i][1] = sc.nextInt();
            int y = sc.nextInt();
            int x = sc.nextInt();
            find(y,x);
        }
//        for (int i = 0; i < tests; i++) {
//            find(coordinates[i][0],coordinates[i][1]);
//        }
    }
//    public static void find(int y, int x) {
//        int number = 0;
//        if(y>x) {
//            if(y%2==1) number = ((y - 1) * (y - 1)) + x;
//            else number = (y * y) - x + 1;
//        } else {
//            if(x%2==0) number = ((x - 1) * (x - 1)) + y;
//            else number = (x * x) - y + 1;
//        }
//        out.println(number);
//    }
    public static void find(long y, long x) {
            long number = 0;
            if(y>x) {
                if(y%2==1) number = (long)((y - 1) * (y - 1)) + x;
                else number = (long)(y * y) - x + 1;
            } else {
                if(x%2==0) number = (long)((x - 1) * (x - 1)) + y;
                else number = (long)(x * x) - y + 1;
            }
            out.println(number);
    }
}
