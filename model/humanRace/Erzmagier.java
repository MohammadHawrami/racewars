package pr2.vererbung.racewars.model.humanRace;
import pr2.vererbung.racewars.model.Wesen;
abstract class Erzmagier extends Wesen{
    final double bossFactor = 5;
    double lebenspunkte = 140 * bossFactor;
    final double damage = 40 * bossFactor;
    final double pace = 2 * bossFactor;
    final double shield = 0.4 * bossFactor;
}
