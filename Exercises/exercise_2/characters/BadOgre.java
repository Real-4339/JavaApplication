package fiit.cvicenia.Teachers_code.characters;

public class BadOgre extends Ogre {
//	boolean hungry; // beware of attribute hiding!

	public BadOgre() { super(); }

	public BadOgre(int energy) {
		super(energy);
	}

	public BadOgre(int energy, boolean hungry) {
		super(energy, hungry);
	}

	@Override void revenge(Knight knight) {
		if (isHungry())
			eat(knight);
	}
	void eat(Knight knight) {
		knight.setEnergy(0);
	}
}
