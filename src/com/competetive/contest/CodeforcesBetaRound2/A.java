import java.util.*;
public class A {
    // Brute Force Approach and is quite subtle.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            String[] s = new String[10000];
            int[] a = new int[10000];
            Map<String, Long> mp = new HashMap<>();

            for (int i = 0; i < n; i++) {
                s[i] = scanner.next();
                a[i] = scanner.nextInt();
                mp.put(s[i], mp.getOrDefault(s[i], 0L) + a[i]);
            }

            long mx = 0;
            for (int i = 0; i < n; i++) {
                mx = Math.max(mp.get(s[i]), mx);
            }

            Map<String, Long> mp2 = new HashMap<>();
            String ans = "";
            for (int i = 0; i < n; i++) {
                mp2.put(s[i], mp2.getOrDefault(s[i], 0L) + a[i]);
                if (mp2.get(s[i]) >= mx && mp.get(s[i]) == mx) {
                    ans = s[i];
                    break;
                }
            }

            System.out.println(ans);
        }

        scanner.close();
    }
}