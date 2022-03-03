package fiit.cvicenia.Teachers_code.game;

import fiit.cvicenia.Teachers_code.characters.*;

// Strategy: differnet strategies of setting up a game
public interface GameSetup {
	void setup(Knight[] knights, Ogre[] ogres, int nKnights, int nBraveKnights, int nBadOgres);
}
