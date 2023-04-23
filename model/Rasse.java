package pr2.vererbung.racewars.model;
/**
 * Klasse, um die Rasse eines Wesens anzugeben. Die Klasse enthält
 * vier statische Referenzen, welche die vier Rassen des Spiels repräsentieren.
 * Außerdem speichert sie noch die Kosten pro Rasse.
 */
public final class Rasse {
    public static Rasse MENSCH = new Rasse();
    public static Rasse ORK = new Rasse();
    public static Rasse UNTOT = new Rasse();
    public static Rasse ELF = new Rasse();
    public static final int MENSCHEN_PREIS = 110;
    public static final int ORK_PREIS = 150;
    public static final int ELF_PREIS = 145;
    public static final int UNTOT_PREIS = 70;
    public static final int FARSEER_PREIS = 300;
    public static final int ERZMAGIER_PREIS = 220;
    public static final int LICH_PREIS = 140;
    public static final int DAEMONSLAYER_PREIS = 290;
}