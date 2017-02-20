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
public class P3 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem3 solver = new Problem3();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem3 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = 600851475143L;
            long squareRoot = (long) Math.sqrt(n);
            int primeFactor = 2;
            long result = -1;
            while (primeFactor <= squareRoot) {
                while (n % primeFactor == 0) {
                    result = primeFactor;
                    n /= primeFactor;
                }
                ++primeFactor;
            }

            if (n > 1) {
                result = Math.max(result, n);
            }

            out.println(result);
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
