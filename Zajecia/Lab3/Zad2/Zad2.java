package Zad2;

import java.util.Random;

public class Zad2 {
    public static void main(String[] args) {
        DiabelskiMlyn mlyn = new DiabelskiMlyn(5, 125);
        
        Random random = new Random();    
        for(int i=0; i<10; i++){
            Mlynowicz mlynowicz = new Mlynowicz(i, random.nextInt(500), mlyn);
            mlynowicz.start();
        }
    }
}
