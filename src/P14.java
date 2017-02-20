import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P14 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem14 solver = new Problem14();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem14 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Map<Long, Integer> cache = new HashMap<>();
            cache.put(1L, 1);
            int maxStart = 1, maxLength = 1;
            for (int start = 1; start <= 1000000; ++start) {
                List<Long> sequence = new ArrayList<>();
                long current = start;
                while (!cache.containsKey(current)) {
                    sequence.add(current);
                    current = next(current);
                }

                int length = cache.get(current);
                for (int i = sequence.size() - 1; i >= 0; --i) {
                    ++length;
                    cache.put(sequence.get(i), length);
                }

                if (length > maxLength) {
                    maxLength = length;
                    maxStart = start;
                }
            }

            out.println(maxStart);
        }

        private long next(long n) {
            return n % 2 == 0 ? n / 2 : 3 * n + 1;
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
