package org.gdelattre.xebia.mower;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gdelattre.xebia.mower.Instruction.FORWARD;
import static org.gdelattre.xebia.mower.Instruction.LEFT;
import static org.gdelattre.xebia.mower.Instruction.RIGHT;
import static org.gdelattre.xebia.mower.OrientedMovement.Direction.NORTH;
import static org.gdelattre.xebia.mower.OrientedMovement.Direction.WEST;

/**
 * @author guillaume delattre
 * @version 1.0
 * Test the Instruction class.
 */
public class InstructionTest {

    @Test
    public void testExecuteLeftInstruction() {
        // given
        final Position initial = new Position(2, 3, NORTH);

        // when51
        final Position result = LEFT.execute(initial);

        // then
        assertThat(result.equals(new Position(2, 3, WEST))).isTrue();
    }

    @Test
    public void testExecuteRightInstruction() {
        // given
        final Position initial = new Position(2, 3, WEST);

        // when
        final Position result = RIGHT.execute(initial);

        // then
        assertThat(result.equals(new Position(2, 3, NORTH))).isTrue();
    }

    @Test
    public void testExecuteGoForwardInstruction() {
        // given
        final Position initial = new Position(2, 3, NORTH);

        // when
        final Position result = FORWARD.execute(initial);

        // then
        assertThat(result.equals(new Position(2, 4, NORTH))).isTrue();
    }
}