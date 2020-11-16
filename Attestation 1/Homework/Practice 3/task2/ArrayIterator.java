package task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class ArrayIterator<T> implements Iterable {
    private T[][] array;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i, j;
            @Override
            public boolean hasNext() {
                for (int i = this.i; i < array.length; i++){
                    for (j = this.j; j < array[i].length; j++){
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T t = array[i][j];
                j++;
                for (int i = this.i; i < array.length; i++) {
                    if (i == this.i) {
                        for (int j = this.j; j < array[i].length; j++) {
                            this.i = i;
                            this.j = j;
                            return t;
                        }
                    } else {
                        for (int j = 0; j < array[i].length; j++) {
                            this.i = i;
                            this.j = j;
                            return t;
                        }
                    }
                }
                return t;
            }
        };
    }
}
