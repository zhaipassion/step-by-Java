//: interfaces/Games.java
// A Game framework using Factory Methods.

import static com.books.book03.net.mindview.util.Print.print;

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private static final int MOVES = 3;
    private int moves = 0;

    public boolean move() {
        print("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory {
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private static final int MOVES = 4;
    private int moves = 0;

    public boolean move() {
        print("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {
    public Game getGame() {
        return new Chess();
    }
}

public class Games {
    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move())
            ;
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
} /* Output:
Checkers move 0
Checkers move 1
Checkers move 2
Chess move 0
Chess move 1
Chess move 2
Chess move 3
*///:~
