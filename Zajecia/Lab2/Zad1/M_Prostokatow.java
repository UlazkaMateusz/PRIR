
import java.util.function.Function;

class M_Prostokatow implements CalkowanieNumeryczne
{
    public static double oblicz(double poczatek, double koniec, int n, Function<Double, Double> f)
    {
        double dx = (koniec - poczatek) / n;
        FunkcjaWatek[] tab = new FunkcjaWatek[n];
        for (int i=0; i<n; i++)
        {
            tab[i] = new FunkcjaWatek(dx*(i+1), f);
            tab[i].start();
        }
        double wynik = 0;
        for (int i=0; i<n; i++)
        {
            try
            {
                tab[i].join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            wynik = wynik + tab[i].getWynik();
        }
        wynik = wynik * dx;
        return wynik;
    }
}