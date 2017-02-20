import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P22 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem22 solver = new Problem22();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem22 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String input = in.next();
            String[] tokens = input.split(",");
            Arrays.sort(tokens);
            int result = 0;
            for (int i = 0; i < tokens.length; ++i) {
                int value = 0;
                for (char c : tokens[i].toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        value += c - 'A' + 1;
                    }
                }
                result += value * (i + 1);
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

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

    }
}
