package task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class TriangleFall {


    int findLightestFall(int n, int[][] triangle) {
        if (n == 1) return triangle[0][0];

        int[][] dp = new int[n][];

        dp[0] = new int[]{triangle[0][0]};

        for (int i = 1; i < n; i++) {
            dp[i] = new int[i + 1];
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output"));

        int n = Integer.parseInt(reader.readLine());
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        writer.write(String.valueOf(new TriangleFall().findLightestFall(n, triangle)));

        reader.close();
        writer.close();
    }
}
