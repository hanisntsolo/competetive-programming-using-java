import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Static imports for less code
import static java.math.BigInteger.valueOf;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
//Utilities
import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;



public class E166 {
    
    /**
     * Weighted Quick Union : Java Implementation + Path Compression
     * Data Structure : Same as quick union, but maintain extra array sz[i]
     * to count the number of objects in a tree rooted at i.
     * 
     * Find : identical to quick union.
     * Union : Modify quick union to :
     *  Link the root of smaller tree to the larger tree.
     *  Update the sz[] array.
     *  
     * Quick Union with path compression : 
     *  Just after computing the root of p,
     *  set the id of each examined node to point to that root.
     * Two pass implementation : 
     *  add second loop to root() to set the id[]
     *  of each examined node to the root.
     * Simple one pass variant : 
     *  Make every other node in its path point to its grandparent
     *  (thereby halving path length).
     */
    static class WeightedQuickUnion {

        private int[] id;
        private int[] sz;
        
        public WeightedQuickUnion(int N) {
            id = new int[N];
            sz = new int[N];
            for(int i = 0 ; i < N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }
        
        public boolean isConnected(int p, int q) {
            return root(p) == root(q);
        }
        
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]]; // Path compression
                i = id[i];
            }
            return i;
        }
        
        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            
            if(i == j) return;

            if(sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
        }
    } 
    /**
     * Quick Union : Lazy Approach
     * 
     * Data Structure : Integer array id[] of size N
     * Interpretation : id[i] is parent of i
     * Root of i is   : id[id[id[id[id[id[id[...id[i]...]]]]]]].
     * Each entry is a root to itself in the beginning. 
     * 
     * Find : Checking if p and q have the same root .. // Equivalent to saying that they are in the same component
     * Quick Union : Set the id[p] root to the id[q] root .. //Equivalent to saying pointing p's tree point to q.
     * 
     * Quick Find
     * Defect : 
     *  union is still to expensive(N array accesses.)
     *  Trees are flat but too expensive to keep them flat.
     * 
     * Quick Union
     * Defect : 
     *  Trees can get tall.
     *  Find too expensive can be N array accesses.
     * 
     * Improvement : Avoid tall trees.
     * Weighted Quick Union
     *  Modify Quick Union to avoid tall trees.
     *  Keep track of size of each tree i.e. number of objects
     *  Balance by linking root of smaller tree to the root of larger tree.
     */
    static class QuickUnion {
        private int[] id;
        public QuickUnion(int N) {
            id = new int[N];
            for(int i = 0 ; i < N; i++) {
                id[i] = i;
            }
        }
        public boolean isConnected(int p, int q) {
            return root(p) == root(q);
        }
        private int root(int i) {
            while(i != id[i]) 
                i = id[i];
            return i;
        }
        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            id[i] = j;
        }
    }
    //Eager approach
    /* Data Structure : Integer array[] id of size N.
     * Interpretation : p and q are connected iff they have the same id.
     * 
     * Find : Check if p and q have the same id.
     * Union: To merge component containing two diff objects p and q, change all entries whos
     *        id equals to id[p] to id[q].
     * Defect : Union is too expensive.
     */
    static class UFEager {

        private int[] id;

        public UFEager(int n) {
            id = new int[n];
            for(int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        public boolean isConnected(int p, int q) {
            return id[p] == id[q];
        }

        public void union(int p, int q) {
            int pId = id[p];
            int qId = id[q];
            for(int i = 0; i < id.length; i++) {
                if(id[i] == pId)
                    id[i] = qId;
            }
        }
    }

    /*                                                     "Om"
                                                    ""thou art that""
    */
    
    /* COMMIT TO MEMORY WHILE USING JAVA IN COMPETETIVE PROGRAMMING */
    //#String Manipulations:
    //    1: Use deleteChatAt() on stringBuilder with loc 2 to remove newLine extra char while printing. gave me a (PIA).
        
    //# Always use Collections.sort()// merge sort over any other sorting algorithm.
    //# It will help avoid TLE.

    //# Notes: to keep in mind while coding - the program must run in max 1 sec.
    // and 1 sec is equivalent to 10^8 instruction at most.
    //## make sure to utilize fastI/O - Readers implementation and PrintWriters implementation
    // is already present;

    //## Always try to use BigInteger class while writing contests.

    //## While comparing wrapper class objects please use equals method 
    // or write your own implementation of the equals method.
    
    //## When writing comparator and using in sorting the values make sure you do not
    // break the general contract of writing a comparator.
    
    //## while comparing characters make sure to enclose in single quotes.

    public static void main(String[] args) throws IOException {
        long test = fs.nextLong();
        while(test > 0) {
            //Write code here;
            solve();
            test--;
        }

        out.flush(); // to flush the output
    }
    public static void solve() {
        // code goes here//
        
    }

static StringBuilder sb = new StringBuilder();
static StringBuilder gsb = new StringBuilder();
static PrintWriter out = new PrintWriter(System.out);
static Reader rd = new Reader();
static FastScanner fs = new FastScanner();
static final Random random=new Random();
static final int mod=1_000_000_007;
static long[][] vals;

//My helper methods :
    public static Boolean isfrequencyDivisible(Collection<Integer> valueSet, int k) {
        for(Integer i : valueSet) {
            if(i % k == 0) continue;
            else
                return false;
        }
        return true;
    }
    public static String convertCharSetToString(Set<Character> charSet) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : charSet) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public static String multiplyString(String string, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        while(times > 0) {
            stringBuilder.append(string);
            times--;
        }
        return stringBuilder.toString();
    }
    static void print(ArrayList list) {
        list.toArray();
        out.print(list + "\n");
    }
    static void subsets(int n) {
        // code goes here//
        int[] set = new int[n];
        for(int i = 0; i < n; i++) {
            set[i] = i + 1;
        }
        ArrayList<ArrayList<Integer>> listFinal = new ArrayList<>();
        for(int mask = 0; mask <= Math.pow(2 , n) - 1; mask++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < set.length; j++) {
                //process element
                int ele = set[j];
                if((mask & (1 << n - 1 - j)) > 0) {
                    list.add(ele);
                }
            }
            listFinal.add(list);
        }
        Collections.sort(listFinal, new Comparator<ArrayList>(){
            @Override
            public int compare(ArrayList list1, ArrayList list2) {
                return list1.size() - list2.size();
            }
        });
        for(int i = 0 ; i < listFinal.size(); i++) {
            print(listFinal.get(i));
        }
    }

static void ruffleSort(int[] a) {
    int n=a.length;//shuffle, then sort 
    for (int i=0; i<n; i++) {
        int oi=random.nextInt(n), temp=a[oi];
        a[oi]=a[i]; a[i]=temp;
    }
    Arrays.sort(a);
}

static long add(long a, long b) {
    return (a+b)%mod;
}

static long sub(long a, long b) {
    return ((a-b)%mod+mod)%mod;
}

static long mul(long a, long b) {
    return (a*b)%mod;
}

static long exp(long base, long exp) {
    if (exp==0) return 1;
    long half=exp(base, exp/2);
    if (exp%2==0) return mul(half, half);
    return mul(half, mul(half, base));
}

static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }
    
static long nCk(int n, int k) {
    return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
}

static class Pair implements Comparable<Pair> {
        int i, j;
        long cost;
        public Pair(int i, int j, long cost) {
            this.i=i;
            this.j=j;
            this.cost=cost;
        }
        public int compareTo(Pair o) {
            return -Long.compare(cost, o.cost);
        }
    }
static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
}
static class Node {
        int index;
        ArrayList<Node> adj=new ArrayList<>();
        Node par;
        long parEdgeVal;
        int subtreeSize;
 
        public Node(int i) {
            this.index=i;
        }
        void dfs(Node par) {
            this.par=par;
            subtreeSize++;
            for (Node nn:adj) {
                if (nn==par) {
                    continue;
                }
                nn.dfs(this);
                subtreeSize+=nn.subtreeSize;
            }
            if (par!=null) {
                long decreaseToMe=vals[0][par.index]-vals[0][index];
                if (decreaseToMe%subtreeSize!=0) throw null;
                parEdgeVal=decreaseToMe/subtreeSize;
            }
        }
    }

static class DisjointSet {
        int[] s;
        
        public DisjointSet(int n) {
            Arrays.fill(s = new int[n], -1);
        }
        
        public int find(int i) {
            return s[i] < 0 ? i : (s[i] = find(s[i]));
        }
        
        public boolean union(int a, int b) {
            if ((a = find(a)) == (b = find(b))) return false;
            if(s[a] == s[b]) s[a]--;
            if(s[a] <= s[b]) s[b] = a; 
            else s[a] = b;
            return true;
        }
    }
static long gcd(long u, long v) {
    int shift;

    if (u == 0) return v;
    if (v == 0) return u;

    for (shift = 0; ((u | v) & 1) == 0; ++shift) {
        u >>= 1;
        v >>= 1;
    }

    while ((u & 1) == 0) {
        u >>= 1;
    }

    do {
        while ((v & 1) == 0) {
            v >>= 1;
        }

        if (u > v) {
            long t = v;
            v = u;
            u = t;
        }

        v = v - u;
    } while (v != 0);

    return u << shift;
}
static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long[] readLongArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
}

static class IncComp implements Comparator<Integer> {
    @Override
    public int compare(Integer a , Integer b) {
        return a < b ? -1 : a > b ? 1 : 0;
    }
}
static class DescComp implements Comparator<Integer> {
    @Override
    public int compare(Integer a , Integer b) {
        return a < b ? 1 : a > b ? -1 : 0;
    }
}
static Queue<Integer> ascQ = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
            return a <= b ? -1 : 1;
        }
});
static Queue<Integer> descQ = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
            return a >= b ? -1 : 1;
        }
});

static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(
                new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[101]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) {
                    break;
                } else {
                    continue;
                }
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt - 1);
    }

    public int nextInt() throws IOException {
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

    public long nextLong() throws IOException {
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

    public double nextDouble() throws IOException {
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

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0,
                BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }

}
}