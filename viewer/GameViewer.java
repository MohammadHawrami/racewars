package pr2.vererbung.racewars.viewer;
import pr2.vererbung.racewars.controller.GameController;

/**
 * Klasse für das Anzeigen des Game-Zustandes.
 */
public final class GameViewer {

    /**
     * Gib den aktuellen Stand des Spieles aus. Hierzu greift die
     * Methode auf die Methoden des Gamecontrollers zurück.
     *
     * @param game das Spiel
     */
    public static void printGame(GameController game) {
        // bekommt game
        // game.fight -> printet das Match und die Squads.
        System.out.println(game.fight());
    }
    public static void printSquad(GameController game) {
        // bekommt game
        // game.fight -> printet das Match und die Squads.
        System.out.println(game.fight());
    }

}
