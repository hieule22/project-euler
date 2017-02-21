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
public class P27 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem27 solver = new Problem27();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem27 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int product = 0;
            int maxPrimes = 0;
            for (int a = -999; a <= 999; ++a) {
                for (int b = -1000; b <= 1000; ++b) {
                    int nPrimes = countPrimes(a, b);
                    if (maxPrimes < nPrimes) {
                        maxPrimes = nPrimes;
                        product = a * b;
                    }
                }
            }
            out.println(product);
        }

        private int countPrimes(int a, int b) {
            int result = 0;
            int variable = 0;
            while (isPrime(variable * variable + a * variable + b)) {
                ++result;
                ++variable;
            }

            return result;
        }

        private boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i * i <= n; ++i) {
                if (n % i == 0)
                    return false;
            }
            return true;
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
