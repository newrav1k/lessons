package JavaRush.JavaSyntaxZero;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public StringLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node node = new Node();
        node.value = value;

        if (first.next == null && last.prev == null) {
            first.next = node;
            last.prev = node;
        }
        else {
         first = last.prev;
         last.prev = node;
        }

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}

// *  *
// * 1 *
// * 1 2 *
// * 1 2 3 *