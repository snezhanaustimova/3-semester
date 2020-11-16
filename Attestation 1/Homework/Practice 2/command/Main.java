package command;

public class Main {

    // создаем объект и экспериментируем
    public static void main(String[] args) {
        UndoableStringBuilder str = new UndoableStringBuilder();
        str.append("My first line.");
        System.out.println(str);
        str.append(" Because I have no idea.");
        System.out.println(str);
        str.undo();
        System.out.println(str);
        str.delete(2, 8);
        System.out.println(str);
        str.undo();
        System.out.println(str);
        str.setLength(5);
        System.out.println(str);
        str.undo();
        System.out.println(str);
        str.setLength(24);
        System.out.println(str);
        str.undo();
        System.out.println(str.length());
    }
}
