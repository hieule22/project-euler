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
public class P26 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem26 solver = new Problem26();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem26 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int result = 0;
            int maxPeriod = 0;
            for (int i = 1; i < 1000; ++i) {
                int period = getPeriod(i);
                if (maxPeriod < period) {
                    maxPeriod = period;
                    result = i;
                }
            }
            out.println(result);
        }

        private int getPeriod(int n) {
            while (n % 2 == 0) {
                n /= 2;
            }

            while (n % 5 == 0) {
                n /= 5;
            }

            if (n == 1) {
                return 0;
            }

            int result = 1;
            int current = 10;
            while (current % n != 1) {
                ++result;
                current = current * 10 % n;
            }
            return result;
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
