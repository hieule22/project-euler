import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.function.Function;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P45 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem45 solver = new Problem45();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem45 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Function<Long, Long> triangleGenerator = n -> n * (n + 1) / 2;
            Function<Long, Long> pentagonGenerator = n -> n * (3 * n - 1) / 2;
            Function<Long, Long> hexagonGenerator = n -> n * (2 * n - 1);

            long generator = 144;
            while (true) {
                long value = hexagonGenerator.apply(generator);
                if (check(value, triangleGenerator) && check(value, pentagonGenerator)) {
                    out.println(value);
                    return;
                }
                ++generator;
            }
        }

        private boolean check(long target, Function<Long, Long> generator) {
            long low = 1, high = target;
            while (low <= high) {
                long mid = low + (high - low) / 2;
                long value = generator.apply(mid);
                if (value == target)
                    return true;
                else if (value > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return false;
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
