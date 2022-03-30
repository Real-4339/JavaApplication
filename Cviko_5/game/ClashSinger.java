/*package fiit.cvicenia.Teachers_code.game;

public class ClashSinger implements ClashFollower {
    Game game;

    public ClashSinger(Game game) {
        this.game = game;
    }

    public void inform() {
        int knightsEnergy = 0;
        int ogresEnergy = 0;

        for (int i = 0; i < game.getNumberOfWarriors(); ++i) {
            knightsEnergy += game.getKnight(i).getEnergy();
            ogresEnergy += game.getOgre(i).getEnergy();
        }

        if( knightsEnergy >= ogresEnergy )
            System.out.println("$$$ Knights - Ogres difference is only: " + (knightsEnergy - ogresEnergy) + " $$$");
        else {
            System.out.println("$$$ Ogres - Knights difference is only: " + (ogresEnergy - knightsEnergy) + " $$$");
        }
    }
}*/
