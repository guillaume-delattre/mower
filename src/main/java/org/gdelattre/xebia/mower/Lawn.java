package org.gdelattre.xebia.mower;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author guillaume delattre
 * @version 1.0
 * Represents a lawn to be mowed.
 */
public class Lawn {

    private final int row;

    private final int column;

    public Lawn(int row, int column) {
        checkArgument(0 <= row && 0 <= column);
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     * Return false if position is outside of the lawn.
     * @param position
     * @return false if position is outside of the lawn.
     */
    public boolean contains(Position position) { // validate a position in the lawn
        return 0 <= position.getX() && position.getX() <= getRow() && 0 <= position.getY() && position.getY() <= getColumn();
    }
}

