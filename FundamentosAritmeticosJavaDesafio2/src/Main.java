import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        String linha;
        int n;

        n = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        linha = br.readLine();
        n = Integer.parseInt(linha);

        for (int i = 0; i < n-1;){
            System.out.println(i+2);
            i += 2;
        }

    }

}
