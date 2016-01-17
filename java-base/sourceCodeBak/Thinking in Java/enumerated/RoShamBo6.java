//: enumerated/RoShamBo6.java
// Enums using "tables" instead of multiple dispatch.
package enumerated;

import static enumerated.Outcome.DRAW;
import static enumerated.Outcome.LOSE;
import static enumerated.Outcome.WIN;

enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;
    private static Outcome[][] table = {
            {DRAW, LOSE, WIN}, // PAPER
            {WIN, DRAW, LOSE}, // SCISSORS
            {LOSE, WIN, DRAW}, // ROCK
    };

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }

    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }
} ///:~
