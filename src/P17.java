import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
 */
public class P17 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem17 solver = new Problem17();
        solver.solve(1, in, out);
        out.close();
    }

    static class Problem17 {
        private static final String[] tensNames = {
                "",
                " ten",
                " twenty",
                " thirty",
                " forty",
                " fifty",
                " sixty",
                " seventy",
                " eighty",
                " ninety"
        };
        private static final String[] numNames = {
                "",
                " one",
                " two",
                " three",
                " four",
                " five",
                " six",
                " seven",
                " eight",
                " nine",
                " ten",
                " eleven",
                " twelve",
                " thirteen",
                " fourteen",
                " fifteen",
                " sixteen",
                " seventeen",
                " eighteen",
                " nineteen"
        };

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int result = 0;
            for (int i = 1; i <= 1000; ++i) {
                String rep = convert(i);
                for (char c : rep.toCharArray()) {
                    if (Character.isAlphabetic(c))
                        ++result;
                }
                if (i > 99 && i % 100 > 0) {
                    result += 3;
                }
            }
            out.println(result);
        }

        private static String convertLessThanOneThousand(int number) {
            String soFar;

            if (number % 100 < 20) {
                soFar = numNames[number % 100];
                number /= 100;
            } else {
                soFar = numNames[number % 10];
                number /= 10;

                soFar = tensNames[number % 10] + soFar;
                number /= 10;
            }
            if (number == 0) return soFar;
            return numNames[number] + " hundred" + soFar;
        }

        public static String convert(long number) {
            // 0 to 999 999 999 999
            if (number == 0) {
                return "zero";
            }

            String snumber = Long.toString(number);

            // pad with "0"
            String mask = "000000000000";
            DecimalFormat df = new DecimalFormat(mask);
            snumber = df.format(number);

            // XXXnnnnnnnnn
            int billions = Integer.parseInt(snumber.substring(0, 3));
            // nnnXXXnnnnnn
            int millions = Integer.parseInt(snumber.substring(3, 6));
            // nnnnnnXXXnnn
            int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
            // nnnnnnnnnXXX
            int thousands = Integer.parseInt(snumber.substring(9, 12));

            String tradBillions;
            switch (billions) {
                case 0:
                    tradBillions = "";
                    break;
                case 1:
                    tradBillions = convertLessThanOneThousand(billions)
                            + " billion ";
                    break;
                default:
                    tradBillions = convertLessThanOneThousand(billions)
                            + " billion ";
            }
            String result = tradBillions;

            String tradMillions;
            switch (millions) {
                case 0:
                    tradMillions = "";
                    break;
                case 1:
                    tradMillions = convertLessThanOneThousand(millions)
                            + " million ";
                    break;
                default:
                    tradMillions = convertLessThanOneThousand(millions)
                            + " million ";
            }
            result = result + tradMillions;

            String tradHundredThousands;
            switch (hundredThousands) {
                case 0:
                    tradHundredThousands = "";
                    break;
                case 1:
                    tradHundredThousands = "one thousand ";
                    break;
                default:
                    tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                            + " thousand ";
            }
            result = result + tradHundredThousands;

            String tradThousand;
            tradThousand = convertLessThanOneThousand(thousands);
            result = result + tradThousand;

            // remove extra spaces!
            return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
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
