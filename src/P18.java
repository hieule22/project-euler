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
public class P18 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem18 solver = new Problem18();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem18 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String input = "75\n" +
                    "95 64\n" +
                    "17 47 82\n" +
                    "18 35 87 10\n" +
                    "20 04 82 47 65\n" +
                    "19 01 23 75 03 34\n" +
                    "88 02 77 73 07 63 67\n" +
                    "99 65 04 28 06 16 70 92\n" +
                    "41 41 26 56 83 40 80 70 33\n" +
                    "41 48 72 33 47 32 37 16 94 29\n" +
                    "53 71 44 65 25 43 91 52 97 51 14\n" +
                    "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                    "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                    "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                    "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
            String[] tokens = input.split("\\s|\n");
            int nRows = 15;
            int[][] grid = new int[nRows][nRows];
            int index = 0;
            for (int i = 0; i < nRows; ++i) {
                for (int j = 0; j <= i; ++j) {
                    grid[i][j] = Integer.parseInt(tokens[index]);
                    ++index;
                }
            }

            for (int row = nRows - 2; row >= 0; --row) {
                for (int col = 0; col <= row; ++col) {
                    grid[row][col] = Math.max(grid[row][col] + grid[row + 1][col],
                            grid[row][col] + grid[row + 1][col + 1]);
                }
            }
            out.println(grid[0][0]);
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
