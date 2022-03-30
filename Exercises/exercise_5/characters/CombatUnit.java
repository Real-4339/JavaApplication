package fiit.cvicenia.Teachers_code.characters;

import java.util.*;

// The Composite pattern - the Component role

public interface CombatUnit {
	List<? extends Warrior> getWarriors();
	String report(String tab);
}
