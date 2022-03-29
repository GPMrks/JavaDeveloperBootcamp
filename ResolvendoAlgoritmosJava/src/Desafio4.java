import java.util.Scanner;

public class Desafio4 {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        String input = scr.nextLine();
        int N = Integer.parseInt(input);

        for (int i = 0; i < N; i++) {

            int L = scr.nextInt();
            int result = 0;

            for (int j = 0; j < L; j++) {

                String lines = scr.next();

                char[] array = lines.toCharArray();

                for (int z = 0; z < array.length; z++) {

                    int alPos = (int) array[z] - 65;
                    result += alPos + j + z;
                }
            }

            System.out.println(result);

        }
    }
}