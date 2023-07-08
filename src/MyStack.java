public class MyStack<E> {
    private Node<E> top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            top = top.next;
        } else {
            Node<E> current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    public E pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        E value = top.value;
        top = top.next;
        size--;
        return value;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
            next = null;
        }
    }
}