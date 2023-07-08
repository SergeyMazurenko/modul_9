import java.util.ArrayList;

public class MyQueue<T> {
    private ArrayList<T> queue;

    public MyQueue() {
        queue = new ArrayList<>();
    }

    public void add(T value) {
        queue.add(value);
    }

    public void clear() {
        queue.clear();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.get(0);
    }

    public T poll() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.remove(0);
    }
}