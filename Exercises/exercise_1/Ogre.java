package fiit.cvicenia.Teachers_code;

import java.util.Random;

public class Ogre {
	boolean hungry;
	int energy;
	private double random;

	public double getRandom() {
		return random;
	}

	public void setRandom(double Random) {
		this.random = Random;
	}

	public Ogre(double Random) {
		this.setRandom(Random);
	}
	public Ogre() {

	}
	
	void revenge(Knight knight) {
		if (energy > knight.energy)
			knight.energy = (int) (getRandom() * knight.energy);
	}
}
