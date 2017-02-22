import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P32 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem32 solver = new Problem32();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem32 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int MAX = 200000;
            Set<Integer> products = new HashSet<>();
            for (int n = 1; n < MAX; ++n) {
                for (int m = n; (long) m * n < MAX; ++m) {
                    int product = n * m;
                    if (check(n, m, product))
                        products.add(product);
                }
            }
            int answer = 0;
            for (int product : products)
                answer += product;
            out.println(answer);
        }

        private boolean check(int a, int b, int c) {
            String rep = Integer.toString(a) + Integer.toString(b) + Integer.toString(c);
            if (rep.length() != 9)
                return false;
            int[] frequency = new int[10];
            for (char digit : rep.toCharArray()) {
                ++frequency[digit - '0'];
            }
            for (int i = 1; i < 10; ++i) {
                if (frequency[i] != 1) {
                    return false;
                }
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
