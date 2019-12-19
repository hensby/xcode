package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class main {


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        ArrayList nodes = new ArrayList();
        nodes.add(5);
        nodes.add(2);
        nodes.add(12);
        nodes.add(3);
        nodes.add(9);
        nodes.add(21);
        nodes.add(25);
        nodes.add(19);
        nodes.add(-4);

        System.out.println(nodes);

        bt = bt.createBinaryTree(nodes);
        bt.printBt(bt.root);
    }
}
