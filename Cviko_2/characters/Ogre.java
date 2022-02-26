package fiit.cvicenia.Teachers_code.characters;

public class Ogre implements Energy {
	private boolean hungry;
	private int energy;

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public void increaseEnergy(int energy) {
		this.energy += energy;
	}
	public void decreaseEnergy(int energy) {
		this.energy -= energy;
	}
	public int getEnergy() { return energy; }

	public boolean isHungry() {
		return hungry;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	public Ogre() { }
	public Ogre(int energy) { setEnergy(energy); }
	public Ogre(int energy, boolean hungry) {
		setHungry(hungry);
		setEnergy(energy);
	}
	
	void revenge(Knight knight) {
		if (getEnergy() > knight.getEnergy())
//			knight.energy = (int) (0.9 * knight.energy);
			// the energy cannot be accessed directly anymore because it's private
			knight.setEnergy((int) (0.9 * knight.getEnergy()));
	}
}
