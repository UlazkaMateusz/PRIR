
import java.util.function.Function;

class M_Simpsona implements CalkowanieNumeryczne
{
    public static double oblicz(double poczatek, double koniec, int n, Function<Double, Double> f) {
        double dx = (koniec - poczatek) / n;

        FunkcjaWatek f0 = new FunkcjaWatek(poczatek, f);
        FunkcjaWatek fn = new FunkcjaWatek(koniec, f);

        f0.start();
        fn.start();

        FunkcjaWatek[] fi = new FunkcjaWatek[n-1];
        for(int i=1; i<=n-1; i++)
        {
            double xi = poczatek + i*dx;
            fi[i-1] = new FunkcjaWatek(xi, f);
            fi[i-1].start();
        }

        FunkcjaWatek[] fti = new FunkcjaWatek[n];
        for(int i=1; i<=n; i++)
        {
            double ti = (poczatek + (i-1)*dx + poczatek + (i+1)*dx) / 2;
            fti[i-1] = new FunkcjaWatek(ti, f);
            fti[i-1].start();
        }


        double wynik = 0;
        try 
        {
            f0.join();
            wynik += f0.getWynik();
            fn.join();
            wynik += fn.getWynik();
        

            for(int i=0; i<fi.length; i++)
            {
                wynik += 2 * fi[i].getWynik();
            }

            for(int i=0; i<fti.length; i++)
            {
                wynik += 4 * fti[i].getWynik();
            }

        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        wynik *= dx/6;
        return wynik;
    }
}
