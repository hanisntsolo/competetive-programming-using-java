package com.competetive.div;
// Working program using Reader Class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.out;

public class SquareCounting {
//    public static void main(String[] args) throws IOException {
//        Reader sc = new Reader();
//        for(int test = sc.nextInt();test>0; test--) {
//          BigInteger n = new BigInteger(String.valueOf(sc.nextInt()));
//          BigInteger s = new BigInteger(String.valueOf(sc.nextInt()));
//          BigInteger count = new BigInteger("0");
//          BigInteger square = n.multiply(n);
//          while(s.subtract(square).longValue() >= new BigInteger("0").longValue()) {
//            s = s.subtract(square);
//            count = count.add(new BigInteger("1"));
//            if(s.subtract(square).longValue() < new BigInteger("0").longValue()) break;
//          }
//          out.println(count.longValue());
//        }
//      }
  public static void main(String[] args) throws IOException {
    Reader sc = new Reader();
    StringBuilder stringBuilder = new StringBuilder();
    for(long test = sc.nextInt();test>0; test--) {
      long n = sc.nextLong();
      long s = sc.nextLong();
      long count = 0;
      long square = n*n;
      if ((s - square) >= 0) {
        count  = (int)(s / square);
      }
      stringBuilder.append(count).append("\n");
    }
    out.println(stringBuilder);
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
