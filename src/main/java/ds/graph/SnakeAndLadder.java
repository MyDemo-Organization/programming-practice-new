package ds.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
public class SnakeAndLadder {

    @Getter
    @Setter
    static class Box {
        private int boxNumber;
        private int noOfStepsFromOrigin;
    }


    // the are boxes equal to board size and numbered from [0 .... boardSize -1]
    // returns the minimum no of steps from the origin else returns -1
    public static int getMinimumNumberOfSteps(final int[] move, int boardSize) {
        final boolean[] isVisited = new boolean[boardSize];
        Arrays.fill(isVisited, false);

        final Queue<Box> bfsQueue = new LinkedList<>();

        Box currentBox = new Box();
        currentBox.setBoxNumber(0);
        currentBox.setNoOfStepsFromOrigin(0);
        isVisited[0] = true;

        bfsQueue.add(currentBox);

        while (!bfsQueue.isEmpty()) {
            currentBox = bfsQueue.poll();

            // check if we have reached the final destination
            if (currentBox.getBoxNumber() == boardSize - 1) {
                return currentBox.getNoOfStepsFromOrigin();
            }
            // try for all the possible neighbors
            for (int nbrBoxNumber = currentBox.getBoxNumber() + 1;
                 nbrBoxNumber <= currentBox.getBoxNumber() + 6 && nbrBoxNumber < boardSize;
                 nbrBoxNumber++) {
                if (!isVisited[nbrBoxNumber]) {
                    isVisited[nbrBoxNumber] = true;
                    final Box nbrBox = new Box();
                    nbrBox.setNoOfStepsFromOrigin(currentBox.getNoOfStepsFromOrigin() + 1);

                    // check if it has ladder or snakes
                    if (move[nbrBoxNumber] != -1) {
                        nbrBox.setBoxNumber(move[nbrBoxNumber]);
                    } else {
                        nbrBox.setBoxNumber(nbrBoxNumber);
                    }

                    // add this into the Queue
                    bfsQueue.add(nbrBox);

                }
            }
        }
        return -1;
    }

}
