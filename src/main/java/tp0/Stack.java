package tp0;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> elements = new LinkedList<>();

    // Vérifie si la pile est vide
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Ajoute un élément au sommet de la pile
    public void push(T item) {
        elements.addFirst(item);
    }

    // Retire et retourne l'élément au sommet de la pile
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.removeFirst();
    }

    // Retourne l'élément au sommet sans le retirer
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.getFirst();
    }

    // Retourne la taille de la pile
    public int size() {
        return elements.size();
    }
}
