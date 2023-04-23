package pr2.vererbung.racewars.model.humanRace;
import pr2.vererbung.racewars.model.Wesen;
public class SpawnHuman extends HumanKnight{
    @Override
    public double getlebensPunkte() {
        // TODO Auto-generated method stub
        return this.lebenspunkte;
    }
    @Override
    public double getDamage() {
        // ruft beschraenke Schaden auf
        return this.damage;
    }
    @Override
    public double getPace() {
        // TODO Auto-generated method stub
        return this.pace;
    }
    @Override
    public double getSHield() {
        // TODO Auto-generated method stub
        return this.shield;
    }
    @Override
    public boolean isLebendig(boolean life) {
        // TODO Auto-generated method stub
        return life;
    }
    @Override
    public double attacke(Wesen gegner) {
        // TODO Auto-generated method stub
        return 0;
    }
}
