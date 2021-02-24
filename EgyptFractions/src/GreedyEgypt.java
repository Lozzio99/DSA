import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GreedyEgypt
{
    private static List<Fraction> numeratorOne = new ArrayList<>();
    private static final AtomicBoolean recursion = new AtomicBoolean(false);
/*
    static List<Fraction> getEgyptFrac(Fraction fraction)
    {
        if (!recursion.get())
            reset();
        if (fraction.numerator==0 && fraction.denominator == 0)
        {
            recursion.set(false);
            return numeratorOne;
        }
        if (fraction.denominator/fraction.numerator== fraction.denominator/(double)fraction.numerator)
        {
            numeratorOne.add(new Fraction(1, fraction.denominator/ fraction.numerator));
            recursion.set(false);
            return numeratorOne;
        }
        if (fraction.numerator/fraction.denominator == fraction.numerator/(double)fraction.denominator)
        {
            numeratorOne.add(new Fraction(fraction.numerator, fraction.denominator));
            recursion.set(false);
            return numeratorOne;
        }
        Fraction f = new Fraction(1,fraction.denominator/ fraction.numerator+1);
        numeratorOne.add(f);
        recursion.set(true);
        getEgyptFrac(new Fraction(fraction.numerator*f.denominator- fraction.denominator, fraction.denominator* f.denominator));
        return numeratorOne;
    }

 */
    static List<Fraction> getEgyptFrac(Fraction fraction)
    {
        if (!recursion.get())
            reset();


        int i = 2;
        while (1/i > fraction.numerator/ fraction.denominator)
        {i++;}

        numeratorOne.add(new Fraction(1,i));

        int lcm = lcm(fraction.denominator, i),
        a2 = fraction.numerator * lcm / fraction.denominator,
        itop = lcm / i,
        remainder = a2 - itop,
        gcd = gcd(remainder,lcm),
        r2 = remainder/gcd,
        lcm2 = lcm/gcd;

        if (r2 == 1) {
            numeratorOne.add(new Fraction(r2,lcm2));
        } else {
            recursion.set(true);
            return getEgyptFrac(new Fraction(r2,lcm2));
        }
        recursion.set(false);
        return numeratorOne;
    }

    static int gcd (int a, int b)
    {
        if(a!= 0)
            return gcd(b%a,a);
        return b;
    }
    static int lcm(int a , int b)
    {
        if (a ==0 && b ==0)
            return 0;
        return a/gcd(a,b)*b;
    }
    static void reset(){
        numeratorOne = new ArrayList<>();
    }
}
