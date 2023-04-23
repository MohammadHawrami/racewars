package pr2.vererbung.racewars.model.undeadRace;
import pr2.vererbung.racewars.model.Wesen;
abstract class Lich extends Wesen{
    final double bossFactor = 2.3;
    double lebenspunkte = 120 * bossFactor;
    final double damage = 16 * bossFactor;
    final double pace = 2 * bossFactor;
    final double shield = 0.3 * bossFactor;
}
