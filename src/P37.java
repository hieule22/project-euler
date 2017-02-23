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
public class P37 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem37 solver = new Problem37();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem37 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int cnt = 0, current = 11, sum = 0;
            final int N_SOLUTIONS = 11;
            while (cnt < N_SOLUTIONS) {
                if (check(current)) {
                    sum += current;
                    ++cnt;
                }
                ++current;
            }
            out.println(sum);
        }

        private boolean check(int n) {
            String rep = Integer.toString(n);
            for (int i = 0; i < rep.length(); ++i) {
                if (i > 0 && !isPrime(rep.substring(0, i)))
                    return false;
                if (!isPrime(rep.substring(i)))
                    return false;
            }
            return true;
        }

        private boolean isPrime(String rep) {
            int n = Integer.parseInt(rep);
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
