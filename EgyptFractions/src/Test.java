public class Test {
    public static void main(String[] args) {
        Fraction thfo = new Fraction(2,3);
        Fraction thfi = new Fraction(6,14);
        Fraction thsi = new Fraction(12,13);
        Fraction thni = new Fraction(3,9);

        System.out.println(thfo);
        System.out.println(GreedyEgypt.getEgyptFrac(thfo));
        System.out.println(thfi);
        System.out.println(GreedyEgypt.getEgyptFrac(thfi));
        System.out.println(thsi);
        System.out.println(GreedyEgypt.getEgyptFrac(thsi));
        System.out.println(thni);
        System.out.println(GreedyEgypt.getEgyptFrac(thni));

    }
}
