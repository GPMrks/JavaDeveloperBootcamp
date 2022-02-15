import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Desafio3 {


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()); // Lê a linha de entrada

        int l = Integer.parseInt(st.nextToken());
        List<Tshirt> tshirts = new ArrayList<>();

        for (int i = 0; i <= l; i++){
            var n = in.readLine();
            if(n.equals("0")){
                break;
            }

            Tshirt tshirt = new Tshirt();
            tshirt.setOwner(n);

            var info = in.readLine().split(" ");
            tshirt.setColor(info[0]);
            tshirt.setSize(info[1]);
            tshirts.add(tshirt);
        }

        Comparator<Tshirt> comparator = Comparator
                .comparing(Tshirt::getColor).reversed()
                .thenComparing(Tshirt::getSize).reversed()
                .thenComparing(Tshirt::getOwner);

        tshirts.stream().sorted(comparator).forEach(System.out::println);


}

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}

class Tshirt {

    private String size;
    private String color;
    private String owner;

    public Tshirt(String size, String color, String owner) {
        this.size = size;
        this.color = color;
        this.owner = owner;
    }

    public Tshirt() {

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.getSize() + " " + this.getOwner();
    }
}