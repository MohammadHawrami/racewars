package pr2.vererbung.racewars.model.nightElfRace;
import pr2.vererbung.racewars.model.Wesen;
abstract class DaemonSlayer extends Wesen{
    final double bossFactor = 3.0;
    double lebenspunkte = 120 * bossFactor;
    final double damage = 15 * bossFactor;
    final double pace = 3 * bossFactor;
    final double shield = 0.2 * bossFactor;
}
