import java.util.function.Function;

public class Zad1 {
    public static void main(String[] args)
    {
        double poczatek = 0;
        double koniec = Math.PI;
        int n = 1000;
        Function<Double, Double> f = (Double x) -> {return Math.sin(x);};

        double wynik = M_Prostokatow.oblicz(poczatek, koniec, n, f);
        System.out.println("Wynik za pomocą metody prostokątów: " + wynik);

        wynik = M_Trapezow.oblicz(poczatek, koniec, n, f);
        System.out.println("Wynik za pomocą metody trapezow: " + wynik);        

        wynik = M_Simpsona.oblicz(poczatek, koniec, n, f);
        System.out.println("Wynik za pomocą metody simpsona: " + wynik);  
    }
}
