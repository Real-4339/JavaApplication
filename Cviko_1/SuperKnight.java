package fiit.cvicenia.Teachers_code;

public class SuperKnight extends Knight {

    public SuperKnight(double Random) {
        super(Random);
    }

    @Override void attack(Ogre ogre) {
        ogre.energy = (int) (getRandom() * ogre.energy);
        ogre.revenge(this);
    }
}
