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
public class P23 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem23 solver = new Problem23();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem23 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int result = 0;
            final int MAX = 28123;
            boolean[] isAbundant = new boolean[MAX + 1];
            for (int i = 1; i <= MAX; ++i) {
                isAbundant[i] = isAbundant(i);
            }
            for (int i = 1; i <= MAX; ++i) {
                if (!isAbundantSum(i, isAbundant)) {
                    result += i;
                }
            }
            out.println(result);
        }

        private boolean isAbundantSum(int n, boolean[] isAbundant) {
            for (int i = 1; i < n; ++i) {
                if (isAbundant[i] && isAbundant[n - i]) {
                    return true;
                }
            }
            return false;
        }

        private boolean isAbundant(int n) {
            int sumOfDivisors = 0;
            for (int i = 1; i < n; ++i) {
                if (n % i == 0) {
                    sumOfDivisors += i;
                }
            }
            return sumOfDivisors > n;
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
