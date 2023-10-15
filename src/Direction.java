import java.util.Random;

public enum Direction {
    //les differentes directions possibles
    NORD,
    SUD,
    EST,
    OUEST;

    public Direction getOpposee() {
        switch (this) {
            case NORD:
                return SUD;
            case SUD:
                return NORD;
            case EST:
                return OUEST;
            case OUEST:
                return EST;
            default:
                return null;
        }
    }

    /* Tirage d'une direction aléatoire */
    public static Direction random() {
        Random rnd = new Random();
        int r = rnd.nextInt(4);
        switch (r) {
            case 0:  return Direction.NORD;
            case 1:  return Direction.SUD;
            case 2:  return Direction.EST;
            default: return Direction.OUEST;
        }
    }

}