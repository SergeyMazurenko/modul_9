public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);

        if (table[index] == null) {
            table[index] = new Node<>(key, value);
            size++;
        } else {
            Node<K, V> currentNode = table[index];
            Node<K, V> prevNode = null;

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value; // Update existing key's value
                    return;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            prevNode.next = new Node<>(key, value);
            size++;
        }
    }

    public void remove(K key) {
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);

        Node<K, V> currentNode = table[index];
        Node<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    table[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);

        Node<K, V> currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null; // Key not found
    }

    private int getIndex(int hashCode) {
        return Math.abs(hashCode) % table.length;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}