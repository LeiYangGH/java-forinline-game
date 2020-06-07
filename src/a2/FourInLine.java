package a2;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class FourInLine {


    // Declare some constants

    static int NColumns = 7;
    static int NRows = 6;

    // A player is either the red player, or the blue player

    public static Player redPlayer = Player.redPlayer;
    public static Player bluePlayer = Player.bluePlayer;


    // A piece is either a red piece or a blue piece

    public static Piece redPiece = Piece.redPiece;
    public static Piece bluePiece = Piece.bluePiece;


    // A column is a list of Pieces.  The first element of the list represents the top of
    // the column, e.g.
    // row 6 --
    // row 5 --
    // row 4 -- RedPiece   <- first element of the list
    // row 3 -- RedPiece
    // row 2 -- BluePiece
    // row 1 -- RedPiece   <- last element in the list
    // The list for this column would be [redPiece, redPiece, bluePiece, redPiece]
    // Now, to add a piece to the TOP of a column, just create a new column
    // with that piece and append the rest of the old column to it

    // a Column is a list of pieces

    public static class Column extends ArrayList<Piece> {
        public Column() {
        }
        public Column(List<Piece> l) {
            this.addAll(l);
        }
    }

    // The GameState is a list of Columns

     public static class GameState extends ArrayList<Column> {
        public GameState() {
        }
        public GameState(List<List<Piece>> g) {
            List<Column> c = g.stream().map(Column::new).collect(toList());
            this.addAll(c);
        }
     }


    // ColumnNums are 1-based, but list indices are 0-based.  indexOfColumn converts
    // a ColumnNum to a list index.

    public static class ColumnNum {
        int index;
        public ColumnNum(int index) {
            GameState s;
            this.index = index;
        }
        public int indexOfColumn() {
            return index - 1;
        }
        public String toString() {
            return "" + index;
        }
    }

    //
    //   Convert a column to a string of the form "rBrrBB", or "   rrB".  The string
    //   must have length 6.  If the column is not full, then the list should be
    //   prefixed with an appropriate number of spaces
    //

    //   Convert a column to a string of the form "rBrrBB", or "   rrB".  The string
    //   must have length 6.  If the column is not full, then the list should be
    //   prefixed with an appropriate number of spaces

    private static String padLeftLoopRaw(String input, char padChar, int padUpTo) {
        String out = new String();
        for (int toPrepend = padUpTo - input.length(); toPrepend > 0; toPrepend--) {
            out += padChar;
        }
        return out + input;
    }

    public static String showColumn(Column xs) {
//        throw new RuntimeException("Missing implementation!"); // replace this with implementation
        String piecesStr = xs.stream().limit(6).map(x -> x.toString()).collect(Collectors.joining(""));

        return padLeftLoopRaw(piecesStr, ' ', 6);
    }


    //
    //  Convert a GameState value to a string of the form:
    //  "    r        \n
    //   r   r   B   r\n
    //   B B r   B r B\n
    //   r B r r B r r\n
    //   r B B r B B r\n
    //   r B r r B r B"
    //   Useful functions:
    //     showColumn
    //       (which you already defined)
    //     and transposes a list of lists using streams,
    //       so List(List(1,2,3), List(4,5,6)) becomes List(List(1,4), List(2,5), List(3,6))

    public static String showGameState(GameState xs) {
        // throw new RuntimeException("Missing implementation!"); // replace this with implementation
        return IntStream.range(0, 6)
                .mapToObj(j -> IntStream.range(0, 7)
                        .mapToObj(i -> String.valueOf(showColumn(xs.get(i)).charAt(j)))
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    // Which pieces belong to which players?

    public static Piece pieceOf(Player player) {
//        throw new RuntimeException("Missing implementation!"); // replace this with implementation
        return player == Player.bluePlayer ? Piece.bluePiece : Piece.redPiece;
    }

    // Given a player, who is the opposing player?

    public static Player otherPlayer(Player player) {
//        throw new RuntimeException("Missing implementation!"); // replace this with implementation
        return player == Player.bluePlayer ? Player.redPlayer : Player.bluePlayer;
    }


    // Given a piece, what is the colour of the other player's pieces?

    public static Piece otherPiece(Piece piece) {
//        throw new RuntimeException("Missing implementation!"); // replace this with implementation
        return piece == Piece.redPiece ? Piece.bluePiece : Piece.redPiece;
    }


    // The initial GameState, all columns are empty.  Make sure to create the proper
    // number of columns

    public static GameState initGameState() {
//        throw new RuntimeException("Missing implementation!"); // replace this with implementation
        List<List<Piece>> collect = IntStream.range(0, 7)
                .mapToObj(i -> new ArrayList<Piece>())
                .collect(toList());
        return new GameState(collect);
    }


    // Check if a column number is valid (i.e. in range)

    public static boolean isValidColumn(ColumnNum c) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }


    // Check if a column is full (a column can hold at most nRows of pieces)

    public static boolean isColumnFull(Column column) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }


    // Return a list of all the columns which are not full (used by the AI)

    public static List<ColumnNum> allViableColumns(GameState game) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation

    }

    // Check if the player is able to drop a piece into a column

    public static boolean canDropPiece(GameState game, ColumnNum columnN) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }

    // Drop a piece into a numbered column, resulting in a new gamestate

    public static GameState dropPiece(GameState game, ColumnNum columnN, Piece piece) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation

    }

    // Are there four pieces of the same colour in a column?

    static boolean fourInCol(Piece piece, Column col) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }

    public static boolean fourInColumn(Piece piece, GameState game) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }


    // transposes gameboard, assumes all columns are full
    static GameState transpose(GameState g) {
        return new GameState(IntStream.range(0, g.get(0).size())
                .mapToObj(i -> g.stream()
                        .map(l -> l.get(i))
                        .collect(toList()))
                .collect(toList()));
    }
    // A helper function that fills up a column with pieces of a certain colour.  It
    // is used to fill up the columns with pieces of the colour that
    // fourInRow/fourInDiagonal is not looking for.  This will make those functions
    // easier to define.

    static Column fillBlank(Piece piece, Column column) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation

    }

    // Are there four pieces of the same colour in a row?  Hint: use fillBlanks and
    // transpose to reduce the problem to fourInColumn

    public static boolean fourInRow(Piece piece, GameState game) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }


    // Another helper function for fourInDiagonal.  Remove n pieces from the top of
    // a full column and add blanks (of the colour we're not looking for) to the
    // bottom to make up the difference.  This makes fourDiagonal easier to define.

    static Column shift(int n, Piece piece, Column column) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }

    // Are there four pieces of the same colour diagonally?  Hint: define a helper
    // function using structural recursion over the gamestate, and using shift and fourInRow.

    static boolean fourDiagonalHelper(GameState g, Piece piece) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }

    public static boolean fourDiagonal(Piece piece, GameState game) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }

    // Are there four pieces of the same colour in a line (in any direction)

    public static boolean fourInALine(Piece piece, GameState game) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }

    // Who won the game.  Returns an Optional since it could be that no one has won the
    // game yet.

    public static Optional<Player> winner(GameState game) {
        throw new RuntimeException("Missing implementation!"); // replace this with implementation
    }

}
