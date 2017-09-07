package org.gdelattre.xebia.mower;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gdelattre.xebia.mower.OrientedMovement.Direction.NORTH;

/**
 * @author guillaume delattre
 * @version 1.0
 * Test the Lawn class.
 */
public class LawnTest {

    @DataProvider(name = "lawn_position_data")
    public Object[][] lawn_position_data_provider() {
        return new Object[][] {
                { 0, 0, true },
                { 0, 1, true },
                { 0, 2, true },
                { 0, 3, true },
                { 0, 4, true },
                { 1, 0, true },
                { 1, 1, true },
                { 1, 2, true },
                { 1, 3, true },
                { 1, 4, true },
                { 2, 0, true },
                { 2, 1, true },
                { 2, 2, true },
                { 2, 3, true },
                { 2, 4, true },
                { 3, 0, true },
                { 3, 1, true },
                { 3, 2, true },
                { 3, 3, true },
                { 3, 4, true },
                { 4, 0, true },
                { 4, 1, true },
                { 4, 2, true },
                { 4, 3, true },
                { 4, 4, true },
                { -1, -3, false },
                { -1, 2, false },
                { 2, -1, false },
                { 2, 5, false },
                { 6, 2, false },
                { 5, 4, false },
        };
    }

    @Test(dataProvider = "lawn_position_data")
    public void testContains(int x, int y, boolean expected) {
        // given
        final Lawn lawn = new Lawn(4, 4);

        // when / then
        assertThat(lawn.contains(new Position(x, y, NORTH))).isEqualTo(expected);
    }

    @Test
    public void init() {
        // given
        final Lawn lawn = new Lawn(4, 4);

        // then
        assertThat(lawn).isNotNull();
        assertThat(lawn.getRow()).isEqualTo(4);
        assertThat(lawn.getColumn()).isEqualTo(4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void initKO() {
        new Lawn(-2, 4);
    }

}
