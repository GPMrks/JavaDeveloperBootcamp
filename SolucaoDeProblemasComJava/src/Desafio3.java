import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<Attendant> attendants = new ArrayList<>();

        while (!line.equals("FIM")) {

            var attendant = new Attendant();
            var entry = line.split(" ");

            attendant.setName(entry[0]);
            attendant.setFriend(entry[1].equals("SIM"));
            attendant.setSubsOrder(attendants.size());

            var existAttendant = attendants.stream()
                    .filter(a -> a.getName().equals(attendant.getName()))
                    .findFirst()
                    .orElse(null);

            if (existAttendant == null) {
                attendants.add(attendant);
            }

            line = br.readLine();

        }

        var orderedAtt = attendants.stream().sorted(Comparator
                        .comparing(Attendant::isFriend).reversed()
                        .thenComparing(Attendant::getName))
                .collect(Collectors.toList());

        orderedAtt.forEach(a -> System.out.println(a.getName()));

        List<Attendant> friends = orderedAtt.stream()
                .filter(Attendant::isFriend)
                .collect(Collectors.toList());

        Attendant chosen = null;

        for (Attendant a : friends) {
            if (chosen == null) {
                chosen = a;
            } else if (chosen.getName().length() < a.getName().length()) {
                chosen = a;
            } else if (chosen.getName().length() == a.getName().length()
                    && chosen.getSubsOrder() > a.getSubsOrder()) {
                chosen = a;
            }
        }

        System.out.println("");
        System.out.println("Amigo do Pablo:");
        System.out.println(chosen.getName());


    }

    public static class Attendant {

        private String name;
        private boolean friend;
        private int subsOrder;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isFriend() {
            return friend;
        }

        public void setFriend(boolean friend) {
            this.friend = friend;
        }

        public int getSubsOrder() {
            return subsOrder;
        }

        public void setSubsOrder(int subsOrder) {
            this.subsOrder = subsOrder;
        }

        @Override
        public String toString() {
            return name;
        }

    }

}
