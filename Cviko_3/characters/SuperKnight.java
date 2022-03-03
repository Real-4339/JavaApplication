package fiit.cvicenia.Teachers_code.characters;

public class SuperKnight extends Knight{
    public SuperKnight() {
        super();
    }
    public SuperKnight(int energy) {
        super(energy);
    }
    public SuperKnight(int energy, Sword sword) {
        super(energy, sword);
    }

    public void attack(Ogre ogre) {
        sword.hit(this, ogre);
        ogre.revenge(this);
    }
}
