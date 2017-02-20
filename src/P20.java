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
public class P20 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem20 solver = new Problem20();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem20 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= 100; ++i) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }

            int sumOfDigits = 0;
            for (char digit : factorial.toString().toCharArray()) {
                sumOfDigits += Character.getNumericValue(digit);
            }
            out.println(sumOfDigits);
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
