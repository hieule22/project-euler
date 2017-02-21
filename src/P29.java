import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P29 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem29 solver = new Problem29();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem29 {
        private static final int LIMIT = 100;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Set<Map<Integer, Integer>> dict = new HashSet<>();
            for (int a = 2; a <= LIMIT; ++a) {
                Map<Integer, Integer> src = new HashMap<>();
                int temp = a;
                for (int i = 2; i <= temp; ++i) {
                    int exponent = 0;
                    while (temp % i == 0) {
                        ++exponent;
                        temp /= i;
                    }
                    if (exponent > 0) {
                        src.put(i, exponent);
                    }
                }

                for (int b = 2; b <= LIMIT; ++b) {
                    Map<Integer, Integer> id = new HashMap<>();
                    for (Map.Entry<Integer, Integer> entry : src.entrySet()) {
                        id.put(entry.getKey(), entry.getValue() * b);
                    }
                    dict.add(id);
                }
            }

            out.println(dict.size());
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private static final int BUFFER_SIZE = 32768;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(
                    new InputStreamReader(stream), BUFFER_SIZE);
            tokenizer = null;
        }

    }
}
