package JavaRush.JavaSyntaxZero;

import java.util.LinkedList;

public class StackOnList<T> {
    private LinkedList<T> list = new LinkedList<>();

    // Помещение элемента на вершину стека
    public void push(T element) {
        list.addFirst(element);
    }

    // Извлечение элемента с вершины стека
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return list.removeFirst();
    }

    // Проверка, пуст ли стек
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Возвращает элемент с вершины стека, не удаляя его
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return list.getFirst();
    }

    // Возвращает размер стека
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        StackOnList<Integer> stack = new StackOnList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Размер стека: " + stack.size());
        System.out.println("Вершина стека: " + stack.peek());

        System.out.println("Извлечение элементов из стека:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}