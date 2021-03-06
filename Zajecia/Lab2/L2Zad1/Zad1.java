import java.util.function.Function;

public class L2Zad1 {
    public static void main(String[] args)
    {
        double poczatek = 0;
        double koniec = 1000*Math.PI;
        int n = 100;
        Function<Double, Double> f = (Double x) -> {return Math.pow(x, 2) * Math.sin(-5*x) + 2;};

        double wynik = MetodaProstokatow.oblicz(poczatek, koniec, n, f);
        System.out.println("Wynik za pomocą metody prostokątów: " + wynik);

        wynik = MetodaProstokatow.oblicz(poczatek, koniec, n, f);
        System.out.println("Wynik za pomocą metody trapezow: " + wynik);        

        wynik = MetodaSimpsona.oblicz(poczatek, koniec, n, f);
        System.out.println("Wynik za pomocą metody simpsona: " + wynik);  
    }
}
