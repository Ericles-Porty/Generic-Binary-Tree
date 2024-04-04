public class Main {
    public static void main(String[] args) {
        BinaryTree<Character> tree = new BinaryTree<Character>();

        tree.insertNode('6');
        tree.insertNode('2');
        tree.insertNode('8');
        tree.insertNode('1');
        tree.insertNode('4');
        tree.insertNode('3');

        System.out.print("Em ordem ");
        tree.printInOrder();
        System.out.println();

        System.out.print("Pre ordem ");
        tree.printBeforeOrder();
        System.out.println();

        System.out.print("Pos ordem ");
        tree.printAfterOrder();
        System.out.println();

        System.out.println("Buscando na árvore");
        Node<Character> c = tree.search('5');
        System.out.println(c);

        System.out.println(tree.getHeight());
        tree.printTree();
    }
}
