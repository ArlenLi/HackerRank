import java.util.HashSet;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] firstPointWithSameLengthToP1 = null;
        int[] secondPointWithSameLengthToP2 = null;
        int[] diagonalPointToP1 = null;

        int lengthBetweenP2AndP1 = calculateLengthSquare(p1, p2);
        int lengthBetweenP3AndP1 = calculateLengthSquare(p1, p3);
        int lengthBetweenP4AndP1 = calculateLengthSquare(p1, p4);

        if(lengthBetweenP2AndP1 == lengthBetweenP3AndP1){
            firstPointWithSameLengthToP1 = p2;
            secondPointWithSameLengthToP2 = p3;
            diagonalPointToP1 = p4;
        }

        if(lengthBetweenP2AndP1 == lengthBetweenP4AndP1){
            firstPointWithSameLengthToP1 = p2;
            secondPointWithSameLengthToP2 = p4;
            diagonalPointToP1 = p3;
        }

        if(lengthBetweenP3AndP1 == lengthBetweenP4AndP1){
            firstPointWithSameLengthToP1 = p3;
            secondPointWithSameLengthToP2 = p4;
            diagonalPointToP1 = p2;
        }

        if(firstPointWithSameLengthToP1 == null){
            return false;
        }

        int sideLengthSquare = calculateLengthSquare(p1, firstPointWithSameLengthToP1);

        return sideLengthSquare != 0
                && calculateLengthSquare(firstPointWithSameLengthToP1, secondPointWithSameLengthToP2) == 2 * sideLengthSquare
                && calculateLengthSquare(diagonalPointToP1, firstPointWithSameLengthToP1) == sideLengthSquare
                && calculateLengthSquare(diagonalPointToP1, secondPointWithSameLengthToP2) == sideLengthSquare;
    }

    private int calculateLengthSquare(int[] point1, int[] point2){
        return Math.abs(point1[0] - point2[0]) * Math.abs(point1[0] - point2[0])
        + Math.abs(point1[1] - point2[1]) * Math.abs(point1[1] - point2[1]);
    }
}
