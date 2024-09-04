import java.util.*;
public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            long n = sc.nextLong(), q = sc.nextLong();
            long[] a = new long[(int) n];
            ArrayList<Long> ps = new ArrayList<>(Collections.singletonList(0L));  // prefix sum array

            // Input array and build prefix sum array // this was clean and fast liked the approach.
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                ps.add(ps.get(ps.size() - 1) + a[i]);
            }
            for (int i = 0; i < n; i++) {
                ps.add(ps.get(ps.size() - 1) + a[i]);
            }

            // Processing queries
            while (q-- > 0) {
                long l = sc.nextLong() - 1;
                long r = sc.nextLong() - 1;
                long i = l / n, j = r / n;
                l %= n;
                r %= n;

                long result = ps.get((int) n) * (j - i + 1) 
                            - (ps.get((int) (i + l)) - ps.get((int) i))
                            - (ps.get((int) (j + n)) - ps.get((int) (j + r + 1)));
                
                System.out.println(result);
            }
        }
        sc.close();
    }
}
