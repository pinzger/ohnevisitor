package ausstattung.hardware;

/**
 * Konkrete Hardware-Komponente Rechner
 */
public class Rechner extends Komponente {
    public Rechner(String name, String kategorie, double preis) {
        super(name, kategorie, preis);
    }

    @Override
    public double berechnePreis() {
        return getPreis() * 0.9d;
    }

    public double berechneSpezialPreis() {
        return getPreis() * 0.5d;
    }
}