package src.models;

public class BinaryTree<T extends Comparable<T>> {
    public Node<T> root;

    public BinaryTree() {
        root = null;
    }

    private Node<T> insertRecursive(Node<T> node, T data) throws IllegalArgumentException {
        if (node == null) {
            return new Node<T>(data);
        }

        if (node.compareTo(data) > 0) {
            node.left = insertRecursive(node.left, data);
        } else if (node.compareTo(data) < 0) {
            node.right = insertRecursive(node.right, data);
        } else {
            throw new IllegalArgumentException("Não é possível inserir nós com valores iguais");
        }

        return node;
    }

    @SuppressWarnings("unused")
    private Node<T> insertLoop(T data) throws IllegalArgumentException {
        if (this.root == null) {
            this.root = new Node<T>(data);
            return this.root;
        }

        Node<T> current = this.root;
        Node<T> parent = null;

        while (current != null) {
            parent = current;

            if (current.compareTo(data) > 0) {
                current = current.left;
            } else if (current.compareTo(data) < 0) {
                current = current.right;
            } else {
                throw new IllegalArgumentException("Não é possível inserir nós com valores iguais");
            }
        }

        if (parent.compareTo(data) > 0) {
            parent.left = new Node<T>(data);
            return parent.left;
        } else if (parent.compareTo(data) < 0) {
            parent.right = new Node<T>(data);
            return parent.right;
        } else {
            throw new IllegalArgumentException("Não é possível inserir nós com valores iguais");
        }
    }

    public void insertNode(T data) {
        try {
            this.root = this.insertRecursive(this.root, data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printInOrder(Node<T> node) {
        if (node == null)
            return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    private void printAfterOrder(Node<T> node) {
        if (node == null)
            return;

        printAfterOrder(node.left);
        printAfterOrder(node.right);
        System.out.print(node.data + " ");
    }

    private void printBeforeOrder(Node<T> node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printBeforeOrder(node.left);
        printBeforeOrder(node.right);
    }

    public void printInOrder() {
        printInOrder(this.root);
        System.out.println();
    }

    public void printBeforeOrder() {
        printBeforeOrder(this.root);
        System.out.println();
    }

    public void printAfterOrder() {
        printAfterOrder(this.root);
        System.out.println();
    }

    public Node<T> search(T data) {
        if (this.root == null)
            throw new IllegalArgumentException("Árvore vazia");

        Node<T> current = this.root;

        while (current != null) {
            if (current.compareTo(data) > 0) {
                current = current.left;
            } else if (current.compareTo(data) < 0) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    private int getHeight(Node<T> node) {
        if (node == null)
            return -1;

        int leftHeight = this.getHeight(node.left);
        int rightHeight = this.getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getHeight() {
        return this.getHeight(this.root);
    }

    private void printTree(Node<T> node, int level) {
        if (node == null)
            return;

        this.printTree(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }

        System.out.println(node.data);

        this.printTree(node.left, level + 1);

    }

    public void printTree() {
        if (this.root == null)
            return;

        this.printTree(this.root, 0);
    }
}
