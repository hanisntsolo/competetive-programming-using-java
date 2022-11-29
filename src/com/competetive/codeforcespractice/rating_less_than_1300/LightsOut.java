
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import java.util.Arrays;

public class LightsOut {
	private static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}}; 
	private	static int[][] initialGrid = {{1,1,1},{1,1,1},{1,1,1}};
	public static void main(String[] args) throws IOException {
		int[][] grid = getGrid();
		System.out.println(Arrays.deepToString(grid));
		//Change the state of the grid according to belwo logic
		//if the state is even adjacent flips dont happen at all.
		//if the state is odd then the adjacent and the number flips.
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if((grid[i][j] & 1) == 0) {
					continue;
				} else {
					//perform state change there and all adjacent values.
					performStateChange(initialGrid, i, j);
				}
			}
		}
		System.out.println(Arrays.deepToString(initialGrid));
	}
	public static void performStateChange(int[][] initialGrid, int i, int j) {
		int nextState = initialGrid[i][j] == 1 ? 0 : 1;
		initialGrid[i][j] = nextState;
		for(int direction = 0; direction < directions.length; direction++) {
			int nextRow = i + directions[direction][0];
			int nextCol = j + directions[direction][1];
			System.out.println("NextDirection :: row" + nextRow+ " col" + nextCol);
			if(nextRow < 0 || nextCol < 0 || nextRow > 2 || nextCol > 2)
				continue;
			//changeState(initialGrid, nextRow, nextCol, nextState);
			initialGrid[nextRow][nextCol] = nextState;
			System.out.println("Changed :: row" + nextRow+ " col" + nextCol);
		}
		System.out.println("State Changed :: ");
		System.out.println("row ::" + i + " col ::" + j);
		System.out.println(Arrays.deepToString(initialGrid));
	}
	public static void changeState(int[][] initialGrid, int nextRow, int nextCol, int state) {
		initialGrid[nextRow][nextCol] = state;
	}
	public static int[][] getGrid() throws IOException {
		Reader rd = new Reader();
		int[][] grid = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grid[i][j] = rd.nextInt();
			}
		}
		return grid;
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