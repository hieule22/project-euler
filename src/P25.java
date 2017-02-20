import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P25 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem25 solver = new Problem25();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem25 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            BigInteger a = BigInteger.ONE;
            BigInteger b = BigInteger.ONE;
            int index = 2;

            while (b.toString().length() < 1000) {
                ++index;
                b = b.add(a);
                a = b.subtract(a);
            }

            out.println(index);
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
