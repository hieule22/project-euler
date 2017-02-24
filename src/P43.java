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
public class P43 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem43 solver = new Problem43();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem43 {
        private static final int N_DIGITS = 10;
        private static final int[] divisors = {2, 3, 5, 7, 11, 13, 17};
        private long sum;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            boolean[] taken = new boolean[N_DIGITS];
            sum = 0;
            permute(0, taken, 0);
            out.println(sum);
        }

        private void permute(int position, boolean[] taken, long value) {
            if (position == N_DIGITS) {
                if (check(value))
                    sum += value;
                return;
            }

            int start = position == 0 ? 1 : 0;
            for (int i = start; i < taken.length; ++i) {
                if (!taken[i]) {
                    taken[i] = true;
                    permute(position + 1, taken, value * 10 + i);
                    taken[i] = false;
                }
            }
        }

        private boolean check(long value) {
            for (int i = divisors.length - 1; i >= 0; --i) {
                long current = value % 1000;
                if (current % divisors[i] != 0)
                    return false;
                value /= 10;
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
