package org.gdelattre.xebia.mower;

import static org.gdelattre.xebia.mower.OrientedMovement.Direction.turnLeft;
import static org.gdelattre.xebia.mower.OrientedMovement.Direction.turnRight;

/**
 * @author guillaume delattre
 * @version 1.0
 * Enumeration of three instruction corresponding to "G"(LEFT), "D"(RIGHT) and "A"(FORWARD).
 */
public enum Instruction {

    LEFT {
        @Override
        public Position execute(Position current) {
            return turnLeft(current);
        }
    },
    RIGHT {
        @Override
        public Position execute(Position current) {
            return turnRight(current);
        }
    },
    FORWARD {
        @Override
        public Position execute(Position current) {
            return current.getDirection().goForward(current);
        }
    };

    public abstract Position execute(Position current);
}
