package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Recursion {


    BigInteger get(int index) {

        List<BigInteger> dp = new ArrayList<>();
        dp.add(BigInteger.ONE);
        dp.add(BigInteger.valueOf(3));
        index -= 2;
        for (int dpInd = 2; index >= 0; dpInd++) {
            dp.add(dp.get(dpInd - 1).multiply(BigInteger.valueOf(5)).add(dp.get(dpInd - 2)));
            if (dp.getLast().mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                index--;
            }
        }

        return dp.getLast();
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output"));

        writer.write(new Recursion().get(39).toString());

        //writer.newLine();
        //writer.write((new Recursion()).getByTrueRecursion(39).toString());

        writer.close();
    }


    BigInteger getByTrueRecursion(int index) {

        return cleanRecursion(index - 1, BigInteger.ONE, BigInteger.valueOf(3));

    }

    BigInteger cleanRecursion(int cnt, BigInteger prev2, BigInteger prev1) {
        BigInteger result = prev1.multiply(BigInteger.valueOf(5)).add(prev2);
        if (result.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
            cnt--;
        }
        if (cnt == 0) {
            return result;
        }
        return cleanRecursion(cnt, prev1, result);
    }

}
