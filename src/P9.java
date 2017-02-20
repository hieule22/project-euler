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
public class P9 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem9 solver = new Problem9();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem9 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int SUM = 1000;
            for (int a = 1; a < SUM; ++a) {
                for (int b = 1; a + b < SUM; ++b) {
                    int c = SUM - a - b;
                    if (a * a + b * b == c * c) {
                        out.println(a * b * c);
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
