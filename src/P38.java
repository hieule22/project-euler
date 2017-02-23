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
public class P38 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem38 solver = new Problem38();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem38 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            final int MAX = 10000;
            int result = 0;
            for (int n = 2; n < 10; ++n) {
                for (int i = 1; i < MAX; ++i) {
                    String temp = check(i, n);
                    if (temp != null)
                        result = Math.max(result, Integer.parseInt(temp));
                }
            }
            out.println(result);
        }

        private String check(int p, int n) {
            String res = "";
            for (int i = 1; i <= n; ++i)
                res += Integer.toString(p * i);
            int[] seen = new int[10];
            for (char c : res.toCharArray())
                ++seen[c - '0'];
            if (seen[0] > 0)
                return null;
            for (int i = 1; i < 10; ++i)
                if (seen[i] != 1)
                    return null;
            return res;
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
