public class Main {
    public static void main(String[] args) {
        MyLinkedList <Integer> list = new MyLinkedList<>();

        list.add(2);

        System.out.println(list);


        MyArrayList<String> list2 = new MyArrayList<>();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Orange");

        System.out.println("Size: " + list2.size()); // Выводит: Size: 3

        System.out.println("Element at index 1: " + list2.get(1)); // Выводит: Element at index 1: Banana

        list.remove(0);
        System.out.println("Element at index 0 after removal: " + list2.get(0)); // Выводит: Element at index 0 after removal: Banana

        list.clear();
        System.out.println("Size after clear: " + list2.size()); // Выводит: Size after clear: 0



        MyQueue<String> queue = new MyQueue<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println(queue.peek()); // Выводит "A"
        System.out.println(queue.poll()); // Выводит "A"

        System.out.println(queue.size()); // Выводит 2

        queue.clear();
        System.out.println(queue.size()); // Выводит 0



        MyStack<Integer> stack = new MyStack<>();

        // Добавляем элементы в стек
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Выводим размер стека
        System.out.println("Размер стека: " + stack.size()); // Вывод: Размер стека: 3

        // Получаем верхний элемент стека (LIFO)
        int topElement = stack.peek();
        System.out.println("Верхний элемент стека: " + topElement); // Вывод: Верхний элемент стека: 30

        // Удаляем элемент под индексом 1
        stack.remove(1);

        // Выводим размер стека после удаления
        System.out.println("Размер стека после удаления: " + stack.size()); // Вывод: Размер стека после удаления: 2

        // Извлекаем верхний элемент стека
        int poppedElement = stack.pop();
        System.out.println("Извлеченный элемент: " + poppedElement); // Вывод: Извлеченный элемент: 30

        // Выводим размер стека после извлечения
        System.out.println("Размер стека после извлечения: " + stack.size()); // Вывод: Размер стека после извлечения: 1

        // Очищаем стек
        stack.clear();

        // Выводим размер стека после очистки
        System.out.println("Размер стека после очистки: " + stack.size()); // Вывод: Размер стека после очистки: 0


        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Добавление элементов
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        // Получение значения по ключу
        Integer appleValue = map.get("apple");
        System.out.println("Value for 'apple': " + appleValue); // Вывод: Value for 'apple': 10

        // Обновление значения
        map.put("banana", 25);

        // Удаление элемента
        map.remove("cherry");

        // Размер коллекции
        int size = map.size();
        System.out.println("Size of the map: " + size); // Вывод: Size of the map: 2

        // Очистка коллекции
        map.clear();
        size = map.size();
        System.out.println("Size of the map after clear: " + size); // Вывод: Size of the map after clear: 0
    }


}