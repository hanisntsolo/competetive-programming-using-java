package com.competetive.cses;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//Static imports for less code
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
//This is a maximum-length substring containing only one type of character.
//ATTCGGGA
public class Repetetions {

    public static void main(String[] args) throws IOException {
//        Reader sc = new Reader();
        Scanner sc = new Scanner(System.in);

        StringBuilder string = new StringBuilder();
        string.append(sc.nextLine());
        int left = 0;
        int right = 0;
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        //ATTCGGGA
        int maxCount = 0;
        for (right = 0; right < string.length(); right++) {
            if(string.charAt(right)==string.charAt(left)) {
                count++;
            } else {
                left = right;
                maxCount = max(maxCount,count);
                count = 0;
                right = right - 1;
            }
        }
//        while(right<string.length()) {
//            char curr = string.charAt(right);
//            if(map.containsKey(curr)) {
//                count = Math.max(count, right-left);
//                left = right;
//                map.clear();
//            } else {
//                map.put(curr,1);
//            }
//            right++;
//        }
        maxCount = max(maxCount,count);
        out.println(maxCount);
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