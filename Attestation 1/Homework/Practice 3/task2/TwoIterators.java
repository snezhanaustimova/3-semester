package task2;

import java.util.*;

class TwoIterators<I> implements Iterator<I> {
    private Iterator<I> iterator1;
    private Iterator<I> iterator2;

    public TwoIterators (Iterator<I> iterator1, Iterator<I> iterator2) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
    }

    @Override
    public boolean hasNext() {
        while (iterator1.hasNext()) {
            return true;
        }
        while (iterator2.hasNext()) {
            return true;
        }
        return false;
    }

    @Override
    public I next() {
        if (!hasNext()) throw new NoSuchElementException();
        while (iterator1.hasNext()) {
            return iterator1.next();
        }
        while (iterator2.hasNext()) {
            return iterator2.next();
        }
        return null;
    }
}
