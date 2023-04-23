package pr2.vererbung.racewars.model.orkRace;
import pr2.vererbung.racewars.model.Wesen;
public class SpawnFarseer extends Farseer{
    @Override
    public double attacke(Wesen gegner) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean isLebendig(boolean life) {
        // TODO Auto-generated method stub
        return life;
    }
    @Override
    public double getlebensPunkte() {
        // TODO Auto-generated method stub
        return this.lebenspunkte;
    }
    @Override
    public double getDamage() {
        // TODO Auto-generated method stub
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
}
