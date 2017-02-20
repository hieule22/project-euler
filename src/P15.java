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
public class P15 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem15 solver = new Problem15();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem15 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            out.println(nCr(40, 20).toString());
        }

        private BigInteger nCr(int n, int k) {
            BigInteger numerator = factorial(n);
            BigInteger denominator = factorial(n - k).multiply(factorial(k));
            return numerator.divide(denominator);
        }

        private BigInteger factorial(int n) {
            BigInteger result = BigInteger.ONE;
            for (int i = 1; i <= n; ++i) {
                result = result.multiply(BigInteger.valueOf(i));
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
