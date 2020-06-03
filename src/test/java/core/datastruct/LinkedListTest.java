package core.datastruct;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        final LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        assertEquals("a,b,c,", ll.toString());
    }

    @Test
    void insertBefore() {
        final LinkedList<String> ll = new LinkedList<>();
        ll.insertBefore("a");
        ll.insertBefore("b");
        ll.insertBefore("c");
        assertEquals("c,b,a,", ll.toString());
    }

    @Test
    void size() {
        final LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.insertBefore("a");
        ll.insertBefore("b");
        ll.insertBefore("c");

        assertEquals(6, ll.size());
    }

    @Test
    void get() {
        final LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.insertBefore("d");
        ll.insertBefore("e");
        ll.insertBefore("f");

        assertEquals("f",ll.get(0));
        assertEquals("e",ll.get(1));
        assertEquals("d",ll.get(2));
        assertEquals("a",ll.get(3));
        assertEquals("b",ll.get(4));
        assertEquals("c",ll.get(5));

    }

    @Test
    void remove() {
        final LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");
        ll.add("e");
        ll.add("f");
        ll.remove(2);
        ll.remove(2);
        assertEquals("a,b,e,f,", ll.toString());
    }

    @Test
    void iterator() {
        final LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");
        ll.add("e");
        ll.add("f");

        final StringBuilder sb = new StringBuilder();
        final Iterator<String> iterator = ll.iterator();
        while(iterator.hasNext()) {
            sb.append(iterator.next()).append("|");
        }
        assertEquals("a|b|c|d|e|f|", sb.toString());


    }
}