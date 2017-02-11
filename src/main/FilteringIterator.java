package main;

import java.util.Iterator;

/**
 * Created by amritkar on 2/9/2017.
 */
public final class FilteringIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private IObjectTest matcher;
    private T nextMatch;

    public FilteringIterator(final Iterator<T> iterator, final IObjectTest matcher) {
        this.iterator = iterator;
        this.matcher = matcher;

        findNextMatch();
    }

    private void findNextMatch() {
        while(iterator.hasNext()) {
            T currentElement = iterator.next();
            if(matcher.test(currentElement)) {
                nextMatch = currentElement;
                return;
            }
        }
        this.nextMatch = null;
    }

    public boolean hasNext() {
        return nextMatch!=null;
    }

    public T next() {
        T returnValue = this.nextMatch;
        this.findNextMatch();
        return returnValue;
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove is not implemented for this filtered iterator");
    }
}
