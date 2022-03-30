package fiit.cvicenia.Teachers_code.game;

import java.util.*;
import fiit.cvicenia.Teachers_code.characters.*;

public class AlternateSwordsSquadGameSetup implements GameSetup {
	public void setup(List<Knight> knights, List<Ogre> ogres, int nKnights, int nBraveKnights, int nBadOgres) {
		int numberOfWarriors = nKnights + nBraveKnights;
		
		WarriorSquad knightsExpedition = new WarriorSquad("Knights Expedition");
		WarriorSquad ogresDefense = new WarriorSquad("Ogres Defence");
		WarriorSquad commonKnightsSquad = new WarriorSquad("Common Knights");
		WarriorSquad braveKnightsSquad = new WarriorSquad("Brave Knights");
		WarriorSquad commonOgresSquad = new WarriorSquad("Common Ogres");
		WarriorSquad badOgresSquad = new WarriorSquad("Bad Ogres");

		for (int i = 0; i < nKnights; ++i) {
			if (i % 2 == 0)
				commonKnightsSquad.addCombatUnit(new Knight(100, new LightSword(i)));
			else
				commonKnightsSquad.addCombatUnit(new Knight(100, new IronSword(i)));
		}	

		// one brave knight remains separate - he will be outside the squads
		for (int i = nKnights; i < nKnights + nBraveKnights - 1; ++i) {
			if (i % 2 == 0)
				braveKnightsSquad.addCombatUnit(new BraveKnight(100, new LightSword(i)));
			else
				braveKnightsSquad.addCombatUnit(new BraveKnight(100, new IronSword(i)));
		}
		
		// a separate brave knight and two created squads are a part of the overall knights expedition, which itself is also a squad
		knightsExpedition.addCombatUnit(new BraveKnight(150, new LightSword(nKnights + nBraveKnights - 1)));
		knightsExpedition.addCombatUnit(braveKnightsSquad);
		knightsExpedition.addCombatUnit(commonKnightsSquad);
		// alternatively, a common knights squad can be put under the brave knight squad - the previous line should be swapped by:
		//braveKnightsSquad.addCombatUnit(commonKnightsSquad);
		
		// just a quick report on the squad structure
		System.out.println(knightsExpedition.report("\t"));
		
		// however, for a clash to be arranged, we need to get a flat list of knights
		knights.addAll((List<Knight>)knightsExpedition.getWarriors());
		
		for (int i = 0; i < nBadOgres - 1; ++i){
				badOgresSquad.addCombatUnit(new BadOgre(300, true));
		}
		
		for (int i = nBadOgres; i < numberOfWarriors; ++i){
			commonOgresSquad.addCombatUnit(new Ogre(100));
		}
		ogresDefense.addCombatUnit(new BadOgre(160));
		ogresDefense.addCombatUnit(badOgresSquad);
		ogresDefense.addCombatUnit(commonOgresSquad);

		System.out.println(ogresDefense.report("\t"));

		ogres.addAll((List<Ogre>)ogresDefense.getWarriors());
	}
}
