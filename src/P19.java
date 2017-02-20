import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class P19 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem19 solver = new Problem19();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem19 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            GregorianCalendar current = new GregorianCalendar(1901, Calendar.JANUARY, 1);
            GregorianCalendar end = new GregorianCalendar(2001, Calendar.JANUARY, 1);
            int result = 0;
            while (!current.equals(end)) {
                if (current.get(Calendar.DAY_OF_MONTH) == 1
                        && current.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    ++result;
                }
                current.add(Calendar.DATE, 1);
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
