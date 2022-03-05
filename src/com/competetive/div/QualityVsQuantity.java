package com.competetive.div;
// Working program using Reader Class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class QualityVsQuantity {
    public static int binary_search(int[] A, int target) {
        int lo = 1, hi = A.length - 1;
      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (A[mid] == target) {
          return mid;
        } else if (A[mid] < target) {
          lo = mid + 1;
        }
          else{
            hi = mid - 1;
          }
        }
      return -1;
      }
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        StringBuilder stringBuilder = new StringBuilder();
        for(int test = sc.nextInt(); test>0 ;test--) {
          ArrayList<Integer> list = new ArrayList<>();
          for (int i = sc.nextInt(); i > 0 ; i--) {
            list.add(sc.nextInt());
          }
          list.add(sc.nextInt());
          Collections.sort(list);
          Collections.reverse(list);
          long sumRed = 0;
          long sumBlue = 0;
          long k = 0;
          boolean flag = false;
          for (int i = 0; i < list.size(); i++) {
            sumRed = list.get(i);
            long count = 0;
            for (k = list.size() - 1; k > i ; k--) {
              count += 1;
              sumBlue+=list.get((int)k);
              if(sumBlue>sumRed && count > 1) {
                stringBuilder.append("\n").append("YES");
                flag = true;
                break;
              }
            }
            if(flag) break;
          }
            if(!flag) stringBuilder.append("\n").append("NO");
          }
      System.out.println(stringBuilder);
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
