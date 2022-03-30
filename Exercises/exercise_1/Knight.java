package fiit.cvicenia.Teachers_code;

public class Knight {
	int energy;
	protected double random;

	public double getRandom() {
		return random;
	}

	public void setRandom(double Random) {
		this.random = Random;
	}

	public Knight(double Random) {
		this.setRandom(Random);
	}
	public Knight() {

	}

	void attack(Ogre ogre) {
		ogre.energy = (int) (getRandom() * ogre.energy); // (int) just casts a float result into an int
		ogre.revenge(this); // this represents a reference to the current knight object
		System.out.println(this);
	}
}
