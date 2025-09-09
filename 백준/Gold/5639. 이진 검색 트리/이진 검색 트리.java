

import java.io.*;
public class Main {

    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        }
        else {
            node.right = insert(node.right, val);
        }
        return node;
    }

    static StringBuilder sb = new StringBuilder();

    static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.val).append("\n");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.val).append("\n");
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val).append("\n");
    }

    // 50,30,24,5,28,45,98,52,60
    /*
50
30
24
5
28
45
98
52
60
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Node root = null;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            root = insert(root, Integer.parseInt(input));
        }

//        preOrder(root);
//        inOrder(root);
        postOrder(root);
        System.out.print(sb);
    }
}