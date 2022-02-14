//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.Comparator;
//
//
//public class Desafio4{
//
//static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//static PrintWriter out = new PrintWriter(System.out);
//
//public static void main(String[] args) throws IOException {
//        String owner, l, color, size;
//        String[] details;
//        Tshirt[] tshirts;
//        Tshirt tshirt;
//        int N;
//        boolean firstCase = true;
//        while (!(l = read()).equals("0")) {
//
//        } else {
//        out.println();
//        }        N = toInt(l);
//        tshirts = new Tshirt[N];
//        for (int i = 0; i < N; i++) {
//
//        }
//        Arrays.sort(tshirts, new Comparator<Tshirt>() {
//@Override
//public int compare(Tshirt t1, Tshirt t2) {
//        String color1 = t1.getColor();
//        String color2 = t2.getColor();
//        int diff = color1.compareTo(color2);
//        if (diff != 0) {
//        return diff;
//        } else {
//
//        }
//        if (                           ) {
//        return -1;
//        }
//        return 1;
//        }
//        }
//        });
//        for (                                  ) {
//
//        }
//
//        }
//        out.close();
//        }
//
//private static String read() throws IOException {
//        return in.readLine();
//        }
//
//private static int toInt(String s) {
//        return Integer.parseInt(s);
//        }
//        }
//
//class Tshirt {
//
//    private String size;
//    private String color;
//    private String owner;
//
//    public Tshirt(String size, String color, String owner) {
//        this.size = size;
//        this.color = color;
//        this.owner = owner;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getOwner() {
//        return owner;
//    }
//
//    public void setOwner(String owner) {
//        this.owner = owner;
//    }
//
//    @Override
//    public String toString() {
//        return this.getColor() + " " + this.getSize() + " " + this.getOwner();
//    }
//}