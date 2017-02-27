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
public class P47 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem47 solver = new Problem47();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem47 {
        private static final int UPPER_BOUND = 1000000;
        private int[] nPrimeDivisors;

        public Problem47() {
            nPrimeDivisors = new int[UPPER_BOUND];
            boolean[] isPrime = new boolean[UPPER_BOUND];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i < UPPER_BOUND; ++i) {
                if (isPrime[i]) {
                    nPrimeDivisors[i] = 1;
                    for (int j = 2 * i; j < UPPER_BOUND; j += i) {
                        isPrime[j] = false;
                        nPrimeDivisors[j]++;
                    }
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            for (int i = 3; i < UPPER_BOUND; ++i) {
                boolean ok = true;
                for (int j = 0; j < 4; ++j) {
                    if (nPrimeDivisors[i - j] != 4) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    out.println(i - 3);
                    return;
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
