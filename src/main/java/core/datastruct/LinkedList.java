package core.datastruct;

import java.util.Iterator;

public class LinkedList <T> {

    private Node<T> first;
    private Node<T> last;
    private int size;


    public void add(T t) {
        final Node node = new Node(t);
        if (last == null) {
            first = node;
        } else {
            node.after(last);
        }
        last = node;
        size++;
    }

    public void insertBefore(T t) {
        final Node node = new Node(t);
        if (first == null) {
            last = node;
        } else {
            node.before(first);
        }
        first = node;
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        int i = index;
        Node<T> n = this.first;
        while (i > 0) {
            i--;
            if (n == null) throw new IndexOutOfBoundsException();
            n = n.next;
        }
        return n.value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Iterator<T> iterator = this.iterator();
        while(iterator.hasNext()) {
            sb.append(iterator.next()).append(",");
        }
        return sb.toString();
    }

    public boolean remove(int index) {
        //TODO
        return false;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> n = LinkedList.this.first;
            @Override
            public boolean hasNext() {
                return n != null;
            }

            @Override
            public T next() {
                final T ret = n.value;
                n = n.next;
                return ret;
            }
        };
    }

    class Node<T> {
        public Node(T t) {
            this.value = t;
        }
        T value;
        Node<T> next;
        Node<T> prev;
        public void after(Node n) {
            this.prev = n;
            n.next = this;
        }

        public void before(Node n) {
            this.next = n;
            n.prev = this;
        }
    }

}
