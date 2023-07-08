public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> nodeToRemove = getNode(index);

        if (nodeToRemove == head) {
            head = nodeToRemove.getNext();
        }

        if (nodeToRemove == tail) {
            tail = nodeToRemove.getPrevious();
        }

        Node<T> previousNode = nodeToRemove.getPrevious();
        Node<T> nextNode = nodeToRemove.getNext();

        if (previousNode != null) {
            previousNode.setNext(nextNode);
        }

        if (nextNode != null) {
            nextNode.setPrevious(previousNode);
        }

        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> node = getNode(index);
        return node.getValue();
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            current = current.getNext();
            currentIndex++;
        }

        return current;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
