package org.gdelattre.xebia.mower;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author guillaume delattre
 * @version 1.0
 * Represents a mower.
 */
public class Mower {

    private Position position;

    private Lawn lawn;

    public Mower(Position position, Lawn lawn) {
        this.position = checkNotNull(position);
        this.lawn = checkNotNull(lawn);
        validate(position, lawn);
    }

    /**
     * Validates the position in the lawn. If the position is not valid,
     * throw a {@link IllegalArgumentException}
     * @param position current position
     * @param lawn current lawn
     */
    private void validate(Position position, Lawn lawn) {
        checkArgument(lawn.contains(position), "The position of the mower should be in the lawn.");
    }

    /**
     * Mow...
     * @param instruction
     * @return Return the new mower's position after the instruction execution.
     */
    public Position mow(Instruction instruction) {
        Position next = instruction.execute(position); // make a move to this position
        return lawn.contains(next) ? next : position;
    }

    /**
     * Mow, mow, mow...
     * @param instructions a list of instructions
     * @return Return the new mower's position after the instructions execution.
     */
    public Position mow(List<Instruction> instructions) {
        instructions.forEach(instruction -> position = mow(instruction));

        return position;
    }
}