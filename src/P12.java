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
public class P12 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem12 solver = new Problem12();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem12 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = 1;
            while (true) {
                long value = n * (n + 1) / 2;
                if (countDivisors(value) > 500) {
                    out.println(value);
                    return;
                }
                ++n;
            }
        }

        private int countDivisors(long n) {
            long primeLimit = (long) Math.sqrt(n);
            int result = 1;
            int primeDivisor = 2;
            while (primeDivisor <= primeLimit) {
                int exponent = 0;
                while (n % primeDivisor == 0) {
                    ++exponent;
                    n /= primeDivisor;
                }
                result *= (exponent + 1);
                ++primeDivisor;
            }

            if (n > 1) {
                result *= 2;
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
