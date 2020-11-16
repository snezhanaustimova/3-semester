package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
        Node root = null;

        // добавляем элементы в наше дерево
        root = myTree.insert(root, 13);
        root = myTree.insert(root, 11);
        root = myTree.insert(root, 9);
        root = myTree.insert(root, 16);
        root = myTree.insert(root, 7);
        root = myTree.insert(root, 0);
        root = myTree.insert(root, 44);

        // проверяем, есть ли соответствубщие элементы
        System.out.println(myTree.find(root, 6));
        System.out.println(myTree.find(root, 0));
        System.out.println(myTree.find(root, 9)); // вот он есть

        // удаляем его
        root = myTree.remove(root, 9);

        // ищем
        System.out.println(myTree.find(root, 9)); // вот его нет

        myTree.infixTraverse(root);   // инфиксный обход дерева
        System.out.println();
        myTree.prefixTraverse(root);  // префиксный обход
        System.out.println();
        myTree.postfixTraverse(root); // постфиксный
    }
}
