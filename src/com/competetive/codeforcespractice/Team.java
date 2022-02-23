//package com.competetive.codeforcespractice;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//Static imports for less code
import static java.lang.System.*;
import static java.math.BigInteger.valueOf;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
//Utilities
import java.util.*;

public class Team {
    public static int implementSolutionOrNot(ArrayList<String> problems) {
        int count = 0;
        for (String problem : problems) {
            if(problem.charAt(0) =='1' && problem.charAt(1)=='1' ||
                    problem.charAt(0) =='1' && problem.charAt(2)=='1' ||
                        problem.charAt(1) =='1' && problem.charAt(2)=='1')
                count++;
        }
//        for (int i = 0; i < problems.length; i++) {
//            if(problems[i].charAt(0) =='1' && problems[i].charAt(1)=='1' ||
//                    problems[i].charAt(0) =='1' && problems[i].charAt(2)=='1' ||
//                        problems[i].charAt(1) =='1' && problems[i].charAt(2)=='1') count++;
//        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
        int tests = sc.nextInt();
        String[] lines = new String[tests];
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < tests; i++) {
            String problem = "";
            for (int j = 0; j < 3; j++) {
                problem+=sc.nextInt();
            }
            newList.add(problem);
        }
        out.println(implementSolutionOrNot(newList));
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
