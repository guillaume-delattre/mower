package org.gdelattre.xebia.mower;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gdelattre.xebia.mower.OrientedMovement.Direction.WEST;

/**
 * @author guillaume delattre
 * @version 1.0
 * Test the Position class.
 */
public class PositionTest {

    @Test
    public void testEqualsAndHash() {
        // given
        final Position pos1 = new Position(2, 4, WEST);
        final Position pos2 = new Position(2, 4, WEST);

        // when / then
        assertThat(pos1.equals(pos2) && pos2.equals(pos1)).isTrue();
        assertThat(pos1.hashCode() == pos2.hashCode()).isTrue();
    }
}
