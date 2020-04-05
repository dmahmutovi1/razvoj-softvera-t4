package ba.unsa.etf.rs.tut4;

import java.util.HashMap;

public class Racun {
    private HashMap<Artikal, Integer>  stavke = new HashMap<Artikal, Integer>();
    private double suma = 0;

    public void dodajStavku(Artikal artikal, int kolicina) {
        stavke.put(artikal, kolicina);
    }

    public double ukupanIznos(){

        stavke.forEach((Artikal artikal,Integer kolicina) -> UvecajSumu(artikal.getCijena() * kolicina));

        return suma;
    }

    private void UvecajSumu(double v) {
        suma += v;
    }


}