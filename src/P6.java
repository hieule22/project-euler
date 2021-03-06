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
public class P6 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem6 solver = new Problem6();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem6 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int bound = 100;
            int sumOfSquares = 0;
            int squareOfSum = 0;
            for (int i = 1; i <= bound; ++i) {
                sumOfSquares += i * i;
                squareOfSum += i;
            }
            squareOfSum *= squareOfSum;
            out.println(squareOfSum - sumOfSquares);
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
