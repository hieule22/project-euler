import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Arrays;
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
public class P49 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem49 solver = new Problem49();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem49 {
        private static final int UPPER_BOUND = 10000;
        private boolean[] isPrime;

        public Problem49() {
            isPrime = new boolean[UPPER_BOUND];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i < UPPER_BOUND; ++i) {
                if (isPrime[i]) {
                    for (int j = i + i; j < UPPER_BOUND; j += i)
                        isPrime[j] = false;
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            List<Integer> candidates = new ArrayList<>();
            for (int i = 1000; i < UPPER_BOUND; ++i) {
                if (isPrime[i])
                    candidates.add(i);
            }

            for (int i = 0; i < candidates.size(); ++i) {
                int first = candidates.get(i);
                for (int j = i + 1; j < candidates.size(); ++j) {
                    int second = candidates.get(j);
                    if (!arePermutations(first, second))
                        continue;
                    int third = second + (second - first);
                    if (arePermutations(first, third) && isPrime[third]) {
                        out.printf("%d%d%d\n", first, second, third);
                    }
                }
            }
        }

        private boolean arePermutations(int a, int b) {
            char[] repA = Integer.toString(a).toCharArray();
            char[] repB = Integer.toString(b).toCharArray();
            if (repA.length != repB.length) return false;
            Arrays.sort(repA);
            Arrays.sort(repB);
            for (int i = 0; i < repA.length; ++i) {
                if (repA[i] != repB[i])
                    return false;
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
