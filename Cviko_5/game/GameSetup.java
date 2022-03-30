package fiit.cvicenia.Teachers_code.game;

import java.util.*;
import fiit.cvicenia.Teachers_code.characters.*;


// Strategy: differnet strategies of setting up a game
public interface GameSetup {
	void setup(List<Knight> knights, List<Ogre> ogres, int nKnights, int nBraveKnights, int nBadOgres);	
}
