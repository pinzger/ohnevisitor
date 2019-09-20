package ausstattung.hardware;

import ausstattung.Arbeitsplatz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BesucherKomponenteTest {
    private Arbeitsplatz ausstattung;


    @BeforeEach
    public void initAusstattung() {
        ausstattung = new Arbeitsplatz();
        ausstattung.add(new Rechner("MacBook Pro", "Laptop", 3000d));
        ausstattung.add(new Monitor("LG 27UD88-W", "Monitor", 488d));
        ausstattung.add(new Maus("Logitech Performance MX", "Maus", 89d));
        ausstattung.add(new Tastatur("Apple Magic Keyboard", "Tastatur", 120d));
    }

    @Test
    public void berechneGesamtpreis() {
        double gesamtPreis = 0d;
        for (Komponente komponente : ausstattung.getKomponenten()) {
            gesamtPreis += komponente.berechnePreis();
        }

        assertEquals(3000d * 0.9d + 488d + 89d + 120d, gesamtPreis);
    }

    @Test
    public void berechneGesamtpreisMitSpezial() {
        double gesamtPreis = 0d;
        for (Komponente komponente : ausstattung.getKomponenten()) {
            // Hack!!
            if (komponente instanceof Rechner) {
                gesamtPreis += ((Rechner) komponente).berechneSpezialPreis();
            } else {
                gesamtPreis += komponente.getPreis();
            }
        }

        assertEquals(3000d * 0.5d + 488d + 89d + 120d, gesamtPreis);
    }


    @Test
    public void prettyPrintNamen() {
        for (Komponente komponente : ausstattung.getKomponenten()) {
            komponente.prettyPrintName();
        }
    }

    @Test
    public void prettyPrintKategorienUndNamen() {
        for (Komponente komponente : ausstattung.getKomponenten()) {
            komponente.prettyPrintKategorieUndName();
        }
    }
}