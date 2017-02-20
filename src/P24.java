import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P24 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem24 solver = new Problem24();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem24 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            boolean[] taken = new boolean[10];
            List<String> memo = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            generatePermutations(memo, taken, sb);
            Collections.sort(memo);
            out.println(memo.get(999999));
        }

        private void generatePermutations(List<String> memo, boolean[] taken, StringBuilder sb) {
            if (sb.length() == taken.length) {
                memo.add(sb.toString());
                return;
            }

            for (int i = 0; i < taken.length; ++i) {
                if (!taken[i]) {
                    taken[i] = true;
                    sb.append(Integer.toString(i));
                    generatePermutations(memo, taken, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    taken[i] = false;
                }
            }
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
