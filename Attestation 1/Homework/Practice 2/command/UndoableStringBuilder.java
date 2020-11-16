package command;

import java.util.Stack;

public class UndoableStringBuilder {
    private interface Action{
        void undo();
    }
    private class DeleteAction implements Action{
        private int size;

        public DeleteAction(int size){
            this.size = size;

        }
        @Override
        public void undo(){
            stringBuilder.delete(stringBuilder.length() - size, stringBuilder.length());
        }
    }

    private StringBuilder stringBuilder;

    // создаем стек, который будет содержать все действия
    private Stack<Action> actionStack = new Stack<>();

    // создаем экземпляр класса путем вызова конструктора
    public UndoableStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    // чтобы нормально выполнить "undo", нам надо реализовать операцию,
    // обратную данной. В случае с append это будет delete.
    // Из переданных параметров формируем противоположную функцию
    public UndoableStringBuilder append(String something) {
        int size = something.length();
        stringBuilder.append(something);
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - (size + 1), stringBuilder.length());
                System.out.println("Операция 'append' была отменена");
            }
        };
        // теперь, раз уж мы зашли сюда, добавляем это действие в стек,
        // после чего его можно будет легко отменить
        actionStack.add(action);
        // возвращаем текущий экземпляр класса
        return this;
    }

    // далее все аналогично
    public UndoableStringBuilder delete(int start, int end) {
        String deletedPart = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.insert(start, deletedPart);
                System.out.println("Операция 'delete' была отменена");
            }
        };
        actionStack.add(action);
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int ind) {
        char deletedPart = stringBuilder.charAt(ind);
        stringBuilder.deleteCharAt(ind);
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.insert(ind, deletedPart);
                System.out.println("Операция 'deleteCharAt' была отменена");
            }
        };
        actionStack.add(action);
        return this;
    }

    public UndoableStringBuilder insert(int place, String something) {
        stringBuilder.insert(place, something);
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.delete(place, something.length());
                System.out.println("Операция 'insert' была отменена");
            }
        };
        actionStack.add(action);
        return this;
    }

    // тут если нужно удлинить, то потом просто удаляем лишнее,
    // если же надо укоротить, то вставляем удаленные символы обратно
    // отсюда и условие на каждый вариант развития событий
    public UndoableStringBuilder setLength(int len) {
        if (len >= stringBuilder.length()) {
            stringBuilder.setLength(len);
            Action action = new Action() {
                @Override
                public void undo() {
                    stringBuilder.delete(stringBuilder.length(), len);
                    System.out.println("Операция 'setLength' была отменена");
                }
            };
            actionStack.add(action);
            return this;
        }
        else {
            String deletedPart = stringBuilder.substring(len, stringBuilder.length());
            stringBuilder.setLength(len);
            Action action = new Action() {
                @Override
                public void undo() {
                    stringBuilder.append(deletedPart);
                    System.out.println("Операция 'setLength' была отменена");
                }
            };
            actionStack.add(action);
            return this;
        }
    }

    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.reverse();
                System.out.println("Операция 'reverse' была отменена");
            }
        };
        actionStack.add(action);
        return this;
    }

    // теперь при вызове undo(), если стек не пустой,
    // то извлекаем из него последнее действие
    // на экран печатается предупреждение об отмене операции
    public void undo() {
        if (actionStack.isEmpty() == false) {
            actionStack.pop().undo();
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }

    // просто для самопроверки работы setLength
    // а то там мне видно добавление пробелов
    public int length() {
        return stringBuilder.length();
    }
}
