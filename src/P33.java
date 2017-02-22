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
public class P33 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem33 solver = new Problem33();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem33 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Fraction sum = new Fraction(1, 1);
            for (int n = 10; n < 100; ++n) {
                for (int m = n + 1; m < 100; ++m) {
                    if (check(n, m)) {
                        sum = sum.multiply(new Fraction(n, m));
                    }
                }
            }

            out.println(sum.denominator);
        }

        private boolean check(int n, int m) {
            String repN = Integer.toString(n);
            String repM = Integer.toString(m);
            int commonDigit = -1;
            for (char cn : repN.toCharArray()) {
                for (char cm : repM.toCharArray()) {
                    if (cn == cm)
                        commonDigit = Character.getNumericValue(cn);
                }
            }

            if (commonDigit < 1)
                return false;
            int p = n, q = m;

            if (repN.indexOf(Integer.toString(commonDigit)) == 0)
                p -= 10 * commonDigit;
            else
                p /= 10;

            if (repM.indexOf(Integer.toString(commonDigit)) == 0)
                q -= 10 * commonDigit;
            else
                q /= 10;

            return n * q == m * p;
        }

        private final class Fraction {
            private int numerator;
            private int denominator;

            private Fraction(int p, int q) {
                if (q == 0) {
                    throw new IllegalArgumentException();
                }
                int gcd = gcd(p, q);
                this.numerator = p / gcd;
                this.denominator = q / gcd;
            }

            private Fraction multiply(Fraction other) {
                int p = this.numerator * other.numerator;
                int q = this.denominator * other.denominator;
                return new Fraction(p, q);
            }

            private int gcd(int a, int b) {
                if (b == 0)
                    return a;
                return gcd(b, a % b);
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
