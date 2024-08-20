import java.io.*;
import java.util.*;

public class JEFFANDPERIODS {

    // FastScanner for faster input reading
    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
        // Read the length of the sequence
        int n = scanner.nextInt();
        // Read the sequence
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }
        
        // Step 1: Collect positions of each number
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(sequence[i], k -> new ArrayList<>()).add(i + 1);
        }
        
        // Step 2: Analyze each number's positions
        TreeMap<Integer, Integer> results = new TreeMap<>();
        for (int number : positions.keySet()) {
            List<Integer> posList = positions.get(number);
            if (posList.size() == 1) {
                // Only one occurrence, px = 0
                results.put(number, 0);
            } else {
                // More than one occurrence, check the common difference
                Set<Integer> differences = new HashSet<>();
                for (int i = 1; i < posList.size(); i++) {
                    differences.add(posList.get(i) - posList.get(i - 1));
                }
                if (differences.size() == 1) {
                    int commonDifference = differences.iterator().next();
                    results.put(number, commonDifference);
                }
            }
        }
        
        // Step 3: Output results using PrintWriter
        out.println(results.size());
        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            out.println(entry.getKey() + " " + entry.getValue());
        }
        
        out.flush();
        out.close();
    }
}
