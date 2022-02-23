package com.competetive.educationalround;
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

/**
 * 4
 * rgbBRG
 * RgbrBG
 * bBrRgG
 * rgRGBb
 */
//'r' -> true
//'g' -> true
//'b' -> true
public class DoorsAndKeys {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        String[] doorWay = new String[testCases];
        for (int i = 0; i < testCases; i++) {;
            doorWay[i] = sc.next();
        }
        solve(doorWay);
    }
    public static void solve(String[] ways) {
        boolean flag = false;
        for(int j=0;j<ways.length;j++) {
            String doorWay = ways[j];
            HashMap<Character, Boolean> doorMap = new HashMap<>();
            doorMap.put('r',false);
            doorMap.put('g',false);
            doorMap.put('b',false);
            for (int i = 0; i < doorWay.length(); i++) {
                if (doorWay.charAt(i) == 'r' || doorWay.charAt(i) == 'b' || doorWay.charAt(i) == 'g') {
                    doorMap.put(doorWay.charAt(i), true);
                } else {
                    if (doorWay.charAt(i) == 'R') {
                        if (!doorMap.get('r')) {
                            out.println("NO");
                            flag = true;
                            break;
                        }
                    } else if (doorWay.charAt(i) == 'B') {
                        if (!doorMap.get('b')) {
                            out.println("NO");
                            flag = true;
                            break;
                        }
                    } else if (doorWay.charAt(i) == 'G') {
                        if (!doorMap.get('g')) {
                            out.println("NO");
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (doorMap.get('r') && doorMap.get('g') && doorMap.get('b'))
                out.println("YES");
        }
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
