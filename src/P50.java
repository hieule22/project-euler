import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P50 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem50 solver = new Problem50();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem50 {
        private static final int UPPER_BOUND = 1000000;
        private boolean[] isPrime;
        private List<Integer> primes;

        public Problem50() {
            isPrime = new boolean[UPPER_BOUND];
            Arrays.fill(isPrime, 2, isPrime.length, true);
            primes = new ArrayList<>();
            for (int i = 2; i < UPPER_BOUND; ++i) {
                if (isPrime[i]) {
                    primes.add(i);
                    for (int j = i + i; j < UPPER_BOUND; j += i)
                        isPrime[j] = false;
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int result = -1, length = 0;
            for (int start = 0; start < primes.size(); ++start) {
                int current = 0;
                for (int end = start; end < primes.size(); ++end) {
                    current += primes.get(end);
                    if (current >= UPPER_BOUND)
                        break;
                    if (isPrime[current] && length < end - start + 1) {
                        length = end - start + 1;
                        result = current;
                    }
                }
            }
            out.println(result);
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
