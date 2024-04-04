
public class Node<T extends Comparable<T>> implements Comparable<T> {
    public Node<T> left;
    public Node<T> right;
    public T data;

    public Node(T data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    @Override
    public int compareTo(T o) {
        return this.data.compareTo(o);
    }

    @Override
    public String toString() {
        return "Value: " + this.data.toString() + "\nL: " + this.left.data + "\nR: " + this.right.data;
    }

}
