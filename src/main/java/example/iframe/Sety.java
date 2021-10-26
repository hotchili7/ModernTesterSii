package example.iframe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sety {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 3;

        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        System.out.println(list);

//        zbiór unikalnmych wartości
//        nie mają indeksów, nie można wyciągnąć elementu po indexie

        Set<Integer> zbiór = new HashSet<>();
        zbiór.add(a);
        zbiór.add(b);
        zbiór.add(c);
        zbiór.add(d);

        System.out.println(zbiór);

        String aa = "fdsf";
        String bb = "dsada";
        String cc = "ddsda";





    }
}
