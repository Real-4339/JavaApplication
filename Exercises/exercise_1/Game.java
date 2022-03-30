package fiit.cvicenia.Teachers_code;

public class Game {
	static void clash(Ogre ogre, Knight knight) {
		knight.attack(ogre);
	}

	public static void main(String[] args) {
		double min = 0.1;
		double max = 0.9;
		Knight[] k = new Knight[100];
		Ogre[] o = new Ogre[100];

		for (int i = 0; i < 20; i++) {
			k[i] = new Knight((Math.random()*(max - min)) + min);
			k[i].energy = 40;
			o[i] = new BadOgre();
			o[i].energy = 50;
			o[i].hungry = true;
		}

		for (int i = 20; i < 40; i++) {
			k[i] = new SuperKnight((Math.random()*(max - min)) + min);
			k[i].energy = 40;
			o[i] = new Bad_BadOgre();
			o[i].energy = 50;
			o[i].hungry = true;
		}

		for (int i = 40; i < 70; i++) {
			k[i] = new SuperKnight((Math.random()*(max - min)) + min);
			k[i].energy = 40;
			o[i] = new Ogre((Math.random()*(max - min)) + min);
			o[i].energy = 50;
		}

		for (int i = 70; i < 100; i++) {
			k[i] = new Knight((Math.random()*(max - min)) + min);
			k[i].energy = 40;
			o[i] = new Ogre((Math.random()*(max - min)) + min);
			o[i].energy = 50;
		}

		for (int i = 0; i < 100; i++) {
			clash(o[i], k[i]);
			
			System.out.println(i + ":"
					+ "knight " + k[i].energy + " / "
					+ "ogre " + o[i].energy);
		}
	}
}
