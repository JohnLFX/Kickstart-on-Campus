import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class GBus {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {

            // The first line contains one integer N: the number of GBuses.
            // Not really necessary to know for java, so skip it
            br.readLine();

            // The second line contains 2N integers representing the ranges of cities that the buses serve,
            // in the form A_1 B_1 A_2 B_2 A_3 B_3 ... A_N B_N.
            // That is, the first GBus serves the cities numbered from A1 to B1 (inclusive), and so on.
            int[] ranges = Arrays.stream(br.readLine().split(Pattern.quote(" "))).mapToInt(Integer::parseInt).toArray();

            // The third line contains one integer P: the number of cities we are interested in, as described above.
            // (Note that this is not necessarily the same as the total number of cities in the problem, which is not given.)
            // Because each case is separated from the next by a blank line,
            // it is not required to know the amount in java
            br.readLine();

            // Finally, there are P more lines; the i-th of these contains the number Ci of a city we are interested in.

            System.out.print("Case #" + testCase + ":");

            String line;

            while (!(line = br.readLine()).isEmpty()) {

                int cityID = Integer.parseInt(line);
                int supportedBuses = 0;

                for (int i = 0; i < ranges.length; i += 2) {

                    if (cityID >= ranges[i] && cityID <= ranges[i + 1]) {

                        supportedBuses++;

                    }

                }

                System.out.print(" " + supportedBuses);

            }

            System.out.println();

        }

        br.close();

    }

}
