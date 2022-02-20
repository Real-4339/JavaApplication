package fiit.cvicenia.Teachers_code;

public class BadOgre extends Ogre {

	@Override void revenge(Knight knight) {
		if (hungry)
			eat(knight);
	}

	void eat(Knight knight) {
		knight.energy = 0;
	}

}


