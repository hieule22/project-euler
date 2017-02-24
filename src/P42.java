import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
public class P42 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem42 solver = new Problem42();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem42 {
        private boolean[] triangleNumbers;
        private final int MAX = 10000;

        public Problem42() {
            triangleNumbers = new boolean[MAX];
            int n = 1, sum = n;
            while (sum < MAX) {
                triangleNumbers[sum] = true;
                ++n;
                sum += n;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String[] words = in.next().split(",");
            int ans = 0;
            for (String word : words) {
                if (isTriangleWord(word.substring(1, word.length() - 1)))
                    ++ans;
            }
            out.println(ans);
        }

        private boolean isTriangleWord(String word) {
            int sum = 0;
            for (char c : word.toCharArray())
                sum += (c - 'A' + 1);
            return sum < MAX && triangleNumbers[sum];
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
