import java.util.ArrayList;

/**
 * TileGame
 */
public class TileGame {

    private ArrayList<NumberTile> board;

    public TileGame() {
        this.board = new ArrayList<NumberTile>();
        for (int i = 0; i < 4; i++) {
            board.add(new NumberTile());
        }
    }

    public ArrayList<NumberTile> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<NumberTile> board) {
        this.board = board;
    }

    public NumberTile getPos(int i) {
        return getBoard().get(i);
    }

    /**
     * Determines where to insert tile, in its current orientation, into game board
     * 
     * @param tile the tile to be placed on the game board
     * @return the position of tile where tile is to be inserted: 0 if the board is
     *         empty; -1 if tile does not fit in front, at end, or between any
     *         existing tiles; otherwise, 0 ≤ position returned ≤ board.size()
     */
    private int getIndexForFit(NumberTile tile) {
        if (getBoard().isEmpty()) {
            return 0;
        }
        for (int i = 0; i < getBoard().size()-1; i++) {
            NumberTile a = getPos(i);
            NumberTile b = getPos(i+1);
            if (a.getRight() == tile.getLeft() && b.getLeft() == tile.getRight()) {
                return i+1;
            }
        }
        return -1;
    }

    /**
     * Places tile on the game board if it fits (checking all possible tile
     * orientations if necessary). If there are no tiles on the game board, the tile
     * is placed at position 0. The tile should be placed at most 1 time.
     * Precondition: board is not null
     * 
     * @param tile the tile to be placed on the game board
     * @return true if tile is placed successfully; false otherwise Postcondition:
     *         the orientations of the other tiles on the board are not changed
     *         Postcondition: the order of the other tiles on the board relative to
     *         each other is not changed
     */
    public boolean insertTile(NumberTile tile) {
        int retries = 0;
        while (retries != 3) {
            if (getIndexForFit(tile) != -1) {
                board.add(getIndexForFit(tile), tile);
                return true;
            } else {
                tile.rotate();
                retries++;
            }
        }
        return false;
    }
}
