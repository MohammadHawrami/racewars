package pr2.vererbung.racewars.controller;
import pr2.vererbung.racewars.model.Rasse;
import pr2.vererbung.racewars.model.Wesen;

/**
 * Hauptklasse für das Spiel. Diese Klasse wird gestartet, um das Spiel
 * zu beginnen.
 */
public final class GameController {
    /**
     * Einstiegspunkt in das Programm.
     *
     * @param args Kommandozeilenargumente.
     */
	
	
    public static void main(String[] args) {
        // int rundenCounter = 0;
        GameController game = new GameController();
        game.runGame();
        
    }
    /**
     * Spielt das Spiel bis zum Ende.
     */
    public void runGame() {
        Squad player1 = new Squad("TEAM Gollum");
        Squad player2 = new Squad("TEAM Scheisse");
        System.out.println(player1.getName() + " ");
        System.out.println(player1.buySquad(Rasse.MENSCH, 220, Rasse.MENSCH, 220).length);
        System.out.println(player2.getName() + " ");
        System.out.println(player2.buySquad(Rasse.ORK, 300, Rasse.ORK, 750).length);
        System.out.println(player2.buySquad(Rasse.ELF, 290, Rasse.ELF, 145).length);
        // TODO: Runden des Spieles durchführen
        //gibt ein array zurück, welches das Squad befüllt, wenn das Geld ausreicht
        //sollte ein Leeres Array zurückgeben, falls geld nicht ausreicht --> SQUAD1

        //gibt ein array zurück, welches das Squad befüllt, wenn das Geld ausreicht
        //sollte ein Leeres Array zurückgeben, falls geld nicht ausreicht --> SQUAD2

        //Gameviewer.kampf sollte die stats ausgeben und alles was notwendig ist..
    }
    public String fight() {
        return "hallo";
    }
}
