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
public class P36 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem36 solver = new Problem36();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem36 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int sum = 0;
            final int MAX = 1000000;
            for (int n = 1; n < MAX; ++n) {
                if (isPalindrome(Integer.toString(n)) && isPalindrome(Integer.toBinaryString(n)))
                    sum += n;
            }
            out.println(sum);
        }

        private boolean isPalindrome(String s) {
            int forward = 0, backward = s.length() - 1;
            while (forward < backward) {
                if (s.charAt(forward) != s.charAt(backward))
                    return false;
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
