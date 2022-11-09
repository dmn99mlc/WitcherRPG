package Calculator;

import java.util.Random;

public class diceThrow {

    public int roll() {

        Random r = new Random();
        int low = 1;
        int high = 11;

        return r.nextInt(high-low) + low;
    }


}

