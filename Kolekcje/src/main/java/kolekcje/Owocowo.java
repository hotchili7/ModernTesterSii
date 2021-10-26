package kolekcje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Owocowo {
    public static void main(String[] args) {
        List<Owoc> owoce = new ArrayList<>();

        Owoc jablko = new Owoc("jabłko", "czerwone", 2.50);
        Owoc wisnia = new Owoc("wisnia", "czerwone", 7.99);
        Owoc gruszka = new Owoc("gruszka", "żółta", 5.25);
        Owoc sliwka = new Owoc("sliwka", "fioletowa", 2.90);
        Owoc truskawka = new Owoc("truskawka", "czerwona", 9.99);
        Owoc banan = new Owoc("banan", "żółty", 8.69);
        Owoc jagoda = new Owoc("jagoda", "granatowa", 35.00);
        Owoc żonkil = new Owoc("żonkil", "purpurowy", 5.88);

        owoce.add(jablko);
        owoce.add(wisnia);
        owoce.add(gruszka);
        owoce.add(sliwka);
        owoce.add(truskawka);
        owoce.add(banan);
        owoce.add(jagoda);
        owoce.add(żonkil);


        System.out.println(owoce);

        for (Owoc owoc : owoce) {
            System.out.print(", " + owoc.getName());

        }


        List<Owoc> drozszeNiz5Owocs= new ArrayList<>();
        for (Owoc owoc : owoce) {
           if (owoc.getPrize() > 5 ) {
               drozszeNiz5Owocs.add(owoc);
           }

        }
        System.out.println();
        System.out.println(drozszeNiz5Owocs);


//jeśli cena = 2.5 zmienić na 4.5
        for (Owoc owoc : owoce) {
            if (owoc.getPrize()==2.5) {
                owoc.setPrize(4.5);

            }

        }

        System.out.println(owoce);
        System.out.println();
        System.out.println("Sortowanie po cenie:  ");

//        posortować po cenie

        owoce.sort(new Comparator<Owoc>() {
            @Override
            public int compare(Owoc o1, Owoc o2) {
                return Double.compare(o1.getPrize(), o2.getPrize());
            }
        });

        System.out.print(owoce);

        for (Owoc owoc : owoce) {
            System.out.println(owoc);
        }

//        po kolorze i po nazwie - dopisać !!
//         sortowanie po nazwie alfabetycznie
        owoce.sort(new Comparator<Owoc>() {
            @Override
            public int compare(Owoc o1, Owoc o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println();
        System.out.println("Sortowanie po nazwie");
        for (Owoc owoc : owoce) {
            System.out.println(owoc);
        }

        System.out.println();
        System.out.println("Sortowanie po nazwie alfabetycznie od tyłu");

        owoce.sort(new Comparator<Owoc>() {
            @Override
            public int compare(Owoc o1, Owoc o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });

        for (Owoc owoc : owoce) {
            System.out.println(owoc);
        }

        System.out.println();
        System.out.println("Sortowanie po kolorze");

        owoce.sort(new Comparator<Owoc>() {
            @Override
            public int compare(Owoc o1, Owoc o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        for (Owoc owoc : owoce) {
            System.out.println(owoc);
        }

//        zamiana pierwszej literki na inną

        for (Owoc owoc : owoce) {
            if (owoc.getName().startsWith("ż")) {
                owoc.setName("BB");
            }
        }

        System.out.println();
        for (Owoc owoc : owoce) {
            System.out.println(owoc);
        }









    }
}
