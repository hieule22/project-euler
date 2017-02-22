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
public class P31 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem31 solver = new Problem31();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem31 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int[] values = {1, 2, 5, 10, 20, 50, 100, 200};
            final int TOTAL = 200;
            int[][] ways = new int[TOTAL + 1][values.length];
            for (int i = 0; i <= TOTAL; ++i) {
                ways[i][0] = 1;
            }

            for (int i = 1; i < values.length; ++i) {
                for (int j = 0; j <= TOTAL; ++j) {
                    int residue = j;
                    while (residue >= 0) {
                        ways[j][i] += ways[residue][i - 1];
                        residue -= values[i];
                    }
                }
            }

            out.println(ways[TOTAL][values.length - 1]);
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
