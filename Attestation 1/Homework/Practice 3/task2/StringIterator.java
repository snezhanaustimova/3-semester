package task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

class StringIterator implements Iterator<String>{
    private Iterator iterator;
    private StringIterator stringIterator;

    public StringIterator(Iterator myIterator) {
        this.iterator = myIterator;
    }

    @Override
    public boolean hasNext() {
        if (iterator.hasNext()) {
            return true;
        }
        if (stringIterator != null) {
            return stringIterator.hasNext();
        }
        return false;
    }

    @Override
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();

        Object object = null;
        if (stringIterator != null && stringIterator.hasNext()) {
            object = stringIterator.next();
        }
        if (iterator.hasNext() && object == null) {
            object = iterator.next();

            if (object instanceof Iterator && ((Iterator) object).hasNext()) {
                stringIterator = new StringIterator((Iterator) object);
            }
        }
        if (object instanceof Iterator) {
            object = next();
        }
        return (String) object;
    }
}
