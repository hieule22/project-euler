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
public class P30 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem30 solver = new Problem30();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem30 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int LIMIT = 1000000;
            int sum = 0;
            for (int n = 10; n <= LIMIT; ++n) {
                if (check(n)) {
                    sum += n;
                }
            }
            out.println(sum);
        }

        private boolean check(int n) {
            char[] rep = Integer.toString(n).toCharArray();
            int sum = 0;
            for (char c : rep) {
                sum += (int) Math.pow(Character.getNumericValue(c), 5);
            }
            return sum == n;
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
