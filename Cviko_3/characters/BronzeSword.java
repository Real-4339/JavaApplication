package fiit.cvicenia.Teachers_code.characters;

public class BronzeSword extends Sword {
    public BronzeSword(int productNumber) {
        super(productNumber);
    }

    public void hit(Knight knight, Ogre ogre) {
        if (knight.getEnergy() >= ogre.getEnergy())
            ogre.setEnergy((int) (0.6 * ogre.getEnergy()));

        System.out.println("Knight - bronze sword");
    }

    public void hit(BraveKnight knight, Ogre ogre) {
        ogre.setEnergy((int) (0.7 * ogre.getEnergy()));

        System.out.println("Brave Knight - bronze sword");
    }

    public void hit(SuperKnight knight, Ogre ogre){
        if (knight.getEnergy() < ogre.getEnergy())
            ogre.setEnergy((int) (0.6 * ogre.getEnergy()));

        System.out.println("Knight - light sword");
    }
}