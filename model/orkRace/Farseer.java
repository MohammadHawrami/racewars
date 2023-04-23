package pr2.vererbung.racewars.model.orkRace;
import pr2.vererbung.racewars.model.Wesen;
abstract class Farseer extends Wesen{
    final double bossFactor = 1.2;
    double lebenspunkte = 100 * bossFactor;
    final double damage = 33 * bossFactor;
    final double pace = 1 * bossFactor;
    final double shield = 0.3 * bossFactor;
}
