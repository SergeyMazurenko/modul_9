public class MyArrayList<T> {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10]; // Начальный размер массива
        size = 0;
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // Сдвигаем элементы после удаляемого индекса на одну позицию влево
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null; // Очищаем последний элемент
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (T) array[index];
    }

    private void ensureCapacity(int capacity) {
        if (capacity > array.length) {
            int newCapacity = array.length * 2; // Увеличиваем размер массива вдвое
            if (newCapacity < capacity) {
                newCapacity = capacity;
            }

            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}
