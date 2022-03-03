package fiit.cvicenia.Teachers_code.game;

import fiit.cvicenia.Teachers_code.characters.*;

import java.util.ArrayList;

public class Game {
	Ogre[] ogres;
	Knight[] knights;

	int numberOfWarriors;

	private ArrayList<ClashFollower> clashFollowers = new ArrayList<>();
	
	public void clash1on1(Knight knight, Ogre ogre) {
		knight.attack(ogre);
		informClashFollowers();
	}

	static int findEnergyDifference(Energy being1, Energy being2) {
		return being1.getEnergy() - being2.getEnergy();
	}

	public Game(int nKnights, int nBraveKnights, int nBadOgres, GameSetup gameSetup) {
		numberOfWarriors = nKnights + nBraveKnights;
		knights = new Knight[numberOfWarriors];
		ogres = new Ogre[numberOfWarriors];

		followClash(new ClashSinger(this));
		followClash(new ClashReport(this));

		gameSetup.setup(knights, ogres, nKnights, nBraveKnights, nBadOgres);
	}

	public String clash() {
		String report = "";

		// we accumulate the information on the clash into the report variable
		for (int i = 0; i < knights.length; ++i) {
			clash1on1(knights[i], ogres[i]);		
			report = report + (i + 1) + ":"
							+ knights[i].toString() + " / "
							+ "ogre " + ogres[i].getEnergy() + " / "
							+ knights[i].showSword()
							+ "\n";
		}

		return report;
	}
	public void followClash(ClashFollower clashFollower) {
		clashFollowers.add(clashFollower);
	}
	
	public void informClashFollowers() {
		for (ClashFollower clashFollower : clashFollowers)
			clashFollower.inform();
	}	

	public static void main(String[] args) {
		try {
			Game game = new Game(7, 3, 5, new SimpleGameSetup());

	//		game.followClash(new ClashWinners(game));
	//		game.followClash(new ClashWinners(game)); // another observer of the same kind
	//		game.followClash(new ClashReport(game));
			System.out.println(game.clash());
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("\nSorry bro, but number of ogres must be less then knights + brave nights.");
		}
	}
}
