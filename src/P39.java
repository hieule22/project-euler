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
public class P39 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem39 solver = new Problem39();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem39 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int MAX = 1000;
            int[] cache = new int[MAX + 1];
            for (int a = 1; a < MAX; ++a) {
                for (int b = a; b < MAX; ++b) {
                    int c = (int) Math.sqrt(a * a + b * b);
                    int perimeter = a + b + c;
                    if (a * a + b * b == c * c && perimeter <= MAX) {
                        ++cache[perimeter];
                    }
                }
            }

            int res = 0, maxSolutions = 0;
            for (int i = 1; i <= MAX; ++i) {
                if (maxSolutions < cache[i]) {
                    maxSolutions = cache[i];
                    res = i;
                }
            }
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
