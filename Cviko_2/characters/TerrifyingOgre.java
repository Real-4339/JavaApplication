package fiit.cvicenia.Teachers_code.characters;

public class TerrifyingOgre extends BadOgre {

    public TerrifyingOgre() { super(); }

    public TerrifyingOgre(int energy) {
        super(energy);
    }

    public TerrifyingOgre(int energy, boolean hungry) {
        super(energy, hungry);
    }

    @Override void revenge(Knight knight) {
        if (isHungry()) {
            super.eat(knight);
            roar();
        }
    }

     void roar () {
        System.out.println("That ogre killed one of yours and you hear his roar.");
    }

}
