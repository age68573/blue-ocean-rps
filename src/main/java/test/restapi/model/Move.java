package test.restapi.model;

/**
 * The allowed moves for a player
 */

public enum Move {

    ROCK {
        public boolean winsOver(Move move) {
            return(SCISSORS == move);
        }
    },

    PAPER {
        public boolean winsOver(Move move) {
            return(ROCK == move);
        }
    },

    SCISSORS {
        public boolean winsOver(Move move) {
            return(PAPER == move);
        }
    };

    public abstract boolean winsOver(Move move);
}
