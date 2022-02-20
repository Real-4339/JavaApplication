package fiit.cvicenia.Teachers_code;

public class Bad_BadOgre extends BadOgre {

    @Override void revenge (Knight knight) {
        if (hungry)
            deal(knight);
    }

    void deal(Knight knight){
        knight.energy /= 2;
    }
}
