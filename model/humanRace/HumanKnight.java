package pr2.vererbung.racewars.model.humanRace;
import pr2.vererbung.racewars.model.Wesen;
abstract class HumanKnight extends Wesen{
    double lebenspunkte = 140;
    final double damage = 40;
    final double pace = 2;
    final double shield = 0.4;
    @Override
    public double beschraenkeSchaden(double dmg) {
        return dmg * 0.9;
    }
}
