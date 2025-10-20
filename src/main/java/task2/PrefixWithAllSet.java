package task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * There appears to be an error in the input data or the answer.
 * Output is 150, so I pick the closest to my answer variant - 49 (lost first 1 and wrong indexation)
 */
class PrefixWithAllSet {


    int findMinPref(int n, int k, int[] arr) {

        int[] cnt = new int[k + 1];
        int set = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 1 && arr[i] <= k) {
                if (cnt[arr[i]]++ == 0) set++;
            }
            if (set == k) {
                return i + 1;
            }
        }

        return -1;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output"));

        int[] nk = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int ans = new PrefixWithAllSet().findMinPref(nk[0], nk[1], arr);

        writer.write(ans == -1 ? "NONE" : String.valueOf(ans));

        reader.close();
        writer.close();
    }
}
