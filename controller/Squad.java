package pr2.vererbung.racewars.controller;
import pr2.vererbung.racewars.model.Wesen;
import pr2.vererbung.racewars.model.WesenFactory;
import pr2.vererbung.racewars.model.Rasse;
/**
 * Zusammenstellung von Wesen für den Kampf.
 */
public final class Squad {
    /**
     * Maximal vorhandenes Geld für das Kaufen von Wesen für das Squad.
     */
    public static final int MAX_INVEST = 2000;
    private String name;
    public int restguthaben = MAX_INVEST;
    static final int MAX_WESEN_AMOUNT = 20;
    static boolean ELF_IS_AVAILABLE = true;
    static boolean MENSCH_IS_AVAILABLE = true;
    static boolean ORK_IS_AVAILABLE = true;
    static boolean UNTOT_IS_AVAILABLE = true;
    public Squad(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public Wesen[] buySquad(Rasse rasse1,int preis, Rasse rasse2, int preis2) {
        int dedicatedCash1
        = makeItPassend(rasse1,checkRasseIstBelegt(rasse1, preis));
        Wesen[] a
        = WesenFactory.create(rasse1, dedicatedCash1);
        if(a.length < 1) {
            ELF_IS_AVAILABLE = true;
            MENSCH_IS_AVAILABLE = true;
            ORK_IS_AVAILABLE = true;
            UNTOT_IS_AVAILABLE = true;
        }
        int dedicatedCash2
        = maxInvestCheckTeam( checkRasseIstBelegt(rasse2, preis2));
        Wesen[] b
        = WesenFactory.create(rasse2, dedicatedCash2);
        Wesen[] fullSquad
        = Squad.addSquadToFinalSquad(a, b);
        return fullSquad;
    }
    private int checkRasseIstBelegt(Rasse rasse, int geld) {
        if(rasse == Rasse.MENSCH && MENSCH_IS_AVAILABLE) {
            MENSCH_IS_AVAILABLE = false;
            return geld;
        }
        if(rasse == Rasse.ELF && ELF_IS_AVAILABLE) {
            ELF_IS_AVAILABLE = false;
            return geld;
        }
        if(rasse == Rasse.ORK && ORK_IS_AVAILABLE) {
            ORK_IS_AVAILABLE = false;
            return geld;
        }
        if(rasse == Rasse.UNTOT && UNTOT_IS_AVAILABLE) {
            UNTOT_IS_AVAILABLE = false;
            return geld;
        }
        return 0;
    }
    /**
     * Laesst geld hindurch fließen, falls nicht doppelt belegt.
     * gibt bei Doppelbelegung null zurück
     * @param rasse1 ist Erzeugungswunsch 1
     * @param rasse2 ist Erzeugungswunsch 2
     * @param geld stellt kaufkraft dar
     * @return geld das ausgegeben werden darf
     */
    public int makeItPassend(Rasse rasse, int geld) {
        if(geld > MAX_INVEST) {
            return MAX_INVEST;
        }
        if(rasse == Rasse.MENSCH) {
            if(geld > Rasse.ERZMAGIER_PREIS) {
                int amount = 0;
                amount = (geld - Rasse.ERZMAGIER_PREIS) / Rasse.MENSCHEN_PREIS;
                int glattBetrag = (amount * Rasse.MENSCHEN_PREIS) + Rasse.ERZMAGIER_PREIS;
                this.restguthaben -= glattBetrag;
                MENSCH_IS_AVAILABLE = false;
                return glattBetrag;
            }
            if(geld == Rasse.ERZMAGIER_PREIS) {
                this.restguthaben -= Rasse.ERZMAGIER_PREIS;
                MENSCH_IS_AVAILABLE = false;
                return geld;
            }
        }
        if(rasse == Rasse.ORK) {
            if(geld > Rasse.FARSEER_PREIS) {
                int amount = 0;
                amount = (geld - Rasse.FARSEER_PREIS) / Rasse.ORK_PREIS;
                int glattBetrag = (amount * Rasse.ORK_PREIS) + Rasse.FARSEER_PREIS;
                this.restguthaben -= glattBetrag;
                ORK_IS_AVAILABLE = false;
                return glattBetrag;
            }
            if(geld == Rasse.FARSEER_PREIS) {
                this.restguthaben -= Rasse.FARSEER_PREIS;
                ORK_IS_AVAILABLE = false;
                return geld;
            }
        }
        if(rasse == Rasse.ELF) {
            if(geld > Rasse.DAEMONSLAYER_PREIS) {
                int amount = 0;
                amount = (geld - Rasse.DAEMONSLAYER_PREIS) / Rasse.ELF_PREIS;
                int glattBetrag = (amount * Rasse.ELF_PREIS) + Rasse.DAEMONSLAYER_PREIS;
                this.restguthaben -= glattBetrag;
                ELF_IS_AVAILABLE = false;
                return glattBetrag;
            }
            if(geld == Rasse.DAEMONSLAYER_PREIS) {
                this.restguthaben -= Rasse.DAEMONSLAYER_PREIS;
                ELF_IS_AVAILABLE = false;
                return geld;
            }
        }
        if(rasse == Rasse.UNTOT) {
            if(geld > Rasse.LICH_PREIS) {
                int amount = 0;
                amount = (geld - Rasse.LICH_PREIS) / Rasse.UNTOT_PREIS;
                int glattBetrag = (amount * Rasse.UNTOT_PREIS) + Rasse.LICH_PREIS;
                this.restguthaben -= glattBetrag;
                UNTOT_IS_AVAILABLE = false;
                return glattBetrag;
            }
            if(geld == Rasse.LICH_PREIS) {
                this.restguthaben -= Rasse.LICH_PREIS;
                UNTOT_IS_AVAILABLE = false;
                return geld;
            }
        }
        return 0;
    }
    /**
     * Ueberprueft ob uebergebenes Squads null ist.
     * @param Wesen[] squad ist ein Spielersquad
     */
    public static boolean squadIsNotEmpty(Wesen[] squad) {
        for (int i = 0; i < squad.length; i++) {
            if(squad[i] != null) {
                return true;
            }
        }
        return false;
    }
    private static boolean hasValidSize(Wesen[] squad1, Wesen[] squad2) {
        if(squad1.length + squad2.length <= MAX_WESEN_AMOUNT) {
            return true;
        }
        return false;
    }
    private static boolean squadIsFull(Wesen[] squad) {
        if(squad.length == MAX_WESEN_AMOUNT) {
            return true;
        }
        return false;
    }
    private static boolean squadIsOverload(Wesen[] squad) {
        if(squad.length > MAX_WESEN_AMOUNT) {
            return true;
        }
        return false;
    }
    private int maxInvestCheckTeam(int geld) {
        if(geld > this.restguthaben) {
            return this.restguthaben;
        }
        return geld;
    }
    /**
     * Methode Addiert ein Squad zum Anderen.
     * @param secondSquad ist ein Wesen Array
     * @return Wesen[] ein volles Squad
     * beschraenkt bei bedarf die Groesse des Squads
     * bevorzugt dabei alle Wesen des auf sich
     * selbst angewendeten Wesen Arrays
     * gibt bei addition mit mind. einem leeren Squad
     * nur das Volle zurueck, bei Addition mit zwei
     * leeren Squads gibt es ein neues leeres Squad
     * vom Typ Wesen Array zurueck
     */
    private static Wesen[] addSquadToFinalSquad(Wesen[]firstSquad, Wesen[] secondSquad) {
        if(squadIsOverload(firstSquad)) {
            Wesen[] dezimiertesSquad = new Wesen[MAX_WESEN_AMOUNT];
            for (int i = 0; i < MAX_WESEN_AMOUNT; i++) {
                dezimiertesSquad[i] = firstSquad[i];
            }
            return dezimiertesSquad;
        }
        if(squadIsFull(firstSquad)) {
            return firstSquad;
        }
        if(squadIsNotEmpty(firstSquad) && (!squadIsNotEmpty(secondSquad))) {
            return firstSquad;
        }
        if(((!squadIsNotEmpty(firstSquad))
                && squadIsNotEmpty(secondSquad))
                && (!squadIsOverload(secondSquad))) {
            return secondSquad;
        }
        if(squadIsNotEmpty(firstSquad) && squadIsNotEmpty(secondSquad)) {
            if(hasValidSize(firstSquad, secondSquad)) {
                Wesen[] vollesSquad = new Wesen[firstSquad.length + secondSquad.length];
                for (int i = 0; i < firstSquad.length; i++) {
                    vollesSquad[i] = firstSquad[i];
                }
                for (int j = firstSquad.length; j < secondSquad.length; j++) {
                    vollesSquad[j] = secondSquad[j - firstSquad.length];
                }
                return vollesSquad;
            }
            else {
                Wesen[] vollesSquad = new Wesen[MAX_WESEN_AMOUNT];
                for (int i = 0; i < firstSquad.length; i++) {
                    vollesSquad[i] = firstSquad[i];
                }
                for (int j = firstSquad.length; j < MAX_WESEN_AMOUNT; j++) {
                    vollesSquad[j] = secondSquad[j - firstSquad.length];
                }
                return vollesSquad;
            }
        }
        return new Wesen[0];
    }
}
