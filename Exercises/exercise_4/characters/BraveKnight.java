package fiit.cvicenia.Teachers_code.characters;

public class BraveKnight extends Knight {

	public BraveKnight() {
		super();
	}
	public BraveKnight(int energy) {
		super(energy);
	}
	public BraveKnight(int energy, Sword sword) {
		super(energy, sword);
	}
	
	public void attack(Ogre ogre) {		
		sword.hit(this, ogre);
	}
}
