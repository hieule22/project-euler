import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P44 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem44 solver = new Problem44();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem44 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            List<Integer> pentagons = new ArrayList<>();
            int generator = 1;
            while (true) {
                int pentagon = generator * (3 * generator - 1) / 2;
                for (int i = pentagons.size() - 1; i >= 0; --i) {
                    if (isPentagon(pentagon + pentagons.get(i)) && isPentagon(pentagon - pentagons.get(i))) {
                        out.println(pentagon - pentagons.get(i));
                        return;
                    }
                }
                pentagons.add(pentagon);
                ++generator;
            }
        }

        private boolean isPentagon(int n) {
            int low = 1, high = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                long value = (long) mid * (3 * mid - 1) / 2;
                if (n == value)
                    return true;
                else if (value < n)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return false;
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
