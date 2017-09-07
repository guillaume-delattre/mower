package org.gdelattre.xebia.mower;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.gdelattre.xebia.mower.Instruction.*;
import static org.gdelattre.xebia.mower.OrientedMovement.Direction.*;

/**
 * @author guillaume delattre
 * @version 1.0
 * Test the Mower class.
 */
public class MowerTest {

    private Lawn lawn;

    @DataProvider(name = "mover_data_provider")
    public Object[][] mover_data_provider() {
        // instructions = {G,A,G,A,G,A,G,A,A}
        final List<Instruction> instructions_1 = newArrayList(
                LEFT, // G
                FORWARD, // A
                LEFT, // G
                FORWARD, // A
                LEFT, // G
                FORWARD, // A
                LEFT, // G
                FORWARD, // A
                FORWARD); // A

        // instructions = {A,A,D,A,A,D,A,D,D,A}
        final List<Instruction> instructions_2 = newArrayList(
                FORWARD, // A
                FORWARD, // A
                RIGHT, // D
                FORWARD, // A
                FORWARD, // A
                RIGHT, // D
                FORWARD, // A
                RIGHT, // D
                RIGHT, // D
                FORWARD); // A

        return new Object[][]{
                { new Position(1, 2, NORTH), instructions_1, new Position(1, 3, NORTH)},
                { new Position(3, 3, EAST), instructions_2, new Position(5, 1, EAST)}
        };
    }

    @BeforeClass
    private void init() {
        lawn = new Lawn(5, 5);
    }

    @Test
    public void testMowInsideLawn() {
        // given
        final Instruction instruction = FORWARD;
        final Position current = new Position(1, 1, SOUTH);
        final Mower mower = new Mower(current, lawn);

        // when
        final Position result = mower.mow(instruction);

        // then
        assertThat(result.equals(new Position(1, 0, SOUTH))).isTrue();
    }

    @Test
    public void testMotionless() {
        // given
        final Instruction instruction = FORWARD;
        final Position current = new Position(1, 0, SOUTH);
        final Mower mower = new Mower(current, lawn);

        // when
        final Position result = mower.mow(instruction);

        // then
        assertThat(result.equals(new Position(1, 0, SOUTH))).isTrue();
    }

    @Test(dataProvider = "mover_data_provider")
    public void testMowWithSeveralInstructions(Position initial,
                                               List<Instruction> instructions,
                                               Position result) {

        // given
        final Mower mower = new Mower(initial, lawn);

        // then
        assertThat(mower.mow(instructions).equals(result)).isTrue();
    }
}
