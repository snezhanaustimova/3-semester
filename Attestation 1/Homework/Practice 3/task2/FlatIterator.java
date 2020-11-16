package task2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class FlatIterator implements Iterator<String> {
    private Stack<Iterator> iterators;
    private String next;
    private boolean hasNext;

    public FlatIterator(Iterator<?> iterator) {
        this.iterators = new Stack<Iterator>();
        iterators.push(iterator);
        updateNext();
    }

    private void updateNext() {
        if (iterators.empty()) {
            next = null;
            hasNext = false;
            return;
        }

        Iterator current = iterators.peek();

        if (current.hasNext()) {
            Object obj = current.next();
            if (obj instanceof String) {
                next = (String) obj;
                hasNext = true;
            } else if (obj instanceof  Iterator) {
                Iterator iterator = (Iterator) obj;
                iterators.push(iterator);
                updateNext();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            iterators.pop();
            updateNext();
        }
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public String next() throws NoSuchElementException {

        if (!hasNext) {
            throw new NoSuchElementException();
        }

        String toReturn = next;
        updateNext();
        return toReturn;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
