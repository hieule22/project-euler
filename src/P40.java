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
public class P40 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem40 solver = new Problem40();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem40 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int MAX = 1000000;
            StringBuilder sb = new StringBuilder();
            int current = 1;
            while (sb.length() < MAX) {
                sb.append(Integer.toString(current));
                ++current;
            }

            int res = 1;
            for (int i = 1; i <= MAX; i *= 10)
                res *= Character.getNumericValue(sb.charAt(i - 1));
            out.println(res);
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
