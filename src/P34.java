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
public class P34 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem34 solver = new Problem34();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem34 {
        private int[] facts;

        public Problem34() {
            facts = new int[10];
            facts[0] = 1;
            for (int i = 1; i < facts.length; ++i) {
                facts[i] = facts[i - 1] * i;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int MAX = 10000000;
            int sum = 0;
            for (int n = 10; n <= MAX; ++n) {
                if (check(n)) {
                    sum += n;
                }
            }
            out.println(sum);
        }

        private boolean check(int n) {
            int sum = 0;
            for (char c : Integer.toString(n).toCharArray()) {
                sum += facts[Character.getNumericValue(c)];
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
