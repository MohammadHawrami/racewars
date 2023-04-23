package pr2.vererbung.racewars.model;
import pr2.vererbung.racewars.model.humanRace.SpawnHuman;
import pr2.vererbung.racewars.model.humanRace.SpawnErzmagier;
import pr2.vererbung.racewars.model.nightElfRace.SpawnNightElf;
import pr2.vererbung.racewars.model.orkRace.SpawnFarseer;
import pr2.vererbung.racewars.model.orkRace.SpawnOrk;
import pr2.vererbung.racewars.model.undeadRace.SpawnLich;
import pr2.vererbung.racewars.model.undeadRace.SpawnUntot;
import pr2.vererbung.racewars.model.nightElfRace.SpawnDaemonSlayer;
/**
 * Klasse, um Wesen zu kaufen und zu erzeugen.
 */
public final class WesenFactory {
    /**
     * Der Methode übergibt man die Information, wie viel Geld man investieren
     * möchte und sie gibt ein Array von Wesen zurück. Das erste Element ist
     * immer der Anführer, die folgenden dann entsprechend die Wesen der Art.
     * Reicht das Geld nicht, wird ein leeres Array zurückgegeben.
     * Die Art der erzeugten Wesen wählt man über einen passenden Parameter aus.
     *
     * @param rasse Rasse von der man Wesen erzeugen möchte
     * @param geld Das Geld, das man investieren möchte.
     *
     * @return Array mit den Wesen, das erste Element ist immer der Anführer.
     */
    public static Wesen[] create(Rasse rasse, int geld) {
        if(rasse.equals(Rasse.MENSCH) && geld >= Rasse.ERZMAGIER_PREIS) {
            final int anzahlMenschen = WesenFactory.calcAmount(geld, Rasse.MENSCHEN_PREIS);
            Wesen[] humanSquad = new Wesen[anzahlMenschen];
            humanSquad[0] = new SpawnErzmagier();
            System.out.println("Erzmagier");
            if(humanSquad.length > 1) {
                for (int i = 1; i < anzahlMenschen; i++) {
                    humanSquad[i] = new SpawnHuman();
                    System.out.println("Mensch");
                }
            }
            return humanSquad;
        }
        if(rasse.equals(Rasse.ORK) && geld >= Rasse.FARSEER_PREIS) {
            final int anzahlOrks = WesenFactory.calcAmount(geld, Rasse.ORK_PREIS);
            Wesen[] orkSquad = new Wesen[anzahlOrks];
            orkSquad[0] = new SpawnFarseer();
            System.out.println("Farseer");
            if(orkSquad.length > 1) {
                for (int i = 1; i < anzahlOrks; i++) {
                    orkSquad[i] = new SpawnOrk();
                    System.out.println("Ork");
                }
            }
            return orkSquad;
        }
        if(rasse.equals(Rasse.ELF) && geld >= Rasse.DAEMONSLAYER_PREIS) {
            final int anzahlElfen = WesenFactory.calcAmount(geld, Rasse.ELF_PREIS);
            Wesen[] elfSquad = new Wesen[anzahlElfen];
            elfSquad[0] = new SpawnDaemonSlayer();
            System.out.println("Slayer");
            if(elfSquad.length > 1) {
                for (int i = 1; i < anzahlElfen; i++) {
                    elfSquad[i] = new SpawnNightElf();
                    System.out.println("Elf");
                }
            }
            return elfSquad;
        }
        if(rasse.equals(Rasse.UNTOT) && geld >= Rasse.LICH_PREIS) {
            final int anzahlUntote = WesenFactory.calcAmount(geld, Rasse.UNTOT_PREIS);
            Wesen[] untotSquad = new Wesen[anzahlUntote];
            untotSquad[0] = new SpawnLich();
            System.out.println("Lich");
            if(untotSquad.length > 1) {
                for (int i = 1; i < anzahlUntote; i++) {
                    untotSquad[i] = new SpawnUntot();
                    System.out.println("Untot");
                }
            }
            return untotSquad;
        }
        return new Wesen[0];
    }
    /**
     * Methode zum errechnen der zu erzeugenden Wesen.
     * @param bekommt verfügbares Guthaben.
     * @param bekommt die kosten der einzelnen Rasse.
     * @return gibt die Anzahl der zu erzeugenden Wesen
     * zurueck inkl. Boss Wesen.
     */
    private static int calcAmount(int guthaben, int kosten) {
        int bossSpaceHolder = 1;
        int bossKosten = kosten * 2;
        guthaben -= bossKosten;
        int amount = bossSpaceHolder;
        for (int i = kosten; i <= guthaben; i += kosten) {
            amount++;
            //System.out.println(amount + "------>"+ Squad.RESTGUTHABEN_TEAM1);
        }
        return amount;
    }
}
