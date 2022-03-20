import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Desafio6 {

    public static void main(String[] args) throws IOException {

        Scanner scr = new Scanner(System.in);
        BigDecimal currentNum;
        BigDecimal result = new BigDecimal(1.0);
        String operator;
        String[] lineArgs;
        int entries;

        entries = Integer.parseInt(scr.nextLine());

        for (int i = 0; i < entries; i++) {
            lineArgs = scr.nextLine().trim().split(" ");

            currentNum = BigDecimal.valueOf(Integer.parseInt(lineArgs[0]));
            operator = lineArgs[1];

            if (operator.equals("*")) {
                result = result.multiply(currentNum);
            } else if (operator.equals("/")) {
                result = result.divide(currentNum, MathContext.DECIMAL128);
            } else if (operator.equals("+")){
                result = result.add(currentNum);
            } else if (operator.equals("-")){
                result = result.subtract(currentNum);
            }

        }

        System.out.println(result.setScale(0, RoundingMode.DOWN));
        scr.close();

    }


}
