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
public class P48 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem48 solver = new Problem48();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem48 {
        private static final BigInteger MOD = BigInteger.valueOf(10000000000L);

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            BigInteger result = BigInteger.ZERO;
            for (int i = 1; i <= 1000; ++i) {
                result = result.add(modPow(i, i)).mod(MOD);
            }
            out.println(result.toString());
        }

        private BigInteger modPow(int base, int exponent) {
            if (exponent == 0)
                return BigInteger.ONE;
            BigInteger result = modPow(base, exponent / 2);
            result = result.multiply(result).mod(MOD);
            if (exponent % 2 == 1)
                result = result.multiply(BigInteger.valueOf(base)).mod(MOD);
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
