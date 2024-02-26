package org.example.tree;

public class Node<T> {
    T data;
    Node<T> left, right;

    Node(T value){
        this.data = value;
        this.left = this.right = null ;
    }

}
