package fiit.cvicenia.Teachers_code.game;

import fiit.cvicenia.Teachers_code.characters.*;
import java.util.*;

public class SimpleGameSetup implements GameSetup {
	public void setup(List<Knight> knights, List<Ogre> ogres, int nKnights, int nBraveKnights, int nBadOgres) {
		int numberOfWarriors = nKnights + nBraveKnights;
		
		for (int i = 0; i < nKnights; ++i){
			knights.add(new Knight(80, new IronSword(i)));
		}

		for (int i = nKnights; i < numberOfWarriors; ++i){
			knights.add(new BraveKnight(100, new LightSword(i)));
		}

		for (int i = 0; i < nBadOgres; ++i){
			ogres.add(new BadOgre(100));
		}
		
		for (int i = nBadOgres; i < numberOfWarriors; ++i){
			ogres.add(new Ogre(100));
		}
	}
}