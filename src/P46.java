import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P46 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem46 solver = new Problem46();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem46 {
        private static final int UPPER_BOUND = 10000000;
        private boolean[] isPrime;

        public Problem46() {
            isPrime = new boolean[UPPER_BOUND];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i < UPPER_BOUND; ++i) {
                if (isPrime[i]) {
                    for (int j = i * 2; j < UPPER_BOUND; j += i)
                        isPrime[j] = false;
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int n = 9; n < UPPER_BOUND; n += 2) {
                if (!isPrime[n]) {
                    boolean ok = true;
                    for (int i = 1; 2 * i * i < n; ++i) {
                        if (isPrime[n - 2 * i * i]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        out.println(n);
                        break;
                    }
                }
            }
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
