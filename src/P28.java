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
public class P28 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem28 solver = new Problem28();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem28 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int LENGTH = 1001;
            int sum = 1;
            for (int i = 1; i < (LENGTH + 1) / 2; ++i) {
                int val = (2 * i + 1) * (2 * i + 1);
                int difference = 2 * i;
                for (int j = 0; j < 4; ++j) {
                    sum += val;
                    val -= difference;
                }
            }

            out.println(sum);
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
