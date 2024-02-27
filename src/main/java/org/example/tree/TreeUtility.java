package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtility<T extends Comparable<T>> {

//    function to create a tree by inserting node one by one
//    to a root passed in argument
    public Node<T> insert(Node<T> root, T data){
        if(root == null){
            return new Node<T>(data);
        }
        if(data.compareTo(root.data) < 0){
            root.left = insert(root.left,data);
        }
        if(data.compareTo(root.data) > 0){
            root.right = insert(root.right,data);
        }
        return root;
    }
//    function to create a tree from an array
    public Node<T> createTreeFromArray(T[] arr, Node<T> node, int i) {
        if(i<arr.length){
            node = new Node<T>(arr[i]);
            node.left = createTreeFromArray(arr, node.left, 2*i+1);
            node.right = createTreeFromArray(arr, node.right, 2*i+2);
        }
        return node;
    }

    public void inOrderDFS(Node<T> root){
        if(root == null){
            return;
        }
        inOrderDFS(root.left);
//        performing print operation inorder
        DfsOperation<Integer> print = new Print<Integer>();
        print.operation((Integer)root.data);
        inOrderDFS(root.right);
    }
    // Method to find the height of a binary tree
    public int height(Node<T> node) {
        // Write your code here
        if(node==null){
            return 0;
        }else{
            int lHeight = 1+height(node.left);
            int rHeight = 1+height(node.right);
            return Math.max(lHeight, rHeight);
        }
    }

//    BFS Traversal using recursion. level-order traversal
    public void leveOrderTraversal(Node<T> root){
        int h= height(root);
        for(int i=1;i<=h;i++){
            printNodesAtLevel(root,i,1);
        }
    }
    public void printNodesAtLevel(Node<T> root, int level,int currentLevel){
        if(root == null){
            return;
        }
        if(level==currentLevel){
            System.out.print(root.data+" ");
        }else{
            printNodesAtLevel(root.left, level,currentLevel+1);
            printNodesAtLevel(root.right, level,currentLevel+1);
        }
    }

//    BFS Traversal using queue
    public void leveOrderTraversalWithQueue(Node<T> root){
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<T> temp = queue.peek();
            queue.remove();
            System.out.print(temp.data+" ");
//            enqueue left child
            if(temp.left!=null){
                queue.add(temp.left);
            }
//            enqueue right child
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

}

abstract class DfsOperation<T> {
    abstract void operation(T node);
}

// Class Print for print operation
class Print<T> extends DfsOperation<T> {
    // class add must override operation() method
    // otherwise, compile-time
    // exception will be thrown
    @Override
    void operation(T data)
    {
        System.out.print(data+" ");
    }
}
