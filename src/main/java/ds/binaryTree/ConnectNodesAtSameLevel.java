package ds.binaryTree;

import lombok.Getter;
import lombok.Setter;

/**
 * Problem Statement: "Connect Nodes"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
public class ConnectNodesAtSameLevel {

    public void connectNodes(final ModifiedNode node){
        if (node == null)
            return;

        if (node.getLeft() != null){
            node.getLeft().setNextRight(node.getRight());
        }

        if (node.getRight() != null) {
            node.getRight().setNextRight(
                    node.getNextRight() != null?
                            node.getNextRight().getLeft():
                            null);
        }

        connectNodes(node.getLeft());
        connectNodes(node.getRight());
    }
}

@Getter
@Setter
class ModifiedNode{
    private int data;
    private ModifiedNode left;
    private ModifiedNode right;
    private ModifiedNode nextRight;

}
