package com.competetive.cses;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class SumOfTwoValues {

    public static void positionOfTarget(int[] array, int target) {
        boolean found = false;
        for(int i=0;i<array.length;i++) {
            int numToFind = target - array[i];
            for(int j=i+1;j<array.length;j++) {
                if(array[j] == numToFind) {
                    System.out.println(i+1+" "+(j+1));
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        if(!found)
        System.out.println("IMPOSSIBLE");
    }
    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int length = sc.nextInt();
        int target = sc.nextInt();
        int[] array = new int[length];
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false;
        int count = 0;
        for(int i=0;i<array.length;i++) {
            count++;
            array[i] = sc.nextInt();
            int numberToFind = target - array[i];
            if(map.containsKey(array[i])) {
                System.out.println(i+1 + " " + map.get(array[i]));
                found = true;
                break;
            } else {
                map.put(numberToFind,i+1);
            }
        }
//        System.out.println(count);
        if(!found)
        System.out.println("IMPOSSIBLE");
//        positionOfTarget(array, target);
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
