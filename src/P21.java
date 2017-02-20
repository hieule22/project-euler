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
public class P21 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem21 solver = new Problem21();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem21 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int result = 0;
            for (int i = 1; i <= 10000; ++i) {
                int sumOfDivisors = getSumOfDivisors(i);
                if (sumOfDivisors <= 10000 && sumOfDivisors != i
                    && getSumOfDivisors(sumOfDivisors) == i) {
                    result += (i + sumOfDivisors);
                }
            }
            out.println(result / 2);
        }

        private int getSumOfDivisors(int n) {
            int sum = 0;
            for (int i = 1; i < n; ++i) {
                if (n % i == 0) {
                    sum += i;
                }
            }
            return sum;
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
