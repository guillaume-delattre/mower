package org.gdelattre.xebia.mower;

import java.util.function.Function;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author guillaume delattre
 * @version 1.0
 *
 * Represents an oriented movement of the mower. The current implementation specifies
 * that the mower is able :
 *   - to move one square to the north, to the east, to the south
 *     or to the west
 *   - to turn on himself to the left or to the right
 * An oriented movement is mathematically a translation or a rotation.
 * Note : the order declaration of the enumeration values is strict.
 */
public final class OrientedMovement {

    // compass orientations
    public enum Direction {
        NORTH {
            @Override
            public Position goForward(Position current) {
                return new Position(current.getX(), current.getY() + 1, current.getDirection());
            }
        }, EAST {
            @Override
            public Position goForward(Position current) {
                return new Position(current.getX() + 1, current.getY(), current.getDirection());
            }
        }, SOUTH {
            @Override
            public Position goForward(Position current) {
                return new Position(current.getX(), current.getY() - 1, current.getDirection());
            }
        }, WEST {
            @Override
            public Position goForward(Position current) {
                return new Position(current.getX() - 1, current.getY(), current.getDirection());
            }
        };

        /**
         * Left rotation (mathematical function) applied to a position.
         */
        private static final Function<Direction, Direction> rotateLeft = direction -> {

            Direction[] directions = Direction.values();
            final int index = newArrayList(directions).indexOf(direction);
            final Direction lastDirection = directions[directions.length - 1];

            return index == 0 ? lastDirection : directions[index - 1];
        };

        /**
         * Right rotation (mathematical function) applied to a position.
         */
        private static final Function<Direction, Direction> rotateRight = direction -> {

            Direction[] directions = Direction.values();

            final int index = newArrayList(directions).indexOf(direction);
            final Direction firstDirection = directions[0];
            return index == directions.length - 1 ? firstDirection : directions[index + 1];
        };

        /**
         * Return a resulted position by left rotation.
         * @param position
         * @return new position
         */
        public static Position turnLeft(Position position) {
            return new Position(position.getX(),
                                position.getY(),
                                rotateLeft.apply(position.getDirection()));
        }

        /**
         * Return a resulted position by right rotation.
         * @param position
         * @return new position
         */
        public static Position turnRight(Position position) {
            return new Position(position.getX(),
                                position.getY(),
                                rotateRight.apply(position.getDirection()));
        }

        /**
         * Return a resulted position by a translation.
         * @param position
         * @return new position
         */
        public abstract Position goForward(Position position);
    }
}
