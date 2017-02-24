import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
public class P41 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem41 solver = new Problem41();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem41 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int MAX = 7654321;
            for (int n = MAX; n > 1; --n) {
                if (isPandigital(n) && isPrime(n)) {
                    out.println(n);
                    return;
                }
            }

            throw new RuntimeException();
        }

        private boolean isPandigital(int n) {
            String rep = Integer.toString(n);
            int[] frequency = new int[10];
            for (int i = 0; i < rep.length(); ++i)
                ++frequency[rep.charAt(i) - '0'];
            for (int i = 1; i <= rep.length(); ++i) {
                if (frequency[i] != 1)
                    return false;
            }
            return true;
        }

        private boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i * i <= n; ++i) {
                if (n % i == 0)
                    return false;
            }
            return true;
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
