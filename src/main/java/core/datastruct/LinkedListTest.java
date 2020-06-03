package core.datastruct;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void iterator() {
    }
}