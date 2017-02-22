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
public class P35 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem35 solver = new Problem35();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem35 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int MAX = 1000000;
            int ans = 0;
            for (int i = 2; i < MAX; ++i) {
                if (check(i)) {
                    ++ans;
                }
            }
            out.println(ans);
        }

        private boolean check(int n) {
            String rep = Integer.toString(n);
            for (int i = 0; i < rep.length(); ++i) {
                rep = rep.substring(1) + rep.charAt(0);
                if (!isPrime(Integer.parseInt(rep)))
                    return false;
            }
            return true;
        }

        private boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }

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
