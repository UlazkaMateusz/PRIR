
import java.util.function.Function;

class M_Trapezow implements CalkowanieNumeryczne
{
    public static double oblicz(double poczatek, double koniec, int n, Function<Double, Double> f) {
        double dx = (koniec - poczatek) / n;

        FunkcjaWatek[] tab = new FunkcjaWatek[n + 1];
        for (int i = 0; i < tab.length; i++) {
            double xi = poczatek + i * dx;
            tab[i] = new FunkcjaWatek(xi, f);
            tab[i].start();
        }

        double wynik = 0;
        for (int i = 0; i < tab.length; i++) {try {
                tab[i].join();
                if (i == 0 || i == tab.length-1)
                    wynik += tab[i].getWynik() / 2;
                else
                    wynik += tab[i].getWynik();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

        wynik *= dx;
        return wynik;
    }
}
