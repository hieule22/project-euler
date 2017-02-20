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
public class P4 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem4 solver = new Problem4();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem4 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int result = -1;
            for (int i = 100; i < 1000; ++i) {
                for (int j = 100; j < 1000; ++j) {
                    int product = i * j;
                    if (isPalindrome(product)) {
                        result = Math.max(result, product);
                    }
                }
            }
            out.println(result);
        }

        private boolean isPalindrome(int n) {
            String rep = Integer.toString(n);
            int forward = 0, backward = rep.length() - 1;
            while (forward < backward) {
                if (rep.charAt(forward) != rep.charAt(backward)) {
                    return false;
                }
                ++forward;
                --backward;
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
