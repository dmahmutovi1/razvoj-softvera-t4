package ba.unsa.etf.rs.tut4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArtikalTest {

    @Test
    void getSifra() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertEquals("ABC", a.getSifra());
    }

    @Test
    void setSifra() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        a.setSifra("DEF");
        assertEquals("DEF", a.getSifra());
    }

    @Test
    void getNaziv() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertEquals("Proizvod", a.getNaziv());
    }

    @Test
    void setNaziv() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        a.setNaziv("Usluga");
        assertEquals("Usluga", a.getNaziv());
    }

    @Test
    void getCijena() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertEquals(100, a.getCijena());
    }

    @Test
    void setCijena() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        a.setCijena(2020.2);
        assertEquals(2020.2, a.getCijena());
    }

    @Test
    void ctorCijenaIzuzetak() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikal("ABC", "Proizvod", -5);
        }, "Cijena je negativna");
    }

    @Test
    void setCijenaIzuzetak() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setCijena(-1);
        }, "Cijena je negativna");
    }

    @Test
    void ctorSifraIzuzetak() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikal("", "Proizvod", -5);
        }, "Šifra je prazna");
    }

    @Test
    void setSifraIzuzetak() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setSifra("");
        }, "Šifra je prazna");
    }


    @Test
    void ctorNazivIzuzetak() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikal("ABC", "", -5);
        }, "Naziv je prazan");
    }

    @Test
    void setNazivIzuzetak() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setNaziv("");
        }, "Naziv je prazan");
    }

    @Test
    void testEquals() {
        Artikal a1 = new Artikal("ABC", "Proizvod", 100);
        Artikal a2 = new Artikal("ABC", "Proizvod", 100);
        assertTrue(a1.equals(a2));
        assertTrue(a2.equals(a1));
    }

    @Test
    void testNotEquals() {
        Artikal a1 = new Artikal("ABC", "Proizvod", 100);
        Artikal a2 = new Artikal("ABC", "Proizvod", 100);
        a2.setSifra("DEF");
        assertFalse(a1.equals(a2));
        assertFalse(a2.equals(a1));
        a2.setSifra("ABC");
        a2.setNaziv("Usluga");
        assertFalse(a1.equals(a2));
        assertFalse(a2.equals(a1));
        a2.setNaziv("Proizvod");
        a2.setCijena(100.1);
        assertFalse(a1.equals(a2));
        assertFalse(a2.equals(a1));
        a2.setCijena(100);
        assertTrue(a1.equals(a2));
        assertTrue(a2.equals(a1));
    }

    @Test
    void izbaciDuplikate() {
        ArrayList<Artikal> lista = new ArrayList<>();
        lista.add(new Artikal("ABC", "Proizvod", 100));
        lista.add(new Artikal("DEF", "Usluga", 200));
        lista.add(new Artikal("ABC", "Proizvod", 100));
        lista.add(new Artikal("ABC", "Proizvod", 100));
        lista.add(new Artikal("DEF", "Usluga", 200.2));
        lista.add(new Artikal("DEF", "Usluga", 200));
        Artikal.izbaciDuplikate(lista);
        assertEquals(3, lista.size());

        // Pošto nećemo da pravimo nikakve pretpostavke o redoslijedu nakon izbacivanja,
        // sada tražimo da li se u listi nalaze artikli
        assertTrue(lista.contains(new Artikal("ABC", "Proizvod", 100)));
        assertTrue(lista.contains(new Artikal("DEF", "Usluga", 200)));
        assertFalse(lista.contains(new Artikal("ABC", "Usluga", 100)));
        assertFalse(lista.contains(new Artikal("DEF", "Usluga", 100)));
    }

    @Test
    void ctorArtikalTest() {
        var artikal = new Artikal("12345,Smoki,1.45");

        assertEquals(artikal.getCijena(), 1.45);
        assertEquals(artikal.getNaziv(), "Smoki");
        assertEquals(artikal.getSifra(), "12345");
    }

    @Test
    void sifraTestBacaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class , () -> new Artikal("", "Smoki", 1.45), "Šifra je prazna");
    }

    @Test
    void testMetodeToString() {
    var artikal = new Artikal("sifraa,nesto,200.0");
    assertEquals(artikal.toString(), "sifraa,nesto,200.0");
    }
}
