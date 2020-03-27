package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

/*
        privatne atribute: šifra (String), naziv (String) i cijena (double);
        klasa treba da poštuje JavaBean specifikaciju u smislu postojanja setter/getter metoda i konstruktora;
        pored ovih metoda, klasa Artikal treba da posjeduje i sljedeće metode:
        konstruktor koji prima jedan argument tipa String oblika "šifra,naziv,cijena" (string u kojem su šifra, naziv i cijena artikla razdvojeni zarezom);
        metodu toString koja vraća string istog oblika kao onaj kojeg prima upravo opisani konstruktor - podsjetimo se sa predavanja da je ovo ustvari
        metoda klase Object koju "preklapamo" u našoj klasi Artikal;
        javnu statičku metodu izbaciDuplikate koja prima ArrayList artikala, te iz ove liste izbacuje sve duplikate i tako prečišćenu listu vraća;
        pod pojmom "duplikata" smatraju se dva artikla koji posjeduju istu šifru, naziv i cijenu;
        konstruktori i setter metode trebaju bacati izuzetak tipa IllegalArgumentException ako je cijena 0 ili negativna,
        te ako su šifra ili naziv prazni stringovi; tekst izuzetka treba biti "Šifra je prazna", "Naziv je prazan", "Cijena je negativna";
                */
public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;

    public Artikal(String sifra, String naziv, double cijena) {
        setSifra(sifra);
        setNaziv(naziv);
        setCijena(cijena);
    }
    // "sifra,naziv,cijena"
    public Artikal(String sifraNazivCijena){
        var nizParametera = sifraNazivCijena.split(","); // niz parametara ["sifra","naziv","cijena"]
        this.sifra = nizParametera[0];
        this.naziv = nizParametera[1];
        this.cijena = Double.parseDouble(nizParametera[2]);
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra != null && sifra.isEmpty()){
            throw new IllegalArgumentException("Šifra je prazna");
        }

        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv != null && naziv.isEmpty()){
            throw new IllegalArgumentException("Naziv je prazan");
        }
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena == 0 || cijena < 0 ){
            throw new IllegalArgumentException("Sifra je negativna");
        }
        this.cijena = cijena;
    }

    public String toString(){
        return sifra + "," + naziv + "," + cijena; // vraca "sifra,naziv,cijena"
    }

    @Override
    public boolean equals(Object obj) {
        var artikal = (Artikal)obj;
        return this.cijena == artikal.cijena && this.naziv.equals(artikal.naziv) && this.sifra.equals(artikal.sifra);
    }

    public static void izbaciDuplikate(ArrayList<Artikal> listaArtikala){
        var preciscenaLista = new ArrayList<Artikal>();

        // ubacicemo samo unikatne artike u preciscenu listu
        for (Artikal artikal:listaArtikala) {
            if(!preciscenaLista.contains(artikal)){
                preciscenaLista.add(artikal);
            }
        }

        // isprazni ulaznu listu
        listaArtikala.clear();

        // dodaj u nju samo unikatne artikle
        listaArtikala.addAll(preciscenaLista);
    }
}
