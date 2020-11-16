package BinaryTree;

// переходим к созданию самого дерева
// я буду реализовывать основные операции с ДДП, которые даны в википедии:
// вставка, поиск, удаление и обход дерева
public class BinarySearchTree {

    // создание нового узла
    public Node createNode(int key) {
        Node node = new Node();
        node.value = key;
        node.left = null;
        node.right = null;
        return node;
    }

    /*
    Вставка. АЛГОРИТМ:
    Если дерево пусто, заменить его на дерево с одним корневым узлом ((K, V), null, null) и остановиться.
    Иначе сравнить K с ключом корневого узла X.
    Если K>X, рекурсивно добавить (K, V) в правое поддерево Т.
    Если K<X, рекурсивно добавить (K, V) в левое поддерево Т.
    Если K=X, заменить V текущего узла новым значением.
    */
    public Node insert(Node node, int value) {
        if (node == null) {
            return createNode(value);
        } else {
            if (value < node.value) {
                node.left = insert(node.left, value);
            } else if (value > node.value) {
                node.right = insert(node.right, value);
            }
            return node;
        }
    }

    /*
    Поиск. АЛГОРИТМ
    Если дерево пусто, сообщить, что узел не найден, и остановиться.
    Иначе сравнить K со значением ключа корневого узла X.
    Если K=X, выдать ссылку на этот узел и остановиться.
    Если K>X, рекурсивно искать ключ K в правом поддереве Т.
    Если K<X, рекурсивно искать ключ K в левом поддереве Т.
     */
    public boolean find(Node node, int value) {
        if (node == null) {
            return false;
        } else {
            if (value == node.value) {
                return true;
            } else if (value < node.value) {
                return find(node.left, value);
            } else {
                return find(node.right, value);
            }
        }
    }

    /* Удаление. АЛГОРИТМ
    Если дерево T пусто, остановиться;
    Иначе сравнить K с ключом X корневого узла n.
    Если K>X, рекурсивно удалить K из правого поддерева Т;
    Если K<X, рекурсивно удалить K из левого поддерева Т;
    Если K=X, то необходимо рассмотреть три случая.
        Если обоих детей нет;
        Если одного из детей нет;
        Если оба ребёнка присутствуют;
     */

    //вспомогательный метод поиска значения для замещения
    public Node findReplacement(Node node) {

        if (node == null) {
            return null;
        }

        Node current = node.right;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // сам процесс удаления
    public Node remove(Node node, int value) {

        if (node == null) {
            return node;

        } else {
            if (value < node.value) {
                node.left = remove(node.left, value);

            } else if (value > node.value) {
                node.right = remove(node.right, value);

            } else {

                if (node.left == null || node.right == null) {

                    Node current;

                    if (node.left != null) {
                        current = node.left;
                    } else {
                        current = node.right;
                    }

                    if (current == null) {
                        return null;
                    } else {
                        return current;
                    }

                } else {
                    Node replacement = findReplacement(node);
                    node.value = replacement.value;
                    node.right = remove(node.right, replacement.value);
                    return node;
                }
            }
        }
        return node;
    }

    /* INFIX_TRAVERSE. АЛГОРИТМ
    Если дерево пусто, остановиться.
    Иначе
        Рекурсивно обойти левое поддерево Т.
        Применить функцию f к корневому узлу.
        Рекурсивно обойти правое поддерево Т.
     */
    public void infixTraverse(Node node) {

        if (node == null) {
            return;
        }

        infixTraverse(node.left);
        System.out.print(node.value + "; ");
        infixTraverse(node.right);
    }

    /* PREFIX_TRAVERSE. АЛГОРИТМ
     Обойти всё дерево, следуя порядку:
        вершина,
        левое поддерево,
        правое поддерево.
     Элементы, как в дереве
     */
    public void prefixTraverse(Node node) {

        if (node == null) {
            return;
        }

        System.out.print(node.value + "; ");
        prefixTraverse(node.left);
        prefixTraverse(node.right);
    }

    /* POSTFIX_TRAVERSE. АЛГОРИТМ
    Обойти всё дерево, следуя порядку:
        левое поддерево,
        правое поддерево,
        вершина.
    Элементы в обратном порядке, как в дереве
     */
    public void postfixTraverse(Node node) {

        if (node == null) {
            return;
        }

        postfixTraverse(node.left);
        postfixTraverse(node.right);
        System.out.print(node.value + "; ");
    }
}
