package example;

public class FormatowanieStringa {

    public static void main(String[] args) {
        String s = "coś";
        int i = 5;

//JAVA String format examples

        System.out.println(String.format("ala ma kota %s", s));

        System.out.println(String.format("ala ma kota %d", i));

        System.out.println(String.format("ala ma kota %s %d %s", s, i, s));

        System.out.println(String.format("cena wynosi %.2f", 2.15));

    }
}
