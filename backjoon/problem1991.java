import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static class Node {
        public Node left;
        public Node right;
        public char data;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public void creatTree(char left, char right, char data) {
            if (root == null) {
                root = new Node(data);
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                searchNode(root, left, right, data);
            }
        }

        public void searchNode(Node root, char left, char right, char data) {
            if (root == null) {
                return;
            } else if (root.data == data) {
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                searchNode(root.left, left, right, data);
                searchNode(root.right, left, right, data);
            }
        }

        public void preorder(Node node) {
            System.out.print(root.data); //먼저 가운데 출력
            if(root.left!=null) preorder(root.left); //그 다음 왼쪽
            if(root.right!=null) preorder(root.right); //마지막 오른쪽
        }

        public void inorder(Node node) {
            if(root.left!=null) preorder(root.left); //그 다음 왼쪽
            System.out.print(root.data); //먼저 가운데 출력
            if(root.right!=null) preorder(root.right); //마지막 오른쪽
        }

        public void postorder(Node node) {
            if(root.left!=null) preorder(root.left); //그 다음 왼쪽
            if(root.right!=null) preorder(root.right); //마지막 오른쪽
            System.out.print(root.data); //먼저 가운데 출력
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for(int i = 0; i < N; i++) {
            char[] data;
            data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.creatTree(data[0], data[1], data[2]);

        }

        //전위 순회
        tree.preorder(tree.root);
        System.out.println();

        //중위 순회
        tree.inorder(tree.root);
        System.out.println();

        //후위 순회
        tree.postorder(tree.root);

        br.close();
    }
}
