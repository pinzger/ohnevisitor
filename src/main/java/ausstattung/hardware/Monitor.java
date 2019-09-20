package ausstattung.hardware;

/**
 * Konkrete Hardware-Komponente Monitor
 */
public class Monitor extends Komponente {
    public Monitor(String name, String kategorie, double preis) {
        super(name, kategorie, preis);
    }

    @Override
    public void prettyPrintName() {
        System.out.println(getName() + "*");
    }

    @Override
    public void prettyPrintKategorieUndName() {
        System.out.println(getKategorie() + ": " + getName() + "*");
    }

}