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
public class P7 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem7 solver = new Problem7();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem7 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int maxValue = 1000000;
            boolean[] isPrime = new boolean[maxValue + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            int limit = (int) Math.sqrt(maxValue);
            for (int i = 2; i <= limit; ++i) {
                if (isPrime[i]) {
                    for (int j = i; i * j <= maxValue; ++j) {
                        isPrime[i * j] = false;
                    }
                }
            }

            int nPrimes = 0;
            for (int i = 2; i <= maxValue; ++i) {
                if (isPrime[i]) {
                    ++nPrimes;
                    if (nPrimes == 10001) {
                        out.println(i);
                        return;
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
