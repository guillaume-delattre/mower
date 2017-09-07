package org.gdelattre.xebia.mower;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gdelattre.xebia.mower.OrientedMovement.Direction.*;

/**
 * @author guillaume delattre
 * @version 1.0
 * Test the OrientedMovement class.
 */
public class OrientedMovementTest {

    @DataProvider(name = "turn_left_data")
    public Object[][] turn_left_data_provider() {
        return new Object[][] {
                { new Position(2, 3, NORTH), new Position(2, 3, WEST) },
                { new Position(2, 3, EAST), new Position(2, 3, NORTH) },
                { new Position(1, 1, SOUTH), new Position(1, 1, EAST) },
                { new Position(1, 1, WEST), new Position(1, 1, SOUTH) },
        };
    }

    @DataProvider(name = "turn_right_data")
    public Object[][] turn_right_data_provider() {
        return new Object[][] {
                { new Position(2, 3, NORTH), new Position(2, 3, EAST) },
                { new Position(2, 3, EAST), new Position(2, 3, SOUTH) },
                { new Position(1, 1, SOUTH), new Position(1, 1, WEST) },
                { new Position(1, 1, WEST), new Position(1, 1, NORTH) },
        };
    }

    @Test(dataProvider = "turn_left_data")
    public void testTurnLeftStartedFromNorth(Position current, Position expected) {
        assertThat(turnLeft(current).equals(expected));
    }

    @Test(dataProvider = "turn_right_data")
    public void testTurnRightStartedFromNorth(Position current, Position expected) {
        assertThat(turnRight(current).equals(expected));
    }
}
