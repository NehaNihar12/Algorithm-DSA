package org.example.tree;

public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;
    public BinaryTree(){
        this.root = null;
    }
    public static void main(String[] args){
        BinaryTree<Integer> tree =  new BinaryTree<>();
        TreeUtility<Integer> util = new TreeUtility<>();
        Integer[] arr = {1,2,3,4,5};

        Node<Integer> root = util.createTreeFromArray(arr,tree.root,0);
        System.out.println("DFS inorder traversal");
        util.inOrderDFS(root);
        System.out.println();
        System.out.println("height of tree");
        System.out.println(util.height(root));
        System.out.println("bfs using recursion");
        util.leveOrderTraversal(root);
        System.out.println();
        System.out.println("bfs using queue");
        util.leveOrderTraversalWithQueue(root);
    }

}
