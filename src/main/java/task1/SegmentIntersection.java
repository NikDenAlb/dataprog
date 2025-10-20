package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class SegmentIntersection {


    int findMinPoints(int n, int[][] vls) {

        Arrays.sort(vls, Comparator.comparingInt(a -> a[1]));

        int cnt = 0;
        for (int i = 0; i < n; ) {
            int end = vls[i][1];
            cnt++;
            while (i < n && vls[i][0] <= end) {
                i++;
            }
        }

        return cnt;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output"));

        int n = Integer.parseInt(reader.readLine().trim());
        int[][] vls = new int[n][];
        for (int i = 0; i < n; i++) {
            vls[i] = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        writer.write(String.valueOf(new SegmentIntersection().findMinPoints(n, vls)));

        reader.close();
        writer.close();
    }
}
